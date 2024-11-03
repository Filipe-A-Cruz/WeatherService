
package weatherservice.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DatabankSunriseAndSunsetTest {
    @ParameterizedTest
    @ValueSource(strings = {Parameters.SUNRISE, Parameters.SUNSET})
    void testWhenGettingSunriseOrSunsetDataThenReturnValidDouble(String option) throws IOException {
        //Arrange
        int index;
        if (option.equals(Parameters.SUNRISE)) {
            index = Parameters.ZERO;
        } else {
            index = Parameters.ONE;
        }
        double[] sunriseAndSunsetTable = Functions.importSunriseAndSunset();
        double expected = sunriseAndSunsetTable[index];
        DatabankSunriseAndSunset databankSunriseAndSunset = new DatabankSunriseAndSunset();
        //Act
        double result = databankSunriseAndSunset.getSunriseOrSunsetData(option);
        //Assert
        assertEquals(expected, result, Parameters.ASSERT_EQUALS_DOUBLES_TOLERANCE,
            "Should return double from .txt.");
    }
}
