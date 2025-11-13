package com.example.utsmobileapp_152022137_barajabarsya;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class CuacaFragment extends Fragment {

    private ImageView weatherAnimation;
    private TextView tvWeatherCondition, tvTemperature, tvFeelsLike;
    private TextView tvHumidity, tvWindSpeed, tvPressure, tvVisibility, tvUVIndex, tvSunriseSunset;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cuaca, container, false);

        // Initialize views
        initViews(view);

        // Set static weather data
        setWeatherData();

        return view;
    }

    private void initViews(View view) {
        weatherAnimation = view.findViewById(R.id.weatherAnimation);
        tvWeatherCondition = view.findViewById(R.id.tvWeatherCondition);
        tvTemperature = view.findViewById(R.id.tvTemperature);
        tvFeelsLike = view.findViewById(R.id.tvFeelsLike);

        tvHumidity = view.findViewById(R.id.tvHumidity);
        tvWindSpeed = view.findViewById(R.id.tvWindSpeed);
        tvPressure = view.findViewById(R.id.tvPressure);
        tvVisibility = view.findViewById(R.id.tvVisibility);
        tvUVIndex = view.findViewById(R.id.tvUVIndex);
        tvSunriseSunset = view.findViewById(R.id.tvSunriseSunset);
    }

    private void setWeatherData() {
        // Set static weather data
        tvWeatherCondition.setText("Cerah Berawan");
        tvTemperature.setText("28°C");
        tvFeelsLike.setText("Terasa seperti 30°C");

        tvHumidity.setText("65%");
        tvWindSpeed.setText("12 km/jam");
        tvPressure.setText("1013 hPa");
        tvVisibility.setText("10 km");
        tvUVIndex.setText("Sedang");
        tvSunriseSunset.setText("05:45 / 17:30");

        // Set weather icon based on condition
        weatherAnimation.setImageResource(R.drawable.ic_sunny);
    }
}