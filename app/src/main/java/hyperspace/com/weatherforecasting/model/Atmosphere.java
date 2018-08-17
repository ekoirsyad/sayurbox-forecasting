package hyperspace.com.weatherforecasting.model;

import com.google.gson.annotations.SerializedName;

public class Atmosphere{

	@SerializedName("rising")
	private String rising;

	@SerializedName("visibility")
	private String visibility;

	@SerializedName("humidity")
	private String humidity;

	@SerializedName("pressure")
	private String pressure;

	public void setRising(String rising){
		this.rising = rising;
	}

	public String getRising(){
		return rising;
	}

	public void setVisibility(String visibility){
		this.visibility = visibility;
	}

	public String getVisibility(){
		return visibility;
	}

	public void setHumidity(String humidity){
		this.humidity = humidity;
	}

	public String getHumidity(){
		return humidity;
	}

	public void setPressure(String pressure){
		this.pressure = pressure;
	}

	public String getPressure(){
		return pressure;
	}

	@Override
 	public String toString(){
		return 
			"Atmosphere{" + 
			"rising = '" + rising + '\'' + 
			",visibility = '" + visibility + '\'' + 
			",humidity = '" + humidity + '\'' + 
			",pressure = '" + pressure + '\'' + 
			"}";
		}
}