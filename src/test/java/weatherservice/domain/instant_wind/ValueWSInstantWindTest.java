
package weatherservice.domain.instant_wind;

import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;
import weatherservice.utils.DatabankWindDirection;
import weatherservice.utils.DatabankWindSpeed;
import weatherservice.utils.Functions;
import weatherservice.utils.Parameters;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

class ValueWSInstantWindTest {
    @Test
    void testWhenGettingMeasurementThenReturnValidDouble() throws IOException {
        //Arrange
        int hour = Parameters.HOUR_UPPER_BOUNDARY;
        double[] windSpeedTable = Functions.importWindSpeed();
        String[] windDirectionTable = Functions.importWindDirection();
        try (MockedConstruction<DatabankWindSpeed> databankWindSpeedDouble
                 = mockConstruction(DatabankWindSpeed.class, (mock, context) ->
            when(mock.getWindSpeedData(hour)).thenReturn(windSpeedTable[hour])
        )) {
            try (MockedConstruction<DatabankWindDirection> ignoredDatabankWindDirectionDouble
                     = mockConstruction(DatabankWindDirection.class, (mock, context) ->
                when(mock.getWindDirectionData(hour)).thenReturn(windDirectionTable[hour])
            )) {
                ValueWSInstantWind valueWS = new ValueWSInstantWind(hour);
                double expected = databankWindSpeedDouble.constructed()
                    .get(Parameters.ZERO).getWindSpeedData(hour);
                //Act & Assert
                assertEquals(expected, valueWS.getMeasurement(), Parameters.ASSERT_EQUALS_DOUBLES_TOLERANCE,
                    "Should return valid double.");
            }
        }
    }

    @Test
    void testWhenGettingInfoThenReturnValidString() throws IOException {
        //Arrange
        int hour = Parameters.HOUR_LOWER_BOUNDARY;
        double[] windSpeedTable = Functions.importWindSpeed();
        String[] windDirectionTable = Functions.importWindDirection();
        try (MockedConstruction<DatabankWindSpeed> ignoredDatabankWindSpeedDouble
                 = mockConstruction(DatabankWindSpeed.class, (mock, context) ->
            when(mock.getWindSpeedData(hour)).thenReturn(windSpeedTable[hour])
        )) {
            try (MockedConstruction<DatabankWindDirection> databankWindDirectionDouble
                     = mockConstruction(DatabankWindDirection.class, (mock, context) ->
                when(mock.getWindDirectionData(hour)).thenReturn(windDirectionTable[hour])
            )) {
                ValueWSInstantWind valueWS = new ValueWSInstantWind(hour);
                String expected = databankWindDirectionDouble.constructed()
                    .get(Parameters.ZERO).getWindDirectionData(hour);
                //Act & Assert
                assertEquals(expected, valueWS.getInfo(),
                    "Should return valid String.");
            }
        }
    }

    @Test
    void testWhenCallingObjectToStringThenReturnValidString() throws IOException {
        //Also tests getters.
        //Arrange
        int hour = Parameters.HOUR_UPPER_BOUNDARY;
        double[] windSpeedTable = Functions.importWindSpeed();
        String[] windDirectionTable = Functions.importWindDirection();
        try (MockedConstruction<DatabankWindSpeed> ignoredDatabankWindSpeedDouble
                 = mockConstruction(DatabankWindSpeed.class, (mock, context) ->
            when(mock.getWindSpeedData(hour)).thenReturn(windSpeedTable[hour])
        )) {
            try (MockedConstruction<DatabankWindDirection> ignoredDatabankWindDirectionDouble
                     = mockConstruction(DatabankWindDirection.class, (mock, context) ->
                when(mock.getWindDirectionData(hour)).thenReturn(windDirectionTable[hour])
            )) {
                ValueWSInstantWind valueWS = new ValueWSInstantWind(hour);
                String expected = "ValueWSInstantWind(" +
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
}
