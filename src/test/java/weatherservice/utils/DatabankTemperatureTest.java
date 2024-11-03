
package weatherservice.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DatabankTemperatureTest {
    @ParameterizedTest
    @ValueSource(ints = {Parameters.HOUR_LOWER_BOUNDARY, Parameters.HOUR_UPPER_BOUNDARY})
    void testWhenGettingTemperatureDataWithValidHourThenReturnValidDouble(int hour) throws IOException {
        //Arrange
        double[] temperatureTable = Functions.importTemperature();
        double expected = temperatureTable[hour];
        DatabankTemperature databankTemperature = new DatabankTemperature();
        //Act
        double result = databankTemperature.getTemperatureData(hour);
        //Assert
        assertEquals(expected, result, Parameters.ASSERT_EQUALS_DOUBLES_TOLERANCE,
            "Should return double from .txt.");
    }
}
