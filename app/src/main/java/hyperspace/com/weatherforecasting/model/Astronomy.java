package hyperspace.com.weatherforecasting.model;

import com.google.gson.annotations.SerializedName;

public class Astronomy{

	@SerializedName("sunrise")
	private String sunrise;

	@SerializedName("sunset")
	private String sunset;

	public void setSunrise(String sunrise){
		this.sunrise = sunrise;
	}

	public String getSunrise(){
		return sunrise;
	}

	public void setSunset(String sunset){
		this.sunset = sunset;
	}

	public String getSunset(){
		return sunset;
	}

	@Override
 	public String toString(){
		return 
			"Astronomy{" + 
			"sunrise = '" + sunrise + '\'' + 
			",sunset = '" + sunset + '\'' + 
			"}";
		}
}