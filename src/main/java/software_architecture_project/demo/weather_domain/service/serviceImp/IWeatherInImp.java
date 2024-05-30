package software_architecture_project.demo.weather_domain.service.serviceImp;

import org.springframework.stereotype.Service;
import software_architecture_project.demo.weather_domain.entities.WeatherInfo;
import software_architecture_project.demo.weather_domain.service.IWeatherIn;
@Service
public class IWeatherInImp implements IWeatherIn {
    @Override
    public void display(WeatherInfo info) {
        StringBuilder displayMessage = new StringBuilder("Weather Information:\n");

        if (info.getTemperature() != 0) {
            displayMessage.append("Temperature: ").append(info.getTemperature()).append("°C\n");
        }
        if (info.getPression() != 0) {
            displayMessage.append("Pression: ").append(info.getPression()).append(" hPa\n");
        }
        if (info.getWind() != 0) {
            displayMessage.append("Wind: ").append(info.getWind()).append(" km/h\n");
        }
        if (info.getPrecipitation() != 0) {
            displayMessage.append("Precipitation: ").append(info.getPrecipitation()).append(" mm\n");
        }

        System.out.println(displayMessage.toString());
    }


    @Override
    public void writeWeatherValue(String valueType, String value) {

    }
}
