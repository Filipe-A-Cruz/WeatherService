
package weatherservice.persistence.springdata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SpringDataConfigTest {
    @Test
    void testWhenCallingObjectToStringThenReturnValidString() {
        //Arrange
        SpringDataConfig springDataConfig = new SpringDataConfig();
        String expected = "SpringDataConfig()";
        //Act & Assert
        assertEquals(expected, springDataConfig.toString(),
            "Should return valid String.");
    }
}
