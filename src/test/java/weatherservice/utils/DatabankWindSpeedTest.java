
package weatherservice.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DatabankWindSpeedTest {
    @ParameterizedTest
    @ValueSource(ints = {Parameters.HOUR_LOWER_BOUNDARY, Parameters.HOUR_UPPER_BOUNDARY})
    void testWhenGettingWindSpeedDataWithValidHourThenReturnValidDouble(int hour) throws IOException {
        //Arrange
        double[] windSpeedTable = Functions.importWindSpeed();
        double expected = windSpeedTable[hour];
        DatabankWindSpeed databankWindSpeed = new DatabankWindSpeed();
        //Act
        double result = databankWindSpeed.getWindSpeedData(hour);
        //Assert
        assertEquals(expected, result, Parameters.ASSERT_EQUALS_DOUBLES_TOLERANCE,
            "Should return double from .txt.");
    }
}
