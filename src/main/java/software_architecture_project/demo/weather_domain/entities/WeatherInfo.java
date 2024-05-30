package software_architecture_project.demo.weather_domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherInfo {
    double  temperature;
    double  pression;
    double  wind;
     double precipitation;

}
