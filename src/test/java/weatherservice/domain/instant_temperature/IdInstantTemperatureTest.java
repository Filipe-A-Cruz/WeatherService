
package weatherservice.domain.instant_temperature;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import weatherservice.ddd.DomainId;
import weatherservice.utils.Parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IdInstantTemperatureTest {
    @ParameterizedTest
    @ValueSource(ints = {Parameters.API_KEY_LOWER_BOUNDARY, Parameters.API_KEY_UPPER_BOUNDARY})
    void testWhenCreatingIdInstantTemperatureWithValidApiKeyThenReturnValidId(int apiKey) {
        //Arrange
        DomainId idInstantTemperatureExpected = new IdInstantTemperature(apiKey);
        //Act
        DomainId idInstantTemperatureResult = new IdInstantTemperature(apiKey);
        //Assert
        assertEquals(idInstantTemperatureExpected.toString(), idInstantTemperatureResult.toString(),
            "Should return valid Id");
    }

    @ParameterizedTest
    @ValueSource(ints = {Parameters.API_KEY_LOWER_BOUNDARY - Parameters.ONE,
        Parameters.API_KEY_UPPER_BOUNDARY + Parameters.ONE})
    void testWhenCreatingIdInstantTemperatureWithInvalidApiKeyThenThrowAnException(int apiKey) {
        //Arrange done by ParameterizedTest
        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new IdInstantTemperature(apiKey),
            "Should throw an exception.");
    }
}
