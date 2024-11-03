
package weatherservice.domain.sunrise_or_sunset;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import weatherservice.ddd.DomainId;
import weatherservice.utils.Parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IdSunriseOrSunsetTest {
    @ParameterizedTest
    @ValueSource(ints = {Parameters.API_KEY_LOWER_BOUNDARY, Parameters.API_KEY_UPPER_BOUNDARY})
    void testWhenCreatingIdSunriseOrSunsetWithValidApiKeyThenReturnValidId(int apiKey) {
        //Arrange
        DomainId idSunriseOrSunsetExpected = new IdSunriseOrSunset(apiKey);
        //Act
        DomainId idSunriseOrSunsetResult = new IdSunriseOrSunset(apiKey);
        //Assert
        assertEquals(idSunriseOrSunsetExpected.toString(),
            idSunriseOrSunsetResult.toString(),
            "Should return valid Id");
    }

    @ParameterizedTest
    @ValueSource(ints = {Parameters.API_KEY_LOWER_BOUNDARY - Parameters.ONE,
        Parameters.API_KEY_UPPER_BOUNDARY + Parameters.ONE})
    void testWhenCreatingIdSunriseOrSunsetWithInvalidApiKeyThenThrowAnException(int apiKey) {
        //Arrange done by ParameterizedTest
        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new IdSunriseOrSunset(apiKey),
            "Should throw an exception.");
    }
}
