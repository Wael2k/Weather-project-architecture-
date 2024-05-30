package software_architecture_project.demo.weather_domain.service;


import software_architecture_project.demo.weather_domain.entities.WeatherInfo;

public interface IWeatherIn {
   void display(WeatherInfo info);

    void writeWeatherValue(String valueType, String value);
}
