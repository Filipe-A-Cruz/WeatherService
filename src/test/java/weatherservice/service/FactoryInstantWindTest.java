
package weatherservice.service;

import weatherservice.ddd.AggregateRoot;
import weatherservice.ddd.DomainId;
import weatherservice.ddd.ValueWS;
import weatherservice.domain.instant_wind.InstantWind;
import org.junit.jupiter.api.Test;
import weatherservice.utils.Parameters;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactoryInstantWindTest {
    @Test
    void testWhenCreatingInstantWindAggregateWithValidArgumentsThenReturnValidInstantWindObject()
        throws IOException {
        //Arrange
        int apiKey = Parameters.API_KEY_UPPER_BOUNDARY;
        double latitude = Parameters.LATITUDE_UPPER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_UPPER_BOUNDARY;
        int hour = Parameters.HOUR_UPPER_BOUNDARY;
        IFactoryInstantWind<DomainId, ValueWS> factoryInstantWind
            = new FactoryInstantWind();
        AggregateRoot<DomainId, ValueWS> instantWindExpected
            = new InstantWind(apiKey, latitude, longitude, hour);
        //Act
        AggregateRoot<DomainId, ValueWS> instantWindResult
            = factoryInstantWind.createInstantWind(apiKey, latitude, longitude, hour);
        //Assert
        assertEquals(instantWindExpected.toString(), instantWindResult.toString(),
            "Should return valid aggregate.");
    }
}
