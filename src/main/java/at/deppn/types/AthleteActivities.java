package at.deppn.types;

import com.google.gson.annotations.SerializedName;

public class AthleteActivities {
	@SerializedName("resource_state")
	private double resource_state;
	@SerializedName("name")
	private String name;
	@SerializedName("distance")
	private double distance;
	@SerializedName("moving_time")
	private double moving_time;
	@SerializedName("elapsed_time")
	private double elapsed_time;
	@SerializedName("total_elevation_gain")
	private double total_elevation_gain;
	@SerializedName("type")
	private String type;
	@SerializedName("id")
	private double id;
	@SerializedName("external_id")
	private String external_id;
	@SerializedName("upload_id")
	private double upload_id;
	@SerializedName("start_date")
	private String start_date;
	@SerializedName("start_date_local")
	private String start_date_local;
	@SerializedName("timezone")
	private String timezone;
	@SerializedName("utc_offset")
	private double utc_offset;
	@SerializedName("average_speed")
	private double average_speed;
	@SerializedName("max_speed")
	private double max_speed;
	@SerializedName("average_cadence")
	private double average_cadence;
	@SerializedName("average_watts")
	private double average_watts;
	@SerializedName("weighted_average_watts")
	private double weighted_average_watts;
	@SerializedName("kilojoules")
	private double kilojoules;
	@SerializedName("device_watts")
	private boolean device_watts;
	@SerializedName("has_heartrate")
	private boolean has_heartrate;
	@SerializedName("average_heartrate")
	private double average_heartrate;
	@SerializedName("max_heartrate")
	private double max_heartrate;
	@SerializedName("max_watts")
	private double max_watts;
	@SerializedName("pr_count")
	private double pr_count;
	@SerializedName("total_photo_count")
	private double total_photo_count;
	@SerializedName("elev_high")
	private double elev_high;
	@SerializedName("elev_low")
	private double elev_low;
	@SerializedName("has_kudoed")
	private boolean has_kudoed;
	@SerializedName("suffer_score")
	private double suffer_score;

	public double getResource_state() {
		return resource_state;
	}

	public String getName() {
		return name;
	}

	public double getDistance() {
		return distance;
	}

	public double getMoving_time() {
		return moving_time;
	}

	public double getElapsed_time() {
		return elapsed_time;
	}

	public double getTotal_elevation_gain() {
		return total_elevation_gain;
	}

	public String getType() {
		return type;
	}

	public double getId() {
		return id;
	}

	public String getExternal_id() {
		return external_id;
	}

	public double getUpload_id() {
		return upload_id;
	}

	public String getStart_date() {
		return start_date;
	}

	public String getStart_date_local() {
		return start_date_local;
	}

	public String getTimezone() {
		return timezone;
	}

	public double getUtc_offset() {
		return utc_offset;
	}

	public double getAverage_speed() {
		return average_speed;
	}

	public double getMax_speed() {
		return max_speed;
	}

	public double getAverage_cadence() {
		return average_cadence;
	}

	public double getAverage_watts() {
		return average_watts;
	}

	public double getWeighted_average_watts() {
		return weighted_average_watts;
	}

	public double getKilojoules() {
		return kilojoules;
	}

	public boolean isDevice_watts() {
		return device_watts;
	}

	public boolean isHas_heartrate() {
		return has_heartrate;
	}

	public double getAverage_heartrate() {
		return average_heartrate;
	}

	public double getMax_heartrate() {
		return max_heartrate;
	}

	public double getMax_watts() {
		return max_watts;
	}

	public double getPr_count() {
		return pr_count;
	}

	public double getTotal_photo_count() {
		return total_photo_count;
	}

	public double getElev_high() {
		return elev_high;
	}

	public double getElev_low() {
		return elev_low;
	}

	public boolean isHas_kudoed() {
		return has_kudoed;
	}

	public double getSuffer_score() {
		return suffer_score;
	}

}
