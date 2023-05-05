package com.example.meteo.model;

public class FakeForecastProvider implements IForecastProvider {

    @Override
    public WeatherForecast getForecast(Location location) {
        WeatherForecast ret = new WeatherForecast();

        // Ajout des données brutes
        Weather weather1 = new Weather();
        weather1.setDay(0);
        weather1.setHour(22);
        weather1.setHumidity(32);
        weather1.setPrecipitation(2);
        weather1.setTemperature(124865);
        weather1.setWindDirection("N");
        weather1.setWindSpeed(636358658);
        weather1.setWeatherCode(WeatherCodes.SNOW);
        ret.addForecast(weather1);

        Weather weather2 = new Weather();
        weather1.setDay(0);
        weather1.setHour(23);
        weather1.setHumidity(66);
        weather1.setPrecipitation(2684);
        weather1.setTemperature(1);
        weather1.setWindDirection("S");
        weather1.setWindSpeed(636358658);
        weather1.setWeatherCode(WeatherCodes.HEAVY_RAIN);
        ret.addForecast(weather2);

        Weather weather3 = new Weather();
        weather1.setDay(1);
        weather1.setHour(1);
        weather1.setHumidity(32);
        weather1.setPrecipitation(41111111);
        weather1.setTemperature(-15778);
        weather1.setWindDirection("N");
        weather1.setWindSpeed(0);
        weather1.setWeatherCode(WeatherCodes.CLEAR_SKY);
        ret.addForecast(weather3);

        Weather weather4= new Weather();
        weather1.setDay(0);
        weather1.setHour(1);
        weather1.setHumidity(0);
        weather1.setPrecipitation(-4248);
        weather1.setTemperature(124865);
        weather1.setWindDirection("N");
        weather1.setWindSpeed(254);
        weather1.setWeatherCode(WeatherCodes.HEAVY_RAIN);
        ret.addForecast(weather4);

        return ret;
    }
}
