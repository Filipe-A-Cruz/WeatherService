
package weatherservice.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServiceConfigTest {
    @Test
    void testWhenCallingObjectToStringThenReturnValidString() {
        //Arrange
        ServiceConfig serviceConfig = new ServiceConfig();
        String expected = "ServiceConfig()";
        //Act & Assert
        assertEquals(expected, serviceConfig.toString(),
            "Should return valid String.");
    }
}
