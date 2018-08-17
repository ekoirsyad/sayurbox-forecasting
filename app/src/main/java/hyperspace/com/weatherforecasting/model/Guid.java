package hyperspace.com.weatherforecasting.model;

import com.google.gson.annotations.SerializedName;

public class Guid{

	@SerializedName("isPermaLink")
	private String isPermaLink;

	public void setIsPermaLink(String isPermaLink){
		this.isPermaLink = isPermaLink;
	}

	public String getIsPermaLink(){
		return isPermaLink;
	}

	@Override
 	public String toString(){
		return 
			"Guid{" + 
			"isPermaLink = '" + isPermaLink + '\'' + 
			"}";
		}
}