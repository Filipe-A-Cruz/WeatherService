package weatherservice.domain.max_wind_over_period;

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

class ValueWSMaxWindOverPeriodTest {
    @Test
    void testWhenGettingMeasurementThenReturnValidDouble() throws IOException {
        //Arrange
        int hourStart = Parameters.HOUR_LOWER_BOUNDARY;
        int hourEnd = Parameters.HOUR_UPPER_BOUNDARY;
        double[] windSpeedTable = Functions.importWindSpeed();
        String[] windDirectionTable = Functions.importWindDirection();
        try (MockedConstruction<DatabankWindSpeed> databankWindSpeedDouble
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
                ValueWSMaxWindOverPeriod valueWS = new ValueWSMaxWindOverPeriod(hourStart, hourEnd);
                double expected = 0.00;
                for (int i = hourStart; i <= hourEnd; i++) {
                    expected = Math.max(expected, databankWindSpeedDouble.constructed()
                        .get(Parameters.ZERO).getWindSpeedData(i));
                }
                //Act & Assert
                assertEquals(expected, valueWS.getMeasurement(),
                    "Should return valid double.");
            }
        }
    }

    @Test
    void testWhenGettingInfoThenReturnValidString() throws IOException {
        //Arrange
        int hourStart = Parameters.HOUR_LOWER_BOUNDARY;
        int hourEnd = Parameters.HOUR_UPPER_BOUNDARY;
        double[] windSpeedTable = Functions.importWindSpeed();
        String[] windDirectionTable = Functions.importWindDirection();
        try (MockedConstruction<DatabankWindSpeed> databankWindSpeedDouble
                 = mockConstruction(DatabankWindSpeed.class, (mock, context) -> {
            for (int i = hourStart; i <= hourEnd; i++) {
                when(mock.getWindSpeedData(i)).thenReturn(windSpeedTable[i]);
            }
        })) {
            try (MockedConstruction<DatabankWindDirection> databankWindDirectionDouble
                     = mockConstruction(DatabankWindDirection.class, (mock, context) -> {
                for (int i = hourStart; i <= hourEnd; i++) {
                    when(mock.getWindDirectionData(i)).thenReturn(windDirectionTable[i]);
                }
            })) {
                ValueWSMaxWindOverPeriod valueWS
                    = new ValueWSMaxWindOverPeriod(hourStart, hourEnd);
                double maxMeasurement = 0.00;
                for (int i = hourStart; i <= hourEnd; i++) {
                    maxMeasurement = Math.max(maxMeasurement, databankWindSpeedDouble.constructed()
                        .get(0).getWindSpeedData(i));
                }
                StringBuilder maxWindSpeedDirections = new StringBuilder();
                for (int i = hourStart; i <= hourEnd; i++) {
                    if (Math.abs(Math.round(databankWindSpeedDouble.constructed().get(0).getWindSpeedData(i)
                        * Parameters.INVERSE_WIND_SPEED_PRECISION)
                        - Math.round(maxMeasurement
                        * Parameters.INVERSE_WIND_SPEED_PRECISION)) < Parameters.ONE) {
                        maxWindSpeedDirections.append(databankWindDirectionDouble.constructed()
                            .get(Parameters.ZERO).getWindDirectionData(i)).append(' ');
                    }
                }
                String expected = maxWindSpeedDirections
                    .substring(Parameters.ZERO, maxWindSpeedDirections.length() - Parameters.ONE);
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
                ValueWSMaxWindOverPeriod valueWS = new ValueWSMaxWindOverPeriod(hourStart, hourEnd);
                String expected = "ValueWSMaxWindOverPeriod(" +
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
