package at.deppn.dao;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

import at.deppn.types.AccessToken;

public class PostRequests {
	public String getAccess_token(int client_id, String client_secret, String grant_type, String refresh_token) {

		String link = "https://www.strava.com/api/v3/oauth/token?client_id=" + client_id + "&client_secret="
				+ client_secret + "&grant_type=" + grant_type + "&refresh_token=" + refresh_token;

		try {
			URL url = new URL(link);

			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);

			Reader reader = new InputStreamReader(con.getInputStream(), "UTF-8");
			Gson gson = new Gson();
			AccessToken pat = gson.fromJson(reader, AccessToken.class);

			return pat.getAccess_token();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
