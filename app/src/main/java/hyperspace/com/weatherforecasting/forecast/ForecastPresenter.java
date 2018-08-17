package hyperspace.com.weatherforecasting.forecast;

import android.util.Log;

import hyperspace.com.weatherforecasting.model.ResponseForecast;
import hyperspace.com.weatherforecasting.network.NetworkApi;
import hyperspace.com.weatherforecasting.network.NetworkClient;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class ForecastPresenter implements ForecastPresenterInterface {

    private ForecastViewInterface forecastViewInterface;
    private String TAG = "ForecastPresenter";


    ForecastPresenter(ForecastViewInterface forecastViewInterface) {
        this.forecastViewInterface = forecastViewInterface;
    }

    @Override
    public void getForecast() {
        getObservable().subscribe(getObserver());
    }

    private Observable<ResponseForecast> getObservable() {
        return NetworkClient.getRetrofit().create(NetworkApi.class)
                .getWeather()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private DisposableObserver<ResponseForecast> getObserver() {
        return new DisposableObserver<ResponseForecast>() {
            @Override
            public void onNext(ResponseForecast responseForecast) {
                Log.d(TAG, "onNext() called with: responseForecast = [" + responseForecast + "]");
                forecastViewInterface.showForecast(responseForecast);
                forecastViewInterface.hideLoading();
            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, "onError: ", e);
                e.printStackTrace();
                forecastViewInterface.showError("Error Fetch Data");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Complete Load Data");
            }
        };
    }
}
