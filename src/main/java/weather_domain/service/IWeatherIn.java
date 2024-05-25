package weather_domain.service;

import weather_domain.entities.WeatherInfo;

public interface IWeatherIn {
   public void  writeWeatherValue(String valueType, String value);
}
