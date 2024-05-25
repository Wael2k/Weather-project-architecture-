package weather_domain.service;

import weather_domain.entities.WeatherConfig;

public interface IWeatherOut {
     void startCollect();

     WeatherConfig weatherConfigGetWeatherConfig();
     void setWeatherConfig(WeatherConfig weatherConfig);

}
