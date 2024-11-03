
package weatherservice.domain.sunrise_or_sunset;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedConstruction;
import weatherservice.utils.DatabankSunriseAndSunset;
import weatherservice.utils.Functions;
import weatherservice.utils.Parameters;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

class ValueWSSunriseOrSunsetTest {
    @ParameterizedTest
    @ValueSource(strings = {Parameters.SUNRISE, Parameters.SUNSET})
    void testWhenGettingMeasurementThenReturnValidMeasurement(String option) throws IOException {
        //Arrange
        double[] sunriseAndSunsetTable = Functions.importSunriseAndSunset();
        try (MockedConstruction<DatabankSunriseAndSunset> databankSunriseAndSunsetDouble
                 = mockConstruction(DatabankSunriseAndSunset.class, (mock, context) -> {
                if (option.equals(Parameters.SUNRISE)) {
                    when(mock.getSunriseOrSunsetData(option)).thenReturn(sunriseAndSunsetTable[Parameters.ZERO]);
                }
                if (option.equals(Parameters.SUNSET)) {
                    when(mock.getSunriseOrSunsetData(option)).thenReturn(sunriseAndSunsetTable[Parameters.ONE]);
                }
            }
        )) {
            ValueWSSunriseOrSunset valueWS = new ValueWSSunriseOrSunset(option);
            double expected = databankSunriseAndSunsetDouble.constructed()
                .get(Parameters.ZERO).getSunriseOrSunsetData(option);
            //Act & Assert
            assertEquals(expected, valueWS.getMeasurement(),
                "Should return valid double.");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {Parameters.SUNRISE, Parameters.SUNSET})
    void testWhenGettingInfoThenReturnValidInfo(String option) throws IOException {
        //Arrange
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
            ValueWSSunriseOrSunset valueWS = new ValueWSSunriseOrSunset(option);
            String expected;
            expected = option;
            //Act & Assert
            assertEquals(expected, valueWS.getInfo(),
                "Should return valid String.");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {Parameters.SUNRISE, Parameters.SUNSET})
    void testWhenCallingObjectToStringThenReturnValidString(String option) throws IOException {
        //Also tests getters.
        //Arrange
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
            ValueWSSunriseOrSunset valueWS = new ValueWSSunriseOrSunset(option);
            String expected = "ValueWSSunriseOrSunset(" +
                "measurement=" + valueWS.getMeasurement() +
                ", unit=" + valueWS.getUnit() +
                ", info=" + valueWS.getInfo() +
                ')';
            //Act & Assert
            assertEquals(expected, valueWS.toString(),
                "Should return valid String.");
        }
    }
}
