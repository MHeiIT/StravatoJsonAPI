package at.deppn.dao;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import at.deppn.types.AthleteActivities;

public class GetRequests {
	public List<AthleteActivities> getAthleteActivities(long before, long after, int page, int per_page,
			String access_token) {
		//System.out.println(access_token);
		List<AthleteActivities> aa = new ArrayList<AthleteActivities>();
		Type listType = new TypeToken<List<AthleteActivities>>() {
		}.getType();

		try {
			while (true) {
				String link = "https://www.strava.com/api/v3/athlete/activities?before=" + before + "&after=" + after
						+ "&page=" + page + "&per_page=" + per_page;
				URL url = new URL(link);

				HttpURLConnection con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("GET");
				con.setRequestProperty("Content-Type", "application/json; utf-8");
				con.setRequestProperty("Accept", "application/json");
				con.setRequestProperty("Authorization", "Bearer " + access_token);
				con.setDoOutput(true);
				
				Reader reader = new InputStreamReader(con.getInputStream(), "UTF-8");
				Gson gson = new Gson();

				List<AthleteActivities> temp = gson.fromJson(reader, listType);
				if (temp.size() == 0) {
					return aa;
				}

				aa.addAll(temp);
				page++;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		// return null;

	}
}
