
package weatherservice.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DatabankWindDirectionTest {
    @ParameterizedTest
    @ValueSource(ints = {Parameters.HOUR_LOWER_BOUNDARY, Parameters.HOUR_UPPER_BOUNDARY})
    void testWhenGettingWindDirectionDataWithValidHourThenReturnValidString(int hour) throws IOException {
        //Arrange
        String[] windDirectionTable = Functions.importWindDirection();
        String expected = windDirectionTable[hour];
        DatabankWindDirection databankWindDirection = new DatabankWindDirection();
        //Act
        String result = databankWindDirection.getWindDirectionData(hour);
        //Assert
        assertEquals(expected, result,
            "Should return String from .txt.");
    }
}
