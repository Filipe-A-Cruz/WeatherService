
package weatherservice.domain.max_wind_over_period;

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

class MaxWindOverPeriodTest {
    @ParameterizedTest
    @ValueSource(ints = {Parameters.HOUR_LOWER_BOUNDARY, Parameters.HOUR_UPPER_BOUNDARY})
    void testWhenInstantiatingMaxWindOverPeriodWithLowerOrUpperBoundaryStartHourThenReturnValidMaxWIndOverPeriodObject
        (int hourStart) throws IOException {
        //Also tests hourStart == hourEnd
        //Arrange
        int apiKey = Parameters.API_KEY_LOWER_BOUNDARY;
        double latitude = Parameters.LATITUDE_LOWER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_LOWER_BOUNDARY;
        int hourEnd = Parameters.HOUR_UPPER_BOUNDARY;
        double[] windSpeedTable = Functions.importWindSpeed();
        String[] windDirectionTable = Functions.importWindDirection();
        try (MockedConstruction<DatabankWindSpeed> ignoredDatabankWindSpeedDouble
                 = mockConstruction(DatabankWindSpeed.class, (mock, context) -> {
            for (int i = hourStart; i <= hourEnd; i++) {
                when(mock.getWindSpeedData(i)).thenReturn(windSpeedTable[i]);
            }
        })) {
            try (MockedConstruction<DatabankWindDirection> ignoredDatabankWindDirectionDouble
                     = mockConstruction(DatabankWindDirection.class, (mock, context) -> {
                for (int i = hourStart; i <= hourEnd; i++) {
                    when(mock.getWindDirectionData(i)).thenReturn(windDirectionTable[i]);
                }
            })) {
                MaxWindOverPeriod maxWindOverPeriodExpected
                    = new MaxWindOverPeriod(apiKey, latitude, longitude, hourStart, hourEnd);
                //Act
                MaxWindOverPeriod maxWindOverPeriodResult
                    = new MaxWindOverPeriod(apiKey, latitude, longitude, hourStart, hourEnd);
                //Assert
                assertEquals(maxWindOverPeriodExpected.toString(),
                    maxWindOverPeriodResult.toString(),
                    "Should return valid aggregate.");
            }
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {Parameters.HOUR_LOWER_BOUNDARY - Parameters.ONE,
        Parameters.HOUR_UPPER_BOUNDARY + Parameters.ONE})
    void testWhenInstantiatingMaxWindOverPeriodWithStartHourOutsideValidRangeThenThrowAnException(int hourStart) {
        //Arrange
        int apiKey = Parameters.API_KEY_UPPER_BOUNDARY;
        double latitude = Parameters.LATITUDE_UPPER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_UPPER_BOUNDARY;
        int hourEnd = Parameters.HOUR_UPPER_BOUNDARY;
        //Act & Assert
        assertThrows(IllegalArgumentException.class,
            () -> new MaxWindOverPeriod(apiKey, latitude, longitude, hourStart, hourEnd),
            "Should throw an exception.");
    }

    @ParameterizedTest
    @ValueSource(ints = {Parameters.HOUR_LOWER_BOUNDARY, Parameters.HOUR_UPPER_BOUNDARY})
    void testWhenInstantiatingMaxWindOverPeriodWithLowerOrUpperBoundaryEndHourThenReturnValidMaxWIndOverPeriodObject
        (int hourEnd) throws IOException {
        //Also tests hourStart == hourEnd
        //Arrange
        int apiKey = Parameters.API_KEY_LOWER_BOUNDARY;
        double latitude = Parameters.LATITUDE_LOWER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_LOWER_BOUNDARY;
        int hourStart = Parameters.HOUR_LOWER_BOUNDARY;
        double[] windSpeedTable = Functions.importWindSpeed();
        String[] windDirectionTable = Functions.importWindDirection();
        try (MockedConstruction<DatabankWindSpeed> ignoredDatabankWindSpeedDouble
                 = mockConstruction(DatabankWindSpeed.class, (mock, context) -> {
            for (int i = hourStart; i <= hourEnd; i++) {
                when(mock.getWindSpeedData(i)).thenReturn(windSpeedTable[i]);
            }
        })) {
            try (MockedConstruction<DatabankWindDirection> ignoredDatabankWindDirectionDouble
                     = mockConstruction(DatabankWindDirection.class, (mock, context) -> {
                for (int i = hourStart; i <= hourEnd; i++) {
                    when(mock.getWindDirectionData(i)).thenReturn(windDirectionTable[i]);
                }
            })) {
                MaxWindOverPeriod maxWindOverPeriodExpected
                    = new MaxWindOverPeriod(apiKey, latitude, longitude, hourStart, hourEnd);
                //Act
                MaxWindOverPeriod maxWindOverPeriodResult
                    = new MaxWindOverPeriod(apiKey, latitude, longitude, hourStart, hourEnd);
                //Assert
                assertEquals(maxWindOverPeriodExpected.toString(),
                    maxWindOverPeriodResult.toString(),
                    "Should return valid aggregate.");
            }
        }
    }

    @ParameterizedTest
    @ValueSource(ints = {Parameters.HOUR_LOWER_BOUNDARY - Parameters.ONE,
        Parameters.HOUR_UPPER_BOUNDARY + Parameters.ONE})
    void testWhenInstantiatingMaxWindOverPeriodWithEndHourOutsideValidRangeThenThrowAnException(int hourEnd) {
        //Arrange
        int apiKey = Parameters.API_KEY_UPPER_BOUNDARY;
        double latitude = Parameters.LATITUDE_UPPER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_UPPER_BOUNDARY;
        int hourStart = Parameters.HOUR_LOWER_BOUNDARY;
        //Act & Assert
        assertThrows(IllegalArgumentException.class,
            () -> new MaxWindOverPeriod(apiKey, latitude, longitude, hourStart, hourEnd),
            "Should throw an exception.");
    }

    @Test
    void testWhenInstantiatingMaxWindOverPeriodWithStartHourHigherThanEndHourThenThrowAnException() {
        //Arrange
        int apiKey = Parameters.API_KEY_LOWER_BOUNDARY;
        double latitude = Parameters.LATITUDE_LOWER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_LOWER_BOUNDARY;
        int hourStart = Parameters.HOUR_UPPER_BOUNDARY;
        int hourEnd = Parameters.HOUR_LOWER_BOUNDARY;
        //Act & Assert
        assertThrows(IllegalArgumentException.class,
            () -> new MaxWindOverPeriod(apiKey, latitude, longitude, hourStart, hourEnd),
            "Should throw an exception.");
    }

    @Test
    void testWhenCallingObjectToStringThenReturnValidString() throws IOException {
        //Also tests getters.
        //Arrange
        int apiKey = Parameters.API_KEY_UPPER_BOUNDARY;
        double latitude = Parameters.LATITUDE_UPPER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_UPPER_BOUNDARY;
        int hourStart = Parameters.HOUR_LOWER_BOUNDARY;
        int hourEnd = Parameters.HOUR_UPPER_BOUNDARY;
        double[] windSpeedTable = Functions.importWindSpeed();
        String[] windDirectionTable = Functions.importWindDirection();
        try (MockedConstruction<DatabankWindSpeed> ignoredDatabankWindSpeedDouble
                 = mockConstruction(DatabankWindSpeed.class, (mock, context) -> {
            for (int i = hourStart; i <= hourEnd; i++) {
                when(mock.getWindSpeedData(i)).thenReturn(windSpeedTable[i]);
            }
        })) {
            try (MockedConstruction<DatabankWindDirection> ignoredDatabankWindDirectionDouble
                     = mockConstruction(DatabankWindDirection.class, (mock, context) -> {
                for (int i = hourStart; i <= hourEnd; i++) {
                    when(mock.getWindDirectionData(i)).thenReturn(windDirectionTable[i]);
                }
            })) {
                MaxWindOverPeriod maxWindOverPeriod
                    = new MaxWindOverPeriod(apiKey, latitude, longitude, hourStart, hourEnd);
                String expected = "MaxWindOverPeriod(" +
                    "idMaxWindOverPeriod=" + maxWindOverPeriod.getId() +
                    ", valueWSMaxWindOverPeriod=" + maxWindOverPeriod.getValueWS() +
                    ')';
                //Act & Assert
                assertEquals(expected, maxWindOverPeriod.toString(),
                    "Should return valid String.");
            }
        }
    }
}
