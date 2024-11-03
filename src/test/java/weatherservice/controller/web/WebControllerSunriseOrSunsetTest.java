
package weatherservice.controller.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import weatherservice.ddd.ValueWS;
import weatherservice.domain.sunrise_or_sunset.ValueWSSunriseOrSunset;
import weatherservice.mapper.MapperConfig;
import weatherservice.mapper.ValueWSDto;
import weatherservice.mapper.ValueWSMapper;
import weatherservice.persistence.springdata.SpringDataConfig;
import weatherservice.service.ServiceConfig;
import weatherservice.service.ServiceSunriseOrSunset;
import weatherservice.utils.Parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WebControllerSunriseOrSunsetTest {
    @Test
    void testWhenGettingSunriseOrSunsetWithValidArgumentsThenReturnValidValueWSDtoObject()
        throws Exception {
        //Arrange
        int apiKey = Parameters.API_KEY_UPPER_BOUNDARY;
        double latitude = Parameters.LATITUDE_UPPER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_UPPER_BOUNDARY;
        String option = Parameters.SUNSET;
        ApplicationContext context = new AnnotationConfigApplicationContext
            (MapperConfig.class, SpringDataConfig.class, ServiceConfig.class);
        ServiceSunriseOrSunset serviceSunriseOrSunset
            = context.getBean(ServiceSunriseOrSunset.class);
        ValueWSMapper valueWSMapper = context.getBean(ValueWSMapper.class);
        WebControllerSunriseOrSunset webControllerSunriseOrSunset
            = new WebControllerSunriseOrSunset(serviceSunriseOrSunset, valueWSMapper);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(webControllerSunriseOrSunset).build();
        ObjectMapper objectMapper = new ObjectMapper();
        ValueWS valueWS = new ValueWSSunriseOrSunset(option);
        ValueWSDto valueWSDtoExpected = valueWSMapper.valueWSToDto(valueWS);
        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/SunriseOrSunset" +
                    "?apiKey=" + apiKey + "&latitude=" + latitude
                    + "&longitude=" + longitude + "&option=" + option)
                .contentType(MediaType.APPLICATION_JSON))
            .andReturn();
        //Assert
        assertEquals(valueWSDtoExpected.toString(),
            objectMapper.readValue(result.getResponse().getContentAsString(), ValueWSDto.class).toString(),
            "Should return valid value-object dto.");
    }

    @Test
    void testWhenGettingSunriseOrSunsetWithInvalidApiKeyThenReturnHttpStatusCode400()
        throws Exception {
        //Arrange
        int apiKey = Parameters.API_KEY_LOWER_BOUNDARY - Parameters.ONE;
        double latitude = Parameters.LATITUDE_LOWER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_LOWER_BOUNDARY;
        String option = Parameters.SUNRISE;
        ApplicationContext context = new AnnotationConfigApplicationContext
            (MapperConfig.class, SpringDataConfig.class, ServiceConfig.class);
        ServiceSunriseOrSunset serviceSunriseOrSunset
            = context.getBean(ServiceSunriseOrSunset.class);
        ValueWSMapper valueWSMapper = context.getBean(ValueWSMapper.class);
        WebControllerSunriseOrSunset webControllerSunriseOrSunset
            = new WebControllerSunriseOrSunset(serviceSunriseOrSunset, valueWSMapper);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(webControllerSunriseOrSunset).build();
        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/SunriseOrSunset" +
                    "?apiKey=" + apiKey + "&latitude=" + latitude
                    + "&longitude=" + longitude + "&option=" + option)
                .contentType(MediaType.APPLICATION_JSON))
            .andReturn();
        //Assert
        assertEquals(Parameters.HTTP_STATUS_CODE_400, result.getResponse().getStatus(),
            "Should return status code 400.");
    }

    @Test
    void testWhenGettingSunriseOrSunsetWithInvalidGpsCoordinatesThenReturnHttpStatusCode400()
        throws Exception {
        //Arrange
        int apiKey = Parameters.API_KEY_UPPER_BOUNDARY;
        double latitude = Parameters.LATITUDE_UPPER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_UPPER_BOUNDARY + Parameters.ONE;
        String option = Parameters.SUNSET;
        ApplicationContext context = new AnnotationConfigApplicationContext
            (MapperConfig.class, SpringDataConfig.class, ServiceConfig.class);
        ServiceSunriseOrSunset serviceSunriseOrSunset
            = context.getBean(ServiceSunriseOrSunset.class);
        ValueWSMapper valueWSMapper = context.getBean(ValueWSMapper.class);
        WebControllerSunriseOrSunset webControllerSunriseOrSunset
            = new WebControllerSunriseOrSunset(serviceSunriseOrSunset, valueWSMapper);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(webControllerSunriseOrSunset).build();
        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/SunriseOrSunset" +
                    "?apiKey=" + apiKey + "&latitude=" + latitude
                    + "&longitude=" + longitude + "&option=" + option)
                .contentType(MediaType.APPLICATION_JSON))
            .andReturn();
        //Assert
        assertEquals(Parameters.HTTP_STATUS_CODE_400, result.getResponse().getStatus(),
            "Should return status code 400.");
    }

    @Test
    void testWhenGettingSunriseOrSunsetWithInvalidOptionThenReturnHttpStatusCode400()
        throws Exception {
        //Arrange
        int apiKey = Parameters.API_KEY_LOWER_BOUNDARY;
        double latitude = Parameters.LATITUDE_LOWER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_LOWER_BOUNDARY;
        String option = Parameters.DAWN;
        ApplicationContext context = new AnnotationConfigApplicationContext
            (MapperConfig.class, SpringDataConfig.class, ServiceConfig.class);
        ServiceSunriseOrSunset serviceSunriseOrSunset
            = context.getBean(ServiceSunriseOrSunset.class);
        ValueWSMapper valueWSMapper = context.getBean(ValueWSMapper.class);
        WebControllerSunriseOrSunset webControllerSunriseOrSunset
            = new WebControllerSunriseOrSunset(serviceSunriseOrSunset, valueWSMapper);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(webControllerSunriseOrSunset).build();
        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/SunriseOrSunset" +
                    "?apiKey=" + apiKey + "&latitude=" + latitude
                    + "&longitude=" + longitude + "&option=" + option)
                .contentType(MediaType.APPLICATION_JSON))
            .andReturn();
        //Assert
        assertEquals(Parameters.HTTP_STATUS_CODE_400, result.getResponse().getStatus(),
            "Should return status code 400.");
    }
}
