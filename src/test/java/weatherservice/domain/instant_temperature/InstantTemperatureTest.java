
package weatherservice.domain.instant_temperature;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedConstruction;
import weatherservice.utils.DatabankTemperature;
import weatherservice.utils.Functions;
import weatherservice.utils.Parameters;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

class InstantTemperatureTest {
    @ParameterizedTest
    @ValueSource(ints = {Parameters.HOUR_LOWER_BOUNDARY, Parameters.HOUR_UPPER_BOUNDARY})
    void testWhenInstantiatingInstantTemperatureWithLowerOrUpperBoundaryHourThenReturnValidInstantTemperatureObject
        (int hour) throws IOException {
        //Arrange
        int apiKey = Parameters.API_KEY_LOWER_BOUNDARY;
        double latitude = Parameters.LATITUDE_LOWER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_LOWER_BOUNDARY;
        double[] temperatureTable = Functions.importTemperature();
        try (MockedConstruction<DatabankTemperature> ignoredDatabankTemperatureDouble
                 = mockConstruction(DatabankTemperature.class, (mock, context) ->
            when(mock.getTemperatureData(hour)).thenReturn(temperatureTable[hour])
        )) {
            InstantTemperature instantTemperatureExpected
                = new InstantTemperature(apiKey, latitude, longitude, hour);
            //Act
            InstantTemperature instantTemperatureResult
                = new InstantTemperature(apiKey, latitude, longitude, hour);
            //Assert
            assertEquals(instantTemperatureExpected.toString(), instantTemperatureResult.toString(),
                "Should return valid aggregate.");
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {Parameters.HOUR_LOWER_BOUNDARY - Parameters.ONE,
        Parameters.HOUR_UPPER_BOUNDARY + Parameters.ONE})
    void testWhenInstantiatingInstantTemperatureWithHourOutsideValidRangeThenThrowAnException(int hour) {
        //Arrange
        int apiKey = Parameters.API_KEY_UPPER_BOUNDARY;
        double latitude = Parameters.LATITUDE_UPPER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_UPPER_BOUNDARY;
        //Act & Assert
        assertThrows(IllegalArgumentException.class,
            () -> new InstantTemperature(apiKey, latitude, longitude, hour),
            "Should throw an exception.");
    }

    @Test
    void testWhenCallingObjectToStringThenReturnValidString() throws IOException {
        //Also tests getters.
        //Arrange
        int apiKey = Parameters.API_KEY_LOWER_BOUNDARY;
        double latitude = Parameters.LATITUDE_LOWER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_LOWER_BOUNDARY;
        int hour = Parameters.HOUR_LOWER_BOUNDARY;
        double[] temperatureTable = Functions.importTemperature();
        try (MockedConstruction<DatabankTemperature> ignoredDatabankTemperatureDouble
                 = mockConstruction(DatabankTemperature.class, (mock, context) ->
            when(mock.getTemperatureData(hour)).thenReturn(temperatureTable[hour])
        )) {
            InstantTemperature instantTemperature
                = new InstantTemperature(apiKey, latitude, longitude, hour);
            String expected = "InstantTemperature(" +
                "idInstantTemperature=" + instantTemperature.getId() +
                ", valueWSInstantTemperature=" + instantTemperature.getValueWS() +
                ')';
            //Act & Assert
            assertEquals(expected, instantTemperature.toString(),
                "Should return valid String.");
        }
    }
}
