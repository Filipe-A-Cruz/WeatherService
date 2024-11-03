
package weatherservice.service;

import weatherservice.ddd.AggregateRoot;
import weatherservice.ddd.DomainId;
import weatherservice.ddd.ValueWS;
import weatherservice.domain.instant_temperature.InstantTemperature;
import org.junit.jupiter.api.Test;
import weatherservice.utils.Parameters;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactoryInstantTemperatureTest {
    @Test
    void testWhenCreatingInstantTemperatureAggregateWithValidArgumentsThenReturnValidInstantTemperatureObject()
        throws IOException {
        //Arrange
        int apiKey = Parameters.API_KEY_LOWER_BOUNDARY;
        double latitude = Parameters.LATITUDE_LOWER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_LOWER_BOUNDARY;
        int hour = Parameters.HOUR_LOWER_BOUNDARY;
        IFactoryInstantTemperature<DomainId, ValueWS> factoryInstantTemperature
            = new FactoryInstantTemperature();
        AggregateRoot<DomainId, ValueWS> instantTemperatureExpected
            = new InstantTemperature(apiKey, latitude, longitude, hour);
        //Act
        AggregateRoot<DomainId, ValueWS> instantTemperatureResult
            = factoryInstantTemperature.createInstantTemperature(apiKey, latitude, longitude, hour);
        //Assert
        assertEquals(instantTemperatureExpected.toString(), instantTemperatureResult.toString(),
            "Should return valid aggregate.");
    }
}
