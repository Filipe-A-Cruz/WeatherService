
package weatherservice.domain.instant_wind;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import weatherservice.utils.DatabankWindDirection;
import weatherservice.utils.DatabankWindSpeed;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import weatherservice.utils.Functions;
import weatherservice.utils.Parameters;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

class InstantWindTest {
    @ParameterizedTest
    @ValueSource(ints = {Parameters.HOUR_LOWER_BOUNDARY, Parameters.HOUR_UPPER_BOUNDARY})
    void testWhenInstantiatingInstantWindWithLowerOrUpperBoundaryHourThenReturnValidInstantWindObject
        (int hour) throws IOException {
        //Arrange
        int apiKey = Parameters.API_KEY_UPPER_BOUNDARY;
        double latitude = Parameters.LATITUDE_UPPER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_UPPER_BOUNDARY;
        double[] windSpeedTable = Functions.importWindSpeed();
        String[] windDirectionTable = Functions.importWindDirection();
        try (MockedConstruction<DatabankWindSpeed> ignoredDatabankWindSpeedDouble
                 = mockConstruction(DatabankWindSpeed.class, (mock, context) ->
            when(mock.getWindSpeedData(hour)).thenReturn(windSpeedTable[hour])
        )) {
            try (MockedConstruction<DatabankWindDirection> ignoredDatabankWindDirectionDouble
                     = mockConstruction(DatabankWindDirection.class, (mock, context) ->
                when(mock.getWindDirectionData(hour)).thenReturn(windDirectionTable[hour])
            )) {
                InstantWind instantWindExpected
                    = new InstantWind(apiKey, latitude, longitude, hour);
                //Act
                InstantWind instantWindResult
                    = new InstantWind(apiKey, latitude, longitude, hour);
                //Assert
                assertEquals(instantWindExpected.toString(), instantWindResult.toString(),
                    "Should return valid aggregate.");
            }
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {Parameters.HOUR_LOWER_BOUNDARY - Parameters.ONE,
        Parameters.HOUR_UPPER_BOUNDARY + Parameters.ONE})
    void testWhenInstantiatingInstantWindWithHourOutsideValidRangeThenThrowAnException(int hour) {
        //Arrange
        int apiKey = Parameters.API_KEY_LOWER_BOUNDARY;
        double latitude = Parameters.LATITUDE_LOWER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_LOWER_BOUNDARY;
        //Act & Assert
        assertThrows(IllegalArgumentException.class,
            () -> new InstantWind(apiKey, latitude, longitude, hour),
            "Should throw an exception.");
    }

    @Test
    void testWhenCallingObjectToStringThenReturnValidString() throws IOException {
        //Also tests getters.
        //Arrange
        int apiKey = Parameters.API_KEY_UPPER_BOUNDARY;
        double latitude = Parameters.LATITUDE_UPPER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_UPPER_BOUNDARY;
        int hour = Parameters.HOUR_UPPER_BOUNDARY;
        double[] windSpeedTable = Functions.importWindSpeed();
        String[] windDirectionTable = Functions.importWindDirection();
        try (MockedConstruction<DatabankWindSpeed> ignoredDatabankWindSpeedDouble
                 = mockConstruction(DatabankWindSpeed.class, (mock, context) ->
            when(mock.getWindSpeedData(hour)).thenReturn(windSpeedTable[hour])
        )) {
            try (MockedConstruction<DatabankWindDirection> ignoredDatabankWindDirectionDouble
                     = mockConstruction(DatabankWindDirection.class, (mock, context) ->
                when(mock.getWindDirectionData(hour)).thenReturn(windDirectionTable[hour])
            )) {
                InstantWind instantWind
                    = new InstantWind(apiKey, latitude, longitude, hour);
                String expected = "InstantWind(" +
                    "idInstantWind=" + instantWind.getId() +
                    ", valueWSInstantWind=" + instantWind.getValueWS() +
                    ')';
                //Act & Assert
                assertEquals(expected, instantWind.toString(),
                    "Should return valid String.");
            }
        }
    }
}
