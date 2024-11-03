
package weatherservice.domain.instant_temperature;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import weatherservice.utils.DatabankTemperature;
import weatherservice.utils.Functions;
import weatherservice.utils.Parameters;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

class ValueWSInstantTemperatureTest {
    @Test
    void testWhenGettingMeasurementThenReturnValidMeasurement() throws IOException {
        //Arrange
        int hour = Parameters.HOUR_LOWER_BOUNDARY;
        double[] temperatureTable = Functions.importTemperature();
        try (MockedConstruction<DatabankTemperature> databankTemperatureDouble
                 = mockConstruction(DatabankTemperature.class, (mock, context) ->
            when(mock.getTemperatureData(hour)).thenReturn(temperatureTable[hour])
        )) {
            ValueWSInstantTemperature valueWS = new ValueWSInstantTemperature(hour);
            double expected = databankTemperatureDouble.constructed()
                .get(Parameters.ZERO).getTemperatureData(hour);
            //Act & Assert
            assertEquals(expected, valueWS.getMeasurement(),
                "Should return valid double.");
        }
    }

    @Test
    void testWhenCallingObjectToStringThenReturnValidString() throws IOException {
        //Also tests getters.
        //Arrange
        int hour = Parameters.HOUR_UPPER_BOUNDARY;
        double[] temperatureTable = Functions.importTemperature();
        try (MockedConstruction<DatabankTemperature> ignoredDatabankTemperatureDouble
                 = mockConstruction(DatabankTemperature.class, (mock, context) ->
            when(mock.getTemperatureData(hour)).thenReturn(temperatureTable[hour])
        )) {
            ValueWSInstantTemperature valueWS = new ValueWSInstantTemperature(hour);
            String expected = "ValueWSInstantTemperature(" +
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
