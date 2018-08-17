package hyperspace.com.weatherforecasting.model;

import com.google.gson.annotations.SerializedName;

public class ResponseForecast{

	@SerializedName("query")
	private Query query;

	public void setQuery(Query query){
		this.query = query;
	}

	public Query getQuery(){
		return query;
	}

	@Override
 	public String toString(){
		return 
			"ResponseForecast{" + 
			"query = '" + query + '\'' + 
			"}";
		}
}