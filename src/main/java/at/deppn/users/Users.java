package at.deppn.users;

import com.google.gson.annotations.SerializedName;

import at.deppen.data.Data.Exclude;
import at.deppn.dao.PostRequests;

public class Users {
	@SerializedName("name")
	private String name;
	@Exclude
	@SerializedName("client_id")
	private int client_id;
	@Exclude
	@SerializedName("client_secret")
	private String client_secret;
	@Exclude
	@SerializedName("refresh_token")
	private String refresh_token;

	private double points;
	@Exclude
	private final String grant_type = "refresh_token";

	public String getName() {
		return name;
	}

	public int getClient_id() {
		return client_id;
	}

	public String getClient_secret() {
		return client_secret;
	}

	public String getGrant_type() {
		return grant_type;
	}

	public double getPoints() {
		return points;
	}

	public void setPoints(double points) {
		this.points = points;
	}

	public String getRefresh_token() {
		return refresh_token;
	}

	public String getAccess_token() {
		PostRequests r = new PostRequests();
		return r.getAccess_token(this.client_id, this.client_secret, this.grant_type, this.refresh_token);
	}

}
