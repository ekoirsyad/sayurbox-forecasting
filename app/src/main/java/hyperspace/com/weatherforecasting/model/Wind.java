package hyperspace.com.weatherforecasting.model;

import com.google.gson.annotations.SerializedName;

public class Wind{

	@SerializedName("chill")
	private String chill;

	@SerializedName("speed")
	private String speed;

	@SerializedName("direction")
	private String direction;

	public void setChill(String chill){
		this.chill = chill;
	}

	public String getChill(){
		return chill;
	}

	public void setSpeed(String speed){
		this.speed = speed;
	}

	public String getSpeed(){
		return speed;
	}

	public void setDirection(String direction){
		this.direction = direction;
	}

	public String getDirection(){
		return direction;
	}

	@Override
 	public String toString(){
		return 
			"Wind{" + 
			"chill = '" + chill + '\'' + 
			",speed = '" + speed + '\'' + 
			",direction = '" + direction + '\'' + 
			"}";
		}
}