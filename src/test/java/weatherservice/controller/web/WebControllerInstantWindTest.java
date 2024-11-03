
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
import weatherservice.domain.instant_wind.ValueWSInstantWind;
import weatherservice.mapper.MapperConfig;
import weatherservice.mapper.ValueWSDto;
import weatherservice.mapper.ValueWSMapper;
import weatherservice.persistence.springdata.SpringDataConfig;
import weatherservice.service.ServiceConfig;
import weatherservice.service.ServiceInstantWind;
import weatherservice.utils.Parameters;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WebControllerInstantWindTest {
    @Test
    void testWhenGettingInstantWindWithValidArgumentsThenReturnValidValueWSDtoObject()
        throws Exception {
        //Arrange
        int apiKey = Parameters.API_KEY_UPPER_BOUNDARY;
        double latitude = Parameters.LATITUDE_UPPER_BOUNDARY;
        double longitude = Parameters.LATITUDE_UPPER_BOUNDARY;
        int hour = Parameters.HOUR_UPPER_BOUNDARY;
        ApplicationContext context = new AnnotationConfigApplicationContext
            (MapperConfig.class, SpringDataConfig.class, ServiceConfig.class);
        ServiceInstantWind serviceInstantWind
            = context.getBean(ServiceInstantWind.class);
        ValueWSMapper valueWSMapper = context.getBean(ValueWSMapper.class);
        WebControllerInstantWind webControllerInstantWind
            = new WebControllerInstantWind(serviceInstantWind, valueWSMapper);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(webControllerInstantWind).build();
        ObjectMapper objectMapper = new ObjectMapper();
        ValueWS valueWS = new ValueWSInstantWind(hour);
        ValueWSDto valueWSDtoExpected = valueWSMapper.valueWSToDto(valueWS);
        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/InstantWind" +
                    "?apiKey=" + apiKey + "&latitude=" + latitude
                    + "&longitude=" + longitude + "&hour=" + hour)
                .contentType(MediaType.APPLICATION_JSON))
            .andReturn();
        //Assert
        assertEquals(valueWSDtoExpected.toString(),
            objectMapper.readValue(result.getResponse().getContentAsString(), ValueWSDto.class).toString(),
            "Should return valid value-object dto.");
    }

    @Test
    void testWhenGettingInstantWindWithInvalidApiKeyThenReturnHttpStatusCode400()
        throws Exception {
        //Arrange
        int apiKey = Parameters.API_KEY_LOWER_BOUNDARY - Parameters.ONE;
        double latitude = Parameters.LATITUDE_LOWER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_LOWER_BOUNDARY;
        int hour = Parameters.HOUR_LOWER_BOUNDARY;
        ApplicationContext context = new AnnotationConfigApplicationContext
            (MapperConfig.class, SpringDataConfig.class, ServiceConfig.class);
        ServiceInstantWind serviceInstantWind
            = context.getBean(ServiceInstantWind.class);
        ValueWSMapper valueWSMapper = context.getBean(ValueWSMapper.class);
        WebControllerInstantWind webControllerInstantWind
            = new WebControllerInstantWind(serviceInstantWind, valueWSMapper);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(webControllerInstantWind).build();
        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/InstantWind" +
                    "?apiKey=" + apiKey + "&latitude=" + latitude
                    + "&longitude=" + longitude + "&hour=" + hour)
                .contentType(MediaType.APPLICATION_JSON))
            .andReturn();
        //Assert
        assertEquals(Parameters.HTTP_STATUS_CODE_400, result.getResponse().getStatus(),
            "Should return status code 400.");
    }

    @Test
    void testWhenGettingInstantWindWithInvalidGpsCoordinatesThenReturnHttpStatusCode400()
        throws Exception {
        //Arrange
        int apiKey = Parameters.API_KEY_UPPER_BOUNDARY;
        double latitude = Parameters.LATITUDE_UPPER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_UPPER_BOUNDARY + Parameters.ONE;
        int hour = Parameters.HOUR_UPPER_BOUNDARY;
        ApplicationContext context = new AnnotationConfigApplicationContext
            (MapperConfig.class, SpringDataConfig.class, ServiceConfig.class);
        ServiceInstantWind serviceInstantWind
            = context.getBean(ServiceInstantWind.class);
        ValueWSMapper valueWSMapper = context.getBean(ValueWSMapper.class);
        WebControllerInstantWind webControllerInstantWind
            = new WebControllerInstantWind(serviceInstantWind, valueWSMapper);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(webControllerInstantWind).build();
        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/InstantWind" +
                    "?apiKey=" + apiKey + "&latitude=" + latitude
                    + "&longitude=" + longitude + "&hour=" + hour)
                .contentType(MediaType.APPLICATION_JSON))
            .andReturn();
        //Assert
        assertEquals(Parameters.HTTP_STATUS_CODE_400, result.getResponse().getStatus(),
            "Should return status code 400.");
    }

    @Test
    void testWhenGettingInstantWindWithInvalidHourThenReturnHttpStatusCode400()
        throws Exception {
        //Arrange
        int apiKey = Parameters.API_KEY_LOWER_BOUNDARY;
        double latitude = Parameters.LATITUDE_LOWER_BOUNDARY;
        double longitude = Parameters.LONGITUDE_LOWER_BOUNDARY;
        int hour = Parameters.HOUR_LOWER_BOUNDARY - Parameters.ONE;
        ApplicationContext context = new AnnotationConfigApplicationContext
            (MapperConfig.class, SpringDataConfig.class, ServiceConfig.class);
        ServiceInstantWind serviceInstantWind
            = context.getBean(ServiceInstantWind.class);
        ValueWSMapper valueWSMapper = context.getBean(ValueWSMapper.class);
        WebControllerInstantWind webControllerInstantWind
            = new WebControllerInstantWind(serviceInstantWind, valueWSMapper);
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(webControllerInstantWind).build();
        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/InstantWind" +
                    "?apiKey=" + apiKey + "&latitude=" + latitude
                    + "&longitude=" + longitude + "&hour=" + hour)
                .contentType(MediaType.APPLICATION_JSON))
            .andReturn();
        //Assert
        assertEquals(Parameters.HTTP_STATUS_CODE_400, result.getResponse().getStatus(),
            "Should return status code 400.");
    }
}
