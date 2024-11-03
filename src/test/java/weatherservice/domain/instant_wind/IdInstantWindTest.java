
package weatherservice.domain.instant_wind;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import weatherservice.ddd.DomainId;
import weatherservice.utils.Parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IdInstantWindTest {
    @ParameterizedTest
    @ValueSource(ints = {Parameters.API_KEY_LOWER_BOUNDARY, Parameters.API_KEY_UPPER_BOUNDARY})
    void testWhenCreatingIdInstantWindWithValidApiKeyThenReturnValidId(int apiKey) {
        //Arrange
        DomainId idInstantWindExpected = new IdInstantWind(apiKey);
        //Act
        DomainId idInstantWindResult = new IdInstantWind(apiKey);
        //Assert
        assertEquals(idInstantWindExpected.toString(), idInstantWindResult.toString(),
            "Should return valid Id");
    }

    @ParameterizedTest
    @ValueSource(ints = {Parameters.API_KEY_LOWER_BOUNDARY - Parameters.ONE,
        Parameters.API_KEY_UPPER_BOUNDARY + Parameters.ONE})
    void testWhenCreatingIdInstantWindWithInvalidApiKeyThenThrowAnException(int apiKey) {
        //Arrange done by ParameterizedTest
        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new IdInstantWind(apiKey),
            "Should throw an exception.");
    }
}
