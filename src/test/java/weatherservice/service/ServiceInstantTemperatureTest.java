
package weatherservice.service;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import weatherservice.ddd.ValueWS;
import weatherservice.domain.instant_temperature.ValueWSInstantTemperature;
import weatherservice.persistence.springdata.SpringDataConfig;
import weatherservice.utils.Parameters;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServiceInstantTemperatureTest {
    @Test
    void testWhenGettingInstantTemperatureWithValidArgumentsThenReturnValidValueWSObject() throws IOException {
        //Arrange
        int apiKey = Parameters.API_KEY_LOWER_BOUNDARY;
        double latitude = Parameters.LATITUDE_LOWER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_LOWER_BOUNDARY;
        int hour = Parameters.HOUR_LOWER_BOUNDARY;
        ApplicationContext context
            = new AnnotationConfigApplicationContext(SpringDataConfig.class, ServiceConfig.class);
        ServiceInstantTemperature serviceInstantTemperature
            = context.getBean(ServiceInstantTemperature.class);
        ValueWS valueWSExpected = new ValueWSInstantTemperature(hour);
        //Act
        ValueWS valueWSResult
            = serviceInstantTemperature.getInstantTemperature(apiKey, latitude, longitude, hour);
        //Assert
        assertEquals(valueWSExpected.toString(), valueWSResult.toString(),
            "Should return valid value-object.");
    }
}
