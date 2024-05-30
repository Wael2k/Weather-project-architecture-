package software_architecture_project.demo.weather_business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software_architecture_project.demo.weather_domain.entities.WeatherConfig;
import software_architecture_project.demo.weather_domain.entities.WeatherInfo;
import software_architecture_project.demo.weather_domain.service.IWeatherIn;
import software_architecture_project.demo.weather_domain.service.IWeatherOut;


import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class WeatherManager implements IWeatherOut {
    private WeatherConfig weatherConfig;
    @Autowired
    private IWeatherIn iWeatherIn;
    private WeatherInfo info;
    private Timer polling;
    private Random random;
    public WeatherManager(){
        this.polling = new Timer();
        this.info = new WeatherInfo();
        this.random = new Random();
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
        iWeatherIn.display(info);
    }
}
