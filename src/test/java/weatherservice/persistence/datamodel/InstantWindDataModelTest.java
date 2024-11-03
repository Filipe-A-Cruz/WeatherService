
package weatherservice.persistence.datamodel;

import org.junit.jupiter.api.Test;
import weatherservice.ddd.ValueWS;
import weatherservice.domain.instant_wind.ValueWSInstantWind;
import weatherservice.domain.instant_wind.InstantWind;
import weatherservice.utils.Parameters;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InstantWindDataModelTest {
    @Test
    void testWhenCallingObjectToStringThenReturnValidString() throws IOException {
        //Arrange
        int apiKey = Parameters.API_KEY_UPPER_BOUNDARY;
        double latitude = Parameters.LATITUDE_UPPER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_UPPER_BOUNDARY;
        int hour = Parameters.HOUR_UPPER_BOUNDARY;
        ValueWS valueWS = new ValueWSInstantWind(hour);
        InstantWind instantWind = new InstantWind(apiKey, latitude, longitude, hour);
        InstantWindDataModel instantWindDataModel
            = new InstantWindDataModel(instantWind);
        String expected = "InstantWindDataModel(" +
            "idInstantWindApiKey=" + apiKey +
            ", valueWSInstantWindMeasurement=" + valueWS.getMeasurement() +
            ", valueWSInstantWindUnit=" + valueWS.getUnit() +
            ", valueWSInstantWindInfo=" + valueWS.getInfo() +
            ')';
        //Act & Assert
        assertEquals(expected, instantWindDataModel.toString(),
            "Should return valid String.");
    }

    @Test
    void testWhenCallingObjectToStringForEmptyConstructorThenReturnValidString() {
        //Arrange
        InstantWindDataModel instantWindDataModel = new InstantWindDataModel();
        String expected = "InstantWindDataModel(" +
            "idInstantWindApiKey=" + Parameters.ZERO +
            ", valueWSInstantWindMeasurement=" + Parameters.ZERO_DOUBLE_ONE_DECIMAL_PLACE +
            ", valueWSInstantWindUnit=" + Parameters.NULL +
            ", valueWSInstantWindInfo=" + Parameters.NULL +
            ')';
        //Act & Assert
        assertEquals(expected, instantWindDataModel.toString(),
            "Should return valid String.");
    }
}
