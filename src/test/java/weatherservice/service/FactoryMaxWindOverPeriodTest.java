
package weatherservice.service;

import weatherservice.ddd.AggregateRoot;
import weatherservice.ddd.DomainId;
import weatherservice.ddd.ValueWS;
import weatherservice.domain.max_wind_over_period.MaxWindOverPeriod;
import org.junit.jupiter.api.Test;
import weatherservice.utils.Parameters;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactoryMaxWindOverPeriodTest {
    @Test
    void testWhenCreatingMaxWIndOverPeriodAggregateWithValidArgumentsThenReturnValidMaxWIndOverPeriodObject()
        throws IOException {
        //Arrange
        int apiKey = Parameters.API_KEY_LOWER_BOUNDARY;
        double latitude = Parameters.LATITUDE_LOWER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_LOWER_BOUNDARY;
        int hourStart = Parameters.HOUR_LOWER_BOUNDARY;
        int hourEnd = Parameters.HOUR_UPPER_BOUNDARY;
        IFactoryMaxWindOverPeriod<DomainId, ValueWS> factoryMaxWindOverPeriod
            = new FactoryMaxWindOverPeriod();
        AggregateRoot<DomainId, ValueWS> maxWindOverPeriodExpected
            = new MaxWindOverPeriod(apiKey, latitude, longitude, hourStart, hourEnd);
        //Act
        AggregateRoot<DomainId, ValueWS> maxWindOverPeriodResult
            = factoryMaxWindOverPeriod.createMaxWindOverPeriod(apiKey, latitude, longitude, hourStart, hourEnd);
        //Assert
        assertEquals(maxWindOverPeriodExpected.toString(), maxWindOverPeriodResult.toString(),
            "Should return valid aggregate.");
    }
}
