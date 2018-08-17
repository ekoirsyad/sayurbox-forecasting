package hyperspace.com.weatherforecasting.network;

import hyperspace.com.weatherforecasting.model.ResponseForecast;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface NetworkApi {

    @GET("yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22chicago%2C%20IL%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys")
    Observable<ResponseForecast> getWeather();

}
