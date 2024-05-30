package software_architecture_project.demo.weather_domain.service;

import software_architecture_project.demo.weather_domain.entities.WeatherConfig;

public interface IWeatherOut {
     void startCollect();
     void stopCollect();


     WeatherConfig weatherConfigGetWeatherConfig();
     void setWeatherConfig(WeatherConfig weatherConfig);

}
