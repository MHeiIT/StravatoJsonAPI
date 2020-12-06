package at.deppen.data;

import java.io.File;
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
import at.deppn.users.SmallDateScore;
import at.deppn.users.Users;

public class Datamake {
	final private int page = 1;
	final private int perpage = 50;

	public Users[] getUsers(int ay, int am, int ad, String path) {
		Gson gson = new Gson();

		try {
			Reader reader = Files.newBufferedReader(Paths.get(path));

			Users[] userarray = gson.fromJson(reader, Users[].class);

			for (int i = 0; i < userarray.length; i++) {
				userarray[i] = calculateUser(ay, am, ad, userarray[i]);
			}

			return userarray;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public Users calculateUser(int ay, int am, int ad, Users user) {
		double points = 0;
		GetRequests gr = new GetRequests();
		Calculate calc = new Calculate();

		List<AthleteActivities> List = gr.getAthleteActivities(calc.getBefore(), calc.getAfter(ay, am, ad), this.page,
				this.perpage, user.getAccess_token());

		for (AthleteActivities temp : List) {
			points += calc.getPoints(temp);
		}
		user.setPoints(Math.round(points* 100.0)/100.0);
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
		SmallDateScore sds = new SmallDateScore(users);
		Gson gson1 = new Gson();
		Gson gson = new GsonBuilder().addSerializationExclusionStrategy(strategy).create();
		String commentString = "["+gson.toJson(sds)+"]";
		File tempFile = new File(path);
		if (tempFile.exists()) {
			try {
				Reader reader = Files.newBufferedReader(Paths.get(path));

				SmallDateScore[] userarray = gson1.fromJson(reader, SmallDateScore[].class);
				SmallDateScore[] temp = new SmallDateScore[userarray.length+1];
				temp[0] = sds;
				for (int i = 1; i<userarray.length+1;i++) {
					temp[i] = userarray[i-1];
				}
				
				commentString = gson.toJson(temp);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		
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
	public @interface Exclude {
	}

}
