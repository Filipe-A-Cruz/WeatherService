
package weatherservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WeatherServiceApplicationTest {
    @Test
    void testWhenCallingObjectToStringThenReturnValidString() {
        //Arrange
        WeatherServiceApplication weatherServiceApplication = new WeatherServiceApplication();
        String expected = "WeatherServiceApplication()";
        //Act & Assert
        assertEquals(expected, weatherServiceApplication.toString(),
            "Should return valid String.");
    }
}
