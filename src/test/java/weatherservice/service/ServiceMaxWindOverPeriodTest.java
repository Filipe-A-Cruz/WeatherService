
package weatherservice.service;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import weatherservice.ddd.ValueWS;
import weatherservice.domain.max_wind_over_period.ValueWSMaxWindOverPeriod;
import weatherservice.persistence.springdata.SpringDataConfig;
import weatherservice.utils.Parameters;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServiceMaxWindOverPeriodTest {
    @Test
    void testWhenGettingMaxWIndOverPeriodWithValidArgumentsThenReturnValidValueWSObject() throws IOException {
        //Arrange
        int apiKey = Parameters.API_KEY_LOWER_BOUNDARY;
        double latitude = Parameters.LATITUDE_LOWER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_LOWER_BOUNDARY;
        int hourStart = Parameters.HOUR_LOWER_BOUNDARY;
        int hourEnd = Parameters.HOUR_UPPER_BOUNDARY;
        ApplicationContext context
            = new AnnotationConfigApplicationContext(SpringDataConfig.class, ServiceConfig.class);
        ServiceMaxWindOverPeriod serviceMaxWindOverPeriod = context.getBean(ServiceMaxWindOverPeriod.class);
        ValueWS valueWSExpected
            = new ValueWSMaxWindOverPeriod(hourStart, hourEnd);
        //Act
        ValueWS valueWSResult
            = serviceMaxWindOverPeriod.getMaxWindOverPeriod(apiKey, latitude, longitude, hourStart, hourEnd);
        //Assert
        assertEquals(valueWSExpected.toString(), valueWSResult.toString(),
            "Should return valid value-object.");
    }
}
