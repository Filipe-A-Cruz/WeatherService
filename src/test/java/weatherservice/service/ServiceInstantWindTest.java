
package weatherservice.service;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import weatherservice.ddd.ValueWS;
import weatherservice.domain.instant_wind.ValueWSInstantWind;
import weatherservice.persistence.springdata.SpringDataConfig;
import weatherservice.utils.Parameters;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServiceInstantWindTest {
    @Test
    void testWhenGettingInstantWindWithValidArgumentsThenReturnValidValueWSObject() throws IOException {
        //Arrange
        int apiKey = Parameters.API_KEY_UPPER_BOUNDARY;
        double latitude = Parameters.LATITUDE_UPPER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_UPPER_BOUNDARY;
        int hour = Parameters.HOUR_UPPER_BOUNDARY;
        ApplicationContext context
            = new AnnotationConfigApplicationContext(SpringDataConfig.class, ServiceConfig.class);
        ServiceInstantWind serviceInstantWind = context.getBean(ServiceInstantWind.class);
        ValueWS valueWSExpected
            = new ValueWSInstantWind(hour);
        //Act
        ValueWS valueWSResult
            = serviceInstantWind.getInstantWind(apiKey, latitude, longitude, hour);
        //Assert
        assertEquals(valueWSExpected.toString(), valueWSResult.toString(),
            "Should return valid value-object.");
    }
}
