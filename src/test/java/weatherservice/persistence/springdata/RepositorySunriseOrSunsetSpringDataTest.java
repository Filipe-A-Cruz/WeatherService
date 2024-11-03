
package weatherservice.persistence.springdata;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import weatherservice.domain.sunrise_or_sunset.SunriseOrSunset;
import weatherservice.utils.Parameters;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RepositorySunriseOrSunsetSpringDataTest {
    @ParameterizedTest
    @ValueSource(strings = {Parameters.SUNRISE, Parameters.SUNSET})
    void testWhenSavingSunriseOrSunsetAggregateThenReturnTrue(String option) throws IOException {
        //Arrange
        int apiKey = Parameters.API_KEY_UPPER_BOUNDARY;
        double latitude = Parameters.LATITUDE_UPPER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_UPPER_BOUNDARY;
        SunriseOrSunset sunriseOrSunset = new SunriseOrSunset(apiKey, latitude, longitude, option);
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringDataConfig.class);
        RepositorySunriseOrSunsetSpringData repositorySunriseOrSunsetSpringData
            = context.getBean(RepositorySunriseOrSunsetSpringData.class);
        //Act & Assert
        assertTrue(repositorySunriseOrSunsetSpringData.save(sunriseOrSunset),
            "Should return True.");
    }
}
