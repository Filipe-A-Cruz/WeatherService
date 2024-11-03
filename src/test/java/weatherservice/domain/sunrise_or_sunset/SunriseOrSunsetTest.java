
package weatherservice.domain.sunrise_or_sunset;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedConstruction;
import weatherservice.utils.DatabankSunriseAndSunset;
import weatherservice.utils.Functions;
import weatherservice.utils.Parameters;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

class SunriseOrSunsetTest {
    @ParameterizedTest
    @ValueSource(strings = {Parameters.SUNRISE, Parameters.SUNSET})
    void testWhenInstantiatingSunriseOrSunsetWithValidOptionThenReturnValidSunriseOrSunsetObject
        (String option) throws IOException {
        //Arrange
        int apiKey = Parameters.API_KEY_UPPER_BOUNDARY;
        double latitude = Parameters.LATITUDE_UPPER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_UPPER_BOUNDARY;
        double[] sunriseAndSunsetTable = Functions.importSunriseAndSunset();
        try (MockedConstruction<DatabankSunriseAndSunset> ignoredDatabankSunriseAndSunsetDouble
                 = mockConstruction(DatabankSunriseAndSunset.class, (mock, context) -> {
                if (option.equals(Parameters.SUNRISE)) {
                    when(mock.getSunriseOrSunsetData(option)).thenReturn(sunriseAndSunsetTable[Parameters.ZERO]);
                }
                if (option.equals(Parameters.SUNSET)) {
                    when(mock.getSunriseOrSunsetData(option)).thenReturn(sunriseAndSunsetTable[Parameters.ONE]);
                }
            }
        )) {
            SunriseOrSunset sunriseOrSunsetExpected
                = new SunriseOrSunset(apiKey, latitude, longitude, option);
            //Act
            SunriseOrSunset sunriseOrSunsetResult
                = new SunriseOrSunset(apiKey, latitude, longitude, option);
            //Assert
            assertEquals(sunriseOrSunsetExpected.toString(), sunriseOrSunsetResult.toString(),
                "Should return valid aggregate.");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {Parameters.DAWN, Parameters.DUSK, Parameters.EMPTY_STRING})
    void testWhenInstantiatingSunriseOrSunsetWithInvalidOptionThenThrowAnException(String option) {
        //Arrange
        int apiKey = Parameters.API_KEY_LOWER_BOUNDARY;
        double latitude = Parameters.LATITUDE_LOWER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_LOWER_BOUNDARY;
        //Act & Assert
        assertThrows(IllegalArgumentException.class,
            () -> new SunriseOrSunset(apiKey, latitude, longitude, option),
            "Should throw an exception.");
    }

    @Test
    void testWhenInstantiatingSunriseOrSunsetWithNullOptionThenThrowAnException() {
        //Arrange
        int apiKey = Parameters.API_KEY_UPPER_BOUNDARY;
        double latitude = Parameters.LATITUDE_UPPER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_UPPER_BOUNDARY;
        String option;
        option = null;
        //Act & Assert
        assertThrows(IllegalArgumentException.class,
            () -> new SunriseOrSunset(apiKey, latitude, longitude, option),
            "Should throw an exception.");
    }

    @ParameterizedTest
    @ValueSource(strings = {Parameters.SUNRISE, Parameters.SUNSET})
    void testWhenCallingObjectToStringThenReturnValidString(String option) throws IOException {
        //Also tests getters.
        //Arrange
        int apiKey = Parameters.API_KEY_LOWER_BOUNDARY;
        double latitude = Parameters.LATITUDE_LOWER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_LOWER_BOUNDARY;
        double[] sunriseAndSunsetTable = Functions.importSunriseAndSunset();
        try (MockedConstruction<DatabankSunriseAndSunset> ignoredDatabankSunriseAndSunsetDouble
                 = mockConstruction(DatabankSunriseAndSunset.class, (mock, context) -> {
                if (option.equals(Parameters.SUNRISE)) {
                    when(mock.getSunriseOrSunsetData(option)).thenReturn(sunriseAndSunsetTable[Parameters.ZERO]);
                }
                if (option.equals(Parameters.SUNSET)) {
                    when(mock.getSunriseOrSunsetData(option)).thenReturn(sunriseAndSunsetTable[Parameters.ONE]);
                }
            }
        )) {
            SunriseOrSunset sunriseOrSunset
                = new SunriseOrSunset(apiKey, latitude, longitude, option);
            String expected = "SunriseOrSunset(" +
                "idSunriseOrSunset=" + sunriseOrSunset.getId() +
                ", valueWSSunriseOrSunset=" + sunriseOrSunset.getValueWS() +
                ')';
            //Act & Assert
            assertEquals(expected, sunriseOrSunset.toString(),
                "Should return valid String.");
        }
    }
}
