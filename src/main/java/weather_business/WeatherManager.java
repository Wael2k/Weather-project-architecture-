package weather_business;

import org.springframework.stereotype.Service;
import weather_domain.entities.WeatherConfig;
import weather_domain.entities.WeatherInfo;
import weather_domain.service.IWeatherIn;
import weather_domain.service.IWeatherOut;

@Service
public class WeatherManager  {
    public WeatherConfig weatherConfig;
    public WeatherInfo weatherInfo;
    public IWeatherIn weatherIn;
    public IWeatherOut weatherOut;

    public WeatherManager(){

    }
atu

}
