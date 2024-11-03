
package weatherservice.mapper;

import org.junit.jupiter.api.Test;
import weatherservice.ddd.ValueWS;
import weatherservice.domain.instant_temperature.ValueWSInstantTemperature;
import weatherservice.utils.Functions;
import weatherservice.utils.Parameters;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ValueWSMapperTest {
    @Test
    void testWhenMappingValueWSToDtoThenReturnValidDtoObject() throws IOException {
        //Arrange
        int hour = Parameters.HOUR_UPPER_BOUNDARY;
        double[] temperatureTable = Functions.importTemperature();
        double measurement = temperatureTable[hour];
        String unit = Parameters.TEMPERATURE_UNIT;
        String info = Parameters.TEMPERATURE_INFO;
        ValueWS valueWS = new ValueWSInstantTemperature(hour);
        ValueWSMapper valueWSMapper = new ValueWSMapper();
        ValueWSDto valueWSDtoExpected = new ValueWSDto(measurement, unit, info);
        //Act
        ValueWSDto valueWSDtoResult = valueWSMapper.valueWSToDto(valueWS);
        //Assert
        assertEquals(valueWSDtoExpected.toString(), valueWSDtoResult.toString(),
            "Should return valid value-object dto.");
    }
}
