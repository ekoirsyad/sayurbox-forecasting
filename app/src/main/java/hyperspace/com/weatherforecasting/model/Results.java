package hyperspace.com.weatherforecasting.model;

import com.google.gson.annotations.SerializedName;

public class Results{

	@SerializedName("channel")
	private Channel channel;

	public void setChannel(Channel channel){
		this.channel = channel;
	}

	public Channel getChannel(){
		return channel;
	}

	@Override
 	public String toString(){
		return 
			"Results{" + 
			"channel = '" + channel + '\'' + 
			"}";
		}
}