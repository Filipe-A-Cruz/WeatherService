
package weatherservice.persistence.datamodel;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import weatherservice.ddd.ValueWS;
import weatherservice.domain.sunrise_or_sunset.SunriseOrSunset;
import weatherservice.domain.sunrise_or_sunset.ValueWSSunriseOrSunset;
import weatherservice.utils.Parameters;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SunriseOrSunsetDataModelTest {
    @ParameterizedTest
    @ValueSource(strings = {Parameters.SUNRISE, Parameters.SUNSET})
    void testWhenCallingObjectToStringThenReturnValidString(String option) throws IOException {
        //Arrange
        int apiKey = Parameters.API_KEY_UPPER_BOUNDARY;
        double latitude = Parameters.LATITUDE_UPPER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_UPPER_BOUNDARY;
        ValueWS valueWS = new ValueWSSunriseOrSunset(option);
        SunriseOrSunset sunriseOrSunset = new SunriseOrSunset(apiKey, latitude, longitude, option);
        SunriseOrSunsetDataModel sunriseOrSunsetDataModel
            = new SunriseOrSunsetDataModel(sunriseOrSunset);
        String expected = "SunriseOrSunsetDataModel(" +
            "idSunriseOrSunsetApiKey=" + apiKey +
            ", valueWSSunriseOrSunsetMeasurement=" + valueWS.getMeasurement() +
            ", valueWSSunriseOrSunsetUnit=" + valueWS.getUnit() +
            ", valueWSSunriseOrSunsetInfo=" + valueWS.getInfo() +
            ')';
        //Act & Assert
        assertEquals(expected, sunriseOrSunsetDataModel.toString(),
            "Should return valid String.");
    }

    @Test
    void testWhenCallingObjectToStringForEmptyConstructorThenReturnValidString() {
        //Arrange
        SunriseOrSunsetDataModel sunriseOrSunsetDataModel = new SunriseOrSunsetDataModel();
        String expected = "SunriseOrSunsetDataModel(" +
            "idSunriseOrSunsetApiKey=" + Parameters.ZERO +
            ", valueWSSunriseOrSunsetMeasurement=" + Parameters.ZERO_DOUBLE_ONE_DECIMAL_PLACE +
            ", valueWSSunriseOrSunsetUnit=" + Parameters.NULL +
            ", valueWSSunriseOrSunsetInfo=" + Parameters.NULL +
            ')';
        //Act & Assert
        assertEquals(expected, sunriseOrSunsetDataModel.toString(),
            "Should return valid String.");
    }
}
