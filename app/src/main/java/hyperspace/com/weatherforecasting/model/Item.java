package hyperspace.com.weatherforecasting.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Item{

	@SerializedName("condition")
	private Condition condition;

	@SerializedName("link")
	private String link;

	@SerializedName("description")
	private String description;

	@SerializedName("guid")
	private Guid guid;

	@SerializedName("forecast")
	private List<ForecastItem> forecast;

	@SerializedName("title")
	private String title;

	@SerializedName("pubDate")
	private String pubDate;

	@SerializedName("lat")
	private String lat;

	@SerializedName("long")
	private String jsonMemberLong;

	public void setCondition(Condition condition){
		this.condition = condition;
	}

	public Condition getCondition(){
		return condition;
	}

	public void setLink(String link){
		this.link = link;
	}

	public String getLink(){
		return link;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setGuid(Guid guid){
		this.guid = guid;
	}

	public Guid getGuid(){
		return guid;
	}

	public void setForecast(List<ForecastItem> forecast){
		this.forecast = forecast;
	}

	public List<ForecastItem> getForecast(){
		return forecast;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setPubDate(String pubDate){
		this.pubDate = pubDate;
	}

	public String getPubDate(){
		return pubDate;
	}

	public void setLat(String lat){
		this.lat = lat;
	}

	public String getLat(){
		return lat;
	}

	public void setJsonMemberLong(String jsonMemberLong){
		this.jsonMemberLong = jsonMemberLong;
	}

	public String getJsonMemberLong(){
		return jsonMemberLong;
	}

	@Override
 	public String toString(){
		return 
			"Item{" + 
			"condition = '" + condition + '\'' + 
			",link = '" + link + '\'' + 
			",description = '" + description + '\'' + 
			",guid = '" + guid + '\'' + 
			",forecast = '" + forecast + '\'' + 
			",title = '" + title + '\'' + 
			",pubDate = '" + pubDate + '\'' + 
			",lat = '" + lat + '\'' + 
			",long = '" + jsonMemberLong + '\'' + 
			"}";
		}
}