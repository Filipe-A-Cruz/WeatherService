
package weatherservice.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParametersTest {
    @Test
    void testWhenCallingObjectToStringThenReturnValidString() {
        //Arrange
        Parameters parameters = new Parameters();
        String expected = "Parameters()";
        //Act & Assert
        assertEquals(expected, parameters.toString(),
            "Should return valid String.");
    }
}
