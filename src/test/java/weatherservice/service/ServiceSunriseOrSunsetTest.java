
package weatherservice.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import weatherservice.ddd.ValueWS;
import weatherservice.domain.sunrise_or_sunset.ValueWSSunriseOrSunset;
import weatherservice.persistence.springdata.SpringDataConfig;
import weatherservice.utils.Parameters;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServiceSunriseOrSunsetTest {
    @ParameterizedTest
    @ValueSource(strings = {Parameters.SUNRISE, Parameters.SUNSET})
    void testWhenGettingSunriseOrSunsetWithValidArgumentsThenReturnValidValueWSObject
        (String option) throws IOException {
        //Arrange
        int apiKey = Parameters.API_KEY_UPPER_BOUNDARY;
        double latitude = Parameters.LATITUDE_UPPER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_UPPER_BOUNDARY;
        ApplicationContext context
            = new AnnotationConfigApplicationContext(SpringDataConfig.class, ServiceConfig.class);
        ServiceSunriseOrSunset serviceSunriseOrSunset = context.getBean(ServiceSunriseOrSunset.class);
        ValueWS valueWSExpected
            = new ValueWSSunriseOrSunset(option);
        //Act
        ValueWS valueWSResult
            = serviceSunriseOrSunset.getSunriseOrSunset(apiKey, latitude, longitude, option);
        //Assert
        assertEquals(valueWSExpected.toString(), valueWSResult.toString(),
            "Should return valid value-object.");
    }
}
