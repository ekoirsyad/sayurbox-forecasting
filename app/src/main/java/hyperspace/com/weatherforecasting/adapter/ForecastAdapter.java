package hyperspace.com.weatherforecasting.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import hyperspace.com.weatherforecasting.R;
import hyperspace.com.weatherforecasting.model.ForecastItem;

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ViewHolder> {

    private List<ForecastItem> channelList;
    private Context context;
    private Typeface typeface;

    public ForecastAdapter(List<ForecastItem> channelList, Context context) {
        this.channelList = channelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_weather, parent, false);
        typeface = Typeface.createFromAsset(parent.getContext().getAssets(), "fonts/weathericons-regular-webfont.ttf");
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String date = channelList.get(position).getDate();
        String text = channelList.get(position).getText();
        String code = channelList.get(position).getCode();
        String TAG = "adapter";
        int code_res = context.getResources().getIdentifier("wi_yahoo_" + code, "string", context.getPackageName());
        Log.e(TAG, "onBindViewHolder: " + code_res);

        holder.imageForecastWeather.setTypeface(typeface);
        holder.imageForecastWeather.setText(code_res);
        holder.tvForecastDate.setText(date);
        holder.tvForecastInformation.setText(text);
    }

    @Override
    public int getItemCount() {
        return channelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_forecast_weather)
        TextView imageForecastWeather;
        @BindView(R.id.tv_forecast_date)
        TextView tvForecastDate;
        @BindView(R.id.tv_forecast_information)
        TextView tvForecastInformation;
        @BindView(R.id.cv_weather)
        CardView cvWeather;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
