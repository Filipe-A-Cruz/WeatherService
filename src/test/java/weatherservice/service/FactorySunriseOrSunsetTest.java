
package weatherservice.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import weatherservice.ddd.AggregateRoot;
import weatherservice.ddd.DomainId;
import weatherservice.ddd.ValueWS;
import weatherservice.domain.sunrise_or_sunset.SunriseOrSunset;
import weatherservice.utils.Parameters;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorySunriseOrSunsetTest {
    @ParameterizedTest
    @ValueSource(strings = {Parameters.SUNRISE, Parameters.SUNSET})
    void testWhenCreatingSunriseOrSunsetAggregateWithValidArgumentsThenReturnValidSunriseOrSunsetObject
        (String option) throws IOException {
        //Arrange
        int apiKey = Parameters.API_KEY_UPPER_BOUNDARY;
        double latitude = Parameters.LATITUDE_UPPER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_UPPER_BOUNDARY;
        IFactorySunriseOrSunset<DomainId, ValueWS> factorySunriseOrSunset
            = new FactorySunriseOrSunset();
        AggregateRoot<DomainId, ValueWS> sunriseOrSunsetExpected
            = new SunriseOrSunset(apiKey, latitude, longitude, option);
        //Act
        AggregateRoot<DomainId, ValueWS> sunriseOrSunsetResult
            = factorySunriseOrSunset.createSunriseOrSunset(apiKey, latitude, longitude, option);
        //Assert
        assertEquals(sunriseOrSunsetExpected.toString(), sunriseOrSunsetResult.toString(),
            "Should return valid aggregate.");
    }
}
