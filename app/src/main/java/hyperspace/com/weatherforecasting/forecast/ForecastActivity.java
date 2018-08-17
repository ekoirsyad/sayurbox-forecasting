package hyperspace.com.weatherforecasting.forecast;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import hyperspace.com.weatherforecasting.R;
import hyperspace.com.weatherforecasting.adapter.ForecastAdapter;
import hyperspace.com.weatherforecasting.model.ResponseForecast;
import hyperspace.com.weatherforecasting.util.GridSpacingItemDecoration;

public class ForecastActivity extends AppCompatActivity implements ForecastViewInterface {

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;
    @BindView(R.id.tv_location)
    TextView tvLocation;
    @BindView(R.id.tv_wind_information)
    TextView tvWindInformation;
    @BindView(R.id.tv_atmosphere_information)
    TextView tvAtmosphereInformation;
    @BindView(R.id.rv_forecast)
    RecyclerView rvForecast;

    String TAG = "ForecastActivity";
    RecyclerView.Adapter adapter;
    ForecastPresenter forecastPresenter;
    @BindView(R.id.image_current_weather)
    TextView imageCurrentWeather;
    private Typeface typeface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        typeface = Typeface.createFromAsset(getAssets(), "fonts/weathericons-regular-webfont.ttf");

        setUpMvp();
        setUpView();
        getForecastList();
    }

    private void getForecastList() {
        forecastPresenter.getForecast();
    }

    private void setUpView() {
        rvForecast.setLayoutManager(new GridLayoutManager(this, 1));
        rvForecast.addItemDecoration(new GridSpacingItemDecoration(this, 1, 10, true));
    }

    private void setUpMvp() {
        forecastPresenter = new ForecastPresenter(this);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showForecast(ResponseForecast responseForecast) {
        if (responseForecast != null) {
            String location = responseForecast.getQuery().getResults().getChannel().getLocation().getCountry();
            String windSpeed = "Wind speed: "+ responseForecast.getQuery().getResults().getChannel().getWind().getSpeed();
            String atmosphere = "Humidity: " + responseForecast.getQuery().getResults().getChannel().getAtmosphere().getHumidity();
            String id = responseForecast.getQuery().getResults().getChannel().getItem().getCondition().getCode();

            int id_res = this.getResources().getIdentifier("wi_yahoo_" + id, "string", this.getPackageName());

            imageCurrentWeather.setTypeface(typeface);
            imageCurrentWeather.setText(id_res);

            tvLocation.setTextSize(24);
            tvWindInformation.setTextSize(18);
            tvAtmosphereInformation.setTextSize(18);

            tvLocation.setText(location);
            tvWindInformation.setText(windSpeed);
            tvAtmosphereInformation.setText(atmosphere);

            Log.d(TAG, "showForecast() called with: responseForecast = [" + responseForecast + "]");
            adapter = new ForecastAdapter(responseForecast.getQuery().getResults().getChannel().getItem().getForecast(), ForecastActivity.this);
            rvForecast.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        } else {

            Log.d(TAG, "Response Null");

        }
    }

    @Override
    public void showError(String s) {

    }
}
