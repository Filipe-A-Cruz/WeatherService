
package weatherservice.persistence.springdata;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import weatherservice.domain.instant_temperature.InstantTemperature;
import weatherservice.utils.Parameters;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RepositoryInstantTemperatureSpringDataTest {
    @Test
    void testWhenSavingInstantTemperatureAggregateThenReturnTrue() throws IOException {
        //Arrange
        int apiKey = Parameters.API_KEY_LOWER_BOUNDARY;
        double latitude = Parameters.LATITUDE_LOWER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_LOWER_BOUNDARY;
        int hour = Parameters.HOUR_LOWER_BOUNDARY;
        InstantTemperature instantTemperature = new InstantTemperature(apiKey, latitude, longitude, hour);
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringDataConfig.class);
        RepositoryInstantTemperatureSpringData repositoryInstantTemperatureSpringData
            = context.getBean(RepositoryInstantTemperatureSpringData.class);
        //Act & Assert
        assertTrue(repositoryInstantTemperatureSpringData.save(instantTemperature),
            "Should return True.");
    }
}
