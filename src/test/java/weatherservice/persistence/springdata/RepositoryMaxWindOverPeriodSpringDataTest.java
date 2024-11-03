
package weatherservice.persistence.springdata;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import weatherservice.domain.max_wind_over_period.MaxWindOverPeriod;
import weatherservice.utils.Parameters;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RepositoryMaxWindOverPeriodSpringDataTest {
    @Test
    void testWhenSavingMaxWIndOverPeriodAggregateThenReturnTrue() throws IOException {
        //Arrange
        int apiKey = Parameters.API_KEY_LOWER_BOUNDARY;
        double latitude = Parameters.LATITUDE_LOWER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_LOWER_BOUNDARY;
        int hourStart = Parameters.HOUR_LOWER_BOUNDARY;
        int hourEnd = Parameters.HOUR_UPPER_BOUNDARY;
        MaxWindOverPeriod maxWindOverPeriod = new MaxWindOverPeriod(apiKey, latitude, longitude, hourStart, hourEnd);
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringDataConfig.class);
        RepositoryMaxWindOverPeriodSpringData repositoryMaxWindOverPeriodSpringData
            = context.getBean(RepositoryMaxWindOverPeriodSpringData.class);
        //Act & Assert
        assertTrue(repositoryMaxWindOverPeriodSpringData.save(maxWindOverPeriod),
            "Should return True.");
    }
}
