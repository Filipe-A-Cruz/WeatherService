
package weatherservice.mapper;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapperConfigTest {
    @Test
    void testWhenCallingObjectToStringThenReturnValidString() {
        //Arrange
        MapperConfig mapperConfig = new MapperConfig();
        String expected = "MapperConfig()";
        //Act & Assert
        assertEquals(expected, mapperConfig.toString(),
            "Should return valid String.");
    }
}
