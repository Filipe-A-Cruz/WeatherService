
package weatherservice.persistence.datamodel;

import org.junit.jupiter.api.Test;
import weatherservice.ddd.ValueWS;
import weatherservice.domain.max_wind_over_period.ValueWSMaxWindOverPeriod;
import weatherservice.domain.max_wind_over_period.MaxWindOverPeriod;
import weatherservice.utils.Parameters;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxWindOverPeriodDataModelTest {
    @Test
    void testWhenCallingObjectToStringThenReturnValidString() throws IOException {
        //Arrange
        int apiKey = Parameters.API_KEY_LOWER_BOUNDARY;
        double latitude = Parameters.LATITUDE_LOWER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_LOWER_BOUNDARY;
        int hourStart = Parameters.HOUR_LOWER_BOUNDARY;
        int hourEnd = Parameters.HOUR_UPPER_BOUNDARY;
        ValueWS valueWS = new ValueWSMaxWindOverPeriod(hourStart, hourEnd);
        MaxWindOverPeriod maxWindOverPeriod = new MaxWindOverPeriod(apiKey, latitude, longitude, hourStart, hourEnd);
        MaxWindOverPeriodDataModel maxWindOverPeriodDataModel
            = new MaxWindOverPeriodDataModel(maxWindOverPeriod);
        String expected = "MaxWIndOverPeriodDataModel(" +
            "idMaxWIndOverPeriodApiKey=" + apiKey +
            ", valueWSMaxWIndOverPeriodMeasurement=" + valueWS.getMeasurement() +
            ", valueWSMaxWIndOverPeriodUnit=" + valueWS.getUnit() +
            ", valueWSMaxWIndOverPeriodInfo=" + valueWS.getInfo() +
            ')';
        //Act & Assert
        assertEquals(expected, maxWindOverPeriodDataModel.toString(),
            "Should return valid String.");
    }

    @Test
    void testWhenCallingObjectToStringForEmptyConstructorThenReturnValidString() {
        //Arrange
        MaxWindOverPeriodDataModel maxWindOverPeriodDataModel = new MaxWindOverPeriodDataModel();
        String expected = "MaxWIndOverPeriodDataModel(" +
            "idMaxWIndOverPeriodApiKey=" + Parameters.ZERO +
            ", valueWSMaxWIndOverPeriodMeasurement=" + Parameters.ZERO_DOUBLE_ONE_DECIMAL_PLACE +
            ", valueWSMaxWIndOverPeriodUnit=" + Parameters.NULL +
            ", valueWSMaxWIndOverPeriodInfo=" + Parameters.NULL +
            ')';
        //Act & Assert
        assertEquals(expected, maxWindOverPeriodDataModel.toString(),
            "Should return valid String.");
    }
}
