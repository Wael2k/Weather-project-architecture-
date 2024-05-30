package software_architecture_project.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import software_architecture_project.demo.weather_domain.entities.WeatherConfig;

import java.util.Scanner;

@Component
public class WeatherConsoleApplication implements CommandLineRunner {

@Autowired
    private WeatherManager weatherManager;

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello, weather");

        WeatherConfig config = new WeatherConfig();

        System.out.println("Configure weather component");

        System.out.print("Get Temperature? (Y/N) ");
        String result = scanner.nextLine();
        config.setHasTemperature(result.equalsIgnoreCase("Y"));

        System.out.print("Get Pression? (Y/N) ");
        result = scanner.nextLine();
        config.setHasPression(result.equalsIgnoreCase("Y"));

        System.out.print("Get Wind? (Y/N) ");
        result = scanner.nextLine();
        config.setHasWind(result.equalsIgnoreCase("Y"));

        System.out.print("Get Precipitation? (Y/N) ");
        result = scanner.nextLine();
        config.setHasPrecepitation(result.equalsIgnoreCase("Y"));

        weatherManager.setWeatherConfig(config);
        weatherManager.startCollect();

        System.out.println("Weather collection started. Press any key to stop...");
        System.in.read();

        weatherManager.stopCollect();
        System.out.println("Weather collection stopped.");
    }
}