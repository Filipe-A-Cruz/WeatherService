
package weatherservice.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static java.lang.Double.NaN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FunctionsTest {
    @ParameterizedTest
    @ValueSource(doubles = {Parameters.LATITUDE_LOWER_BOUNDARY, Parameters.LATITUDE_UPPER_BOUNDARY})
    void testWhenCheckingIfGpsCoordinatesAreInvalidWithLowerOrUpperBoundaryLatitudeThenReturnFalse
        (double latitude) {
        //Arrange
        double longitude = Parameters.LONGITUDE_LOWER_BOUNDARY;
        //Act & Assert
        assertFalse(Functions.isInvalidGpsCoordinates(latitude, longitude),
            "Should return False.");
    }

    @ParameterizedTest
    @ValueSource(doubles = {Parameters.LATITUDE_LOWER_BOUNDARY - Parameters.ONE,
        Parameters.LATITUDE_UPPER_BOUNDARY + Parameters.ONE})
    void testWhenCheckingIfGpsCoordinatesAreInvalidWithLatitudeOutsideValidRangeThenReturnTrue
        (double latitude) {
        //Arrange
        double longitude = Parameters.LONGITUDE_UPPER_BOUNDARY;
        //Act & Assert
        assertTrue(Functions.isInvalidGpsCoordinates(latitude, longitude),
            "Should return True.");
    }

    @Test
    void testWhenCheckingIfGpsCoordinatesAreInvalidWithLatitudeNaNThenReturnTrue() {
        //Arrange
        double latitude;
        latitude = NaN;
        double longitude = Parameters.LONGITUDE_LOWER_BOUNDARY;
        //Act & Assert
        assertTrue(Functions.isInvalidGpsCoordinates(latitude, longitude),
            "Should return True.");
    }

    @ParameterizedTest
    @ValueSource(doubles = {Parameters.LONGITUDE_LOWER_BOUNDARY, Parameters.LONGITUDE_UPPER_BOUNDARY})
    void testWhenCheckingIfGpsCoordinatesAreInvalidWithLowerOrUpperBoundaryLongitudeThenReturnFalse
        (double longitude) {
        //Arrange
        double latitude = Parameters.LATITUDE_UPPER_BOUNDARY;
        //Act & Assert
        assertFalse(Functions.isInvalidGpsCoordinates(latitude, longitude),
            "Should return False.");
    }

    @ParameterizedTest
    @ValueSource(doubles = {Parameters.LONGITUDE_LOWER_BOUNDARY - Parameters.ONE,
        Parameters.LONGITUDE_UPPER_BOUNDARY + Parameters.ONE})
    void testWhenCheckingIfGpsCoordinatesAreInvalidWithLongitudeOutsideValidRangeThenReturnTrue
        (double longitude) {
        //Arrange
        double latitude = Parameters.LATITUDE_LOWER_BOUNDARY;
        //Act & Assert
        assertTrue(Functions.isInvalidGpsCoordinates(latitude, longitude),
            "Should return True.");
    }

    @Test
    void testWhenCheckingIfGpsCoordinatesAreInvalidWithLongitudeNaNThenReturnTrue() {
        //Arrange
        double latitude = Parameters.LATITUDE_UPPER_BOUNDARY;
        double longitude;
        longitude = NaN;
        //Act & Assert
        assertTrue(Functions.isInvalidGpsCoordinates(latitude, longitude),
            "Should return True.");
    }

    @Test
    void testWhenCallingObjectToStringThenReturnValidString() {
        //Arrange
        Functions functions = new Functions();
        String expected = "Functions()";
        //Act & Assert
        assertEquals(expected, functions.toString(),
            "Should return valid String.");
    }
}
