
package weatherservice.mapper;

import org.junit.jupiter.api.Test;
import weatherservice.utils.Functions;
import weatherservice.utils.Parameters;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValueWSDtoTest {
    @Test
    void testWhenCallingObjectToStringThenReturnValidString() throws IOException {
        //Also tests getters.
        //Arrange
        int hour = Parameters.HOUR_LOWER_BOUNDARY;
        double[] temperatureTable = Functions.importTemperature();
        double measurement = temperatureTable[hour];
        String unit = Parameters.TEMPERATURE_UNIT;
        String info = Parameters.TEMPERATURE_INFO;
        ValueWSDto valueWSDto = new ValueWSDto(measurement, unit, info);
        String expected = "ValueWSDto(" +
            "measurement=" + valueWSDto.getMeasurement() +
            ", unit=" + valueWSDto.getUnit() +
            ", info=" + valueWSDto.getInfo() +
            ')';
        //Act & Assert
        assertEquals(expected, valueWSDto.toString(),
            "Should return valid String.");
    }
}
