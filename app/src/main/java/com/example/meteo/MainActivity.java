package com.example.meteo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.meteo.model.FakeForecastProvider;
import com.example.meteo.model.IForecastProvider;
import com.example.meteo.model.Location;
import com.example.meteo.model.Weather;

import java.text.MessageFormat;

public class MainActivity extends AppCompatActivity {
    private ImageButton locationButton;
    private TextView locationLabel;
    private EditText cityName;
    private TextView temperatureLabel;
    private TextView humidityLabel;
    private TextView windSpeedLabel;
    private TextView windDirectionLabel;
    private TextView precipitationsLabel;
    private IForecastProvider forecastProvider = new FakeForecastProvider();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elementsInitialisation();

        locationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO : régler le problème de cet événement qui ne se lance pas
                onLocationButtonClick();
            }
        });

        setContentView(R.layout.activity_main);
    }

    // Initialise tous les attributs liés à des éléments visuels
    private void elementsInitialisation() {
        this.locationButton = findViewById(R.id.locationButton);
        locationLabel = findViewById(R.id.coordinatesLabel);
        cityName = findViewById(R.id.cityName);
        temperatureLabel = findViewById(R.id.temperatureValueLabel);
        humidityLabel = findViewById(R.id.humidityValueLabel);
        windSpeedLabel = findViewById(R.id.windSpeedValueLabel);
        windDirectionLabel = findViewById(R.id.windDirectionValueLabel);
        precipitationsLabel = findViewById(R.id.precipitationsValueLabel);
    }

    private void onLocationButtonClick() {
        Location tmpLoc = new Location();
        tmpLoc.setCity(cityName.getText().toString());
        tmpLoc.setLatitude((float) 47.311);
        tmpLoc.setLongitude((float) 5.069);

        showWeather(forecastProvider.getForecast(tmpLoc).getForecast(0));
        showLocation(tmpLoc);
    }

    private void showWeather(Weather weather) {
        temperatureLabel.setText(MessageFormat.format("{0} °C", weather.getTemperature()));
        humidityLabel.setText(MessageFormat.format("{0} %", weather.getHumidity()));
        windSpeedLabel.setText(MessageFormat.format("{0} km/h", weather.getWindSpeed()));
        windDirectionLabel.setText(weather.getWindDirection());
        precipitationsLabel.setText(MessageFormat.format("{0} mm", Float.toString(weather.getPrecipitation())));
    }

    private void showLocation(Location loc) {

    }
}
