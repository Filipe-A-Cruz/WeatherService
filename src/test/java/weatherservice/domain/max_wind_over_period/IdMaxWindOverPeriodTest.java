
package weatherservice.domain.max_wind_over_period;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import weatherservice.ddd.DomainId;
import weatherservice.utils.Parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IdMaxWindOverPeriodTest {
    @ParameterizedTest
    @ValueSource(ints = {Parameters.API_KEY_LOWER_BOUNDARY, Parameters.API_KEY_UPPER_BOUNDARY})
    void testWhenCreatingIdMaxWindOverPeriodWithValidApiKeyThenReturnValidId(int apiKey) {
        //Arrange
        DomainId idMaxWindOverPeriodExpected = new IdMaxWindOverPeriod(apiKey);
        //Act
        DomainId idMaxWindOverPeriodResult = new IdMaxWindOverPeriod(apiKey);
        //Assert
        assertEquals(idMaxWindOverPeriodExpected.toString(), idMaxWindOverPeriodResult.toString(),
            "Should return valid Id");
    }

    @ParameterizedTest
    @ValueSource(ints = {Parameters.API_KEY_LOWER_BOUNDARY - Parameters.ONE,
        Parameters.API_KEY_UPPER_BOUNDARY + Parameters.ONE})
    void testWhenCreatingIdMaxWIndOverPeriodWithInvalidApiKeyThenThrowAnException(int apiKey) {
        //Arrange done by ParameterizedTest
        //Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new IdMaxWindOverPeriod(apiKey),
            "Should throw an exception.");
    }
}
