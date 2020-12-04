package at.deppen.data;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import at.deppn.dao.GetRequests;
import at.deppn.types.AthleteActivities;
import at.deppn.users.Users;

public class Data {
	final private int page = 1;
	final private int perpage = 50;

	public Users[] getUsers(String path) {
		Gson gson = new Gson();

		try {
			Reader reader = Files.newBufferedReader(Paths.get(path));

			Users[] userarray = gson.fromJson(reader, Users[].class);

			for (int i = 0; i < userarray.length; i++) {
				userarray[i] = calculateUser(userarray[i]);
			}

			return userarray;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public Users calculateUser(Users user) {
		double points = 0;
		GetRequests gr = new GetRequests();
		Calculate calc = new Calculate();

		List<AthleteActivities> List = gr.getAthleteActivities(calc.getBefore(), calc.getAfter(), this.page,
				this.perpage, user.getAccess_token());

		for (AthleteActivities temp : List) {
			points += calc.getPoints(temp);
		}
		user.setPoints(points);
		return user;
	}

	public void writeJson(Users[] users, String path) {
		ExclusionStrategy strategy = new ExclusionStrategy() {
		    @Override
		    public boolean shouldSkipClass(Class<?> clazz) {
		        return false;
		    }

		    @Override
		    public boolean shouldSkipField(FieldAttributes field) {
		        return field.getAnnotation(Exclude.class) != null;
		    }
		};
		
		Gson gson = new GsonBuilder().addSerializationExclusionStrategy(strategy).create();
		String commentString = gson.toJson(users);

		try {
			FileWriter myWriter = new FileWriter(path);
			myWriter.write(commentString);
			myWriter.close();
			System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	
	
	@Retention(RetentionPolicy.RUNTIME)
	@Target(ElementType.FIELD)
	public @interface Exclude {}
	
}
