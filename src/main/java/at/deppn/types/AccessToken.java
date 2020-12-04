package at.deppn.types;

import com.google.gson.annotations.SerializedName;

public class AccessToken {
	@SerializedName("token_type")
	private String token_type;
	@SerializedName("access_token")
	private String access_token;
	@SerializedName("expires_at")
	private double expires_at;
	@SerializedName("expires_inn")
	private double expires_in;
	@SerializedName("refresh_token")
	private String refresh_token;

	public String getAccess_token() {
		return access_token;
	}

	public String getToken_type() {
		return token_type;
	}

	public double getExpires_at() {
		return expires_at;
	}

	public double getExpires_in() {
		return expires_in;
	}

	public String getRefresh_token() {
		return refresh_token;
	}
}
