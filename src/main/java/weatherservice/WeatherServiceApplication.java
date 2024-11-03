
package weatherservice;

import lombok.ToString;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ToString
public class WeatherServiceApplication {
    protected WeatherServiceApplication() {
        //Avoid relying on default constructor.
    }

    public static void main(String[] args) {
        SpringApplication.run(WeatherServiceApplication.class, args);
    }
}
