package at.deppn.users;

import java.time.LocalDate;

import com.google.gson.annotations.SerializedName;

public class SmallDateScore {
	@SerializedName("date")
	LocalDate date;
	@SerializedName("users")
	Users[] users;
	
	public SmallDateScore(Users[] users) {
		this.users = users;
		this.date = LocalDate.now();
	}
	
}
