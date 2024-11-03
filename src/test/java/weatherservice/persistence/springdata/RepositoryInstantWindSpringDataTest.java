
package weatherservice.persistence.springdata;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import weatherservice.domain.instant_wind.InstantWind;
import weatherservice.utils.Parameters;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RepositoryInstantWindSpringDataTest {
    @Test
    void testWhenSavingInstantWindThenReturnTrue() throws IOException {
        //Arrange
        int apiKey = Parameters.API_KEY_UPPER_BOUNDARY;
        double latitude = Parameters.LATITUDE_UPPER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_UPPER_BOUNDARY;
        int hour = Parameters.HOUR_UPPER_BOUNDARY;
        InstantWind instantWind = new InstantWind(apiKey, latitude, longitude, hour);
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringDataConfig.class);
        RepositoryInstantWindSpringData repositoryInstantWindSpringData
            = context.getBean(RepositoryInstantWindSpringData.class);
        //Act & Assert
        assertTrue(repositoryInstantWindSpringData.save(instantWind),
            "Should return True.");
    }
}
