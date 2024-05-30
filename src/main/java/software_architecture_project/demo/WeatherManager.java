package software_architecture_project.demo;

import org.springframework.stereotype.Service;
import software_architecture_project.demo.weather_domain.entities.WeatherConfig;
import software_architecture_project.demo.weather_domain.entities.WeatherInfo;
import software_architecture_project.demo.weather_domain.service.IWeatherIn;
import software_architecture_project.demo.weather_domain.service.IWeatherOut;


import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class WeatherManager implements IWeatherIn, IWeatherOut {
    private WeatherConfig weatherConfig;
    private WeatherInfo info;
    private Timer polling;
    private Random random;
    public WeatherManager(){
        this.polling = new Timer();
        this.info = new WeatherInfo();
        this.random = new Random();
    }


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

    @Override
    public void startCollect() {
        polling.schedule(new TimerTask() {
            @Override
            public void run() {
                poll();
            }
        }, 3000, 3000);
    }

    @Override
    public WeatherConfig weatherConfigGetWeatherConfig() {
        return this.weatherConfig;
    }

    @Override
    public void setWeatherConfig(WeatherConfig weatherConfig) {
         this.weatherConfig = weatherConfig;
    }
    @Override
    public void stopCollect() {
        polling.cancel();
        polling = new Timer();  // Re-initialize the Timer to be able to restart it later if needed
    }
    private void poll() {
        if (weatherConfig == null) return;
        if (weatherConfig.isHasTemperature()) {
            info.setTemperature(random.nextInt(65) - 15);
        }
        if (weatherConfig.isHasWind()) {
            info.setWind(random.nextInt(151));
        }
        if (weatherConfig.isHasPrecepitation()) {
            info.setPrecipitation(random.nextInt(201));
        }
        if (weatherConfig.isHasPression()) {
            info.setPression(random.nextInt(1191) + 10);
        }
       display(info);
    }
}
