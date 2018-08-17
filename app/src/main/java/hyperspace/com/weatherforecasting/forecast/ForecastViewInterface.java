package hyperspace.com.weatherforecasting.forecast;

import hyperspace.com.weatherforecasting.model.ResponseForecast;

public interface ForecastViewInterface {

    void hideLoading();

    void showForecast(ResponseForecast responseForecast);

    void showError(String s);
}
