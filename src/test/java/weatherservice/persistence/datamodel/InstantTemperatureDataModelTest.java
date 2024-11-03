
package weatherservice.persistence.datamodel;

import org.junit.jupiter.api.Test;
import weatherservice.ddd.ValueWS;
import weatherservice.domain.instant_temperature.ValueWSInstantTemperature;
import weatherservice.domain.instant_temperature.InstantTemperature;
import weatherservice.utils.Parameters;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InstantTemperatureDataModelTest {
    @Test
    void testWhenCallingObjectToStringThenReturnValidString() throws IOException {
        //Arrange
        int apiKey = Parameters.API_KEY_LOWER_BOUNDARY;
        double latitude = Parameters.LATITUDE_LOWER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_LOWER_BOUNDARY;
        int hour = Parameters.HOUR_LOWER_BOUNDARY;
        ValueWS valueWS = new ValueWSInstantTemperature(hour);
        InstantTemperature instantTemperature = new InstantTemperature(apiKey, latitude, longitude, hour);
        InstantTemperatureDataModel instantTemperatureDataModel
            = new InstantTemperatureDataModel(instantTemperature);
        String expected = "InstantTemperatureDataModel(" +
            "idInstantTemperatureApiKey=" + apiKey +
            ", valueWSInstantTemperatureMeasurement=" + valueWS.getMeasurement() +
            ", valueWSInstantTemperatureUnit=" + valueWS.getUnit() +
            ", valueWSInstantTemperatureInfo=" + valueWS.getInfo() +
            ')';
        //Act & Assert
        assertEquals(expected, instantTemperatureDataModel.toString(),
            "Should return valid String.");
    }

    @Test
    void testWhenCallingObjectToStringForEmptyConstructorThenReturnValidString() {
        //Arrange
        InstantTemperatureDataModel instantTemperatureDataModel = new InstantTemperatureDataModel();
        String expected = "InstantTemperatureDataModel(" +
            "idInstantTemperatureApiKey=" + Parameters.ZERO +
            ", valueWSInstantTemperatureMeasurement=" + Parameters.ZERO_DOUBLE_ONE_DECIMAL_PLACE +
            ", valueWSInstantTemperatureUnit=" + Parameters.NULL +
            ", valueWSInstantTemperatureInfo=" + Parameters.NULL +
            ')';
        //Act & Assert
        assertEquals(expected, instantTemperatureDataModel.toString(),
            "Should return valid String.");
    }
}
