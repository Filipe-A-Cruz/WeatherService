
package weatherservice.controller.web;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import weatherservice.ddd.ValueWS;
import weatherservice.mapper.ValueWSDto;
import weatherservice.mapper.ValueWSMapper;
import weatherservice.service.ServiceSunriseOrSunset;
import weatherservice.utils.Parameters;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/SunriseOrSunset")
public class WebControllerSunriseOrSunset {
    private static final Logger LOGGER = Logger.getAnonymousLogger();
    private final ServiceSunriseOrSunset serviceSunriseOrSunset;
    private final ValueWSMapper valueWSMapper;

    public WebControllerSunriseOrSunset
        (ServiceSunriseOrSunset serviceSunriseOrSunset, ValueWSMapper valueWSMapper) {
        this.serviceSunriseOrSunset = serviceSunriseOrSunset;
        this.valueWSMapper = valueWSMapper;
    }

    @GetMapping("")
    public ResponseEntity<ValueWSDto> getSunriseOrSunset
        (@RequestParam("apiKey") int apiKey,
         @RequestParam("latitude") double latitude,
         @RequestParam("longitude") double longitude,
         @RequestParam("option") String option) {
        try {
            final ValueWS valueWS
                = serviceSunriseOrSunset.getSunriseOrSunset(apiKey, latitude, longitude, option);
            final ValueWSDto valueWSDto = valueWSMapper.valueWSToDto(valueWS);
            return new ResponseEntity<>(linkBuilder(valueWSDto), HttpStatus.OK);
        } catch (IllegalArgumentException | IOException exception) {
            LOGGER.log(Level.INFO, exception.getMessage(), exception);
            return new ResponseEntity<>(linkBuilder(new ValueWSDto(Double.NaN,
                Parameters.EMPTY_STRING, Parameters.INVALID_ARGUMENTS)), HttpStatus.BAD_REQUEST);
        }
    }

    private static ValueWSDto linkBuilder(ValueWSDto valueWSDto) {
        final Link linkInstantTemperature
            = linkTo(WebControllerInstantTemperature.class).withRel("InstantTemperature");
        final Link linkInstantWind
            = linkTo(WebControllerInstantWind.class).withRel("InstantWind");
        final Link linkMaxWindOverPeriod
            = linkTo(WebControllerMaxWindOverPeriod.class).withRel("MaxWindOverPeriod");
        final Link linkSunriseOrSunset
            = linkTo(WebControllerSunriseOrSunset.class).withSelfRel();
        return valueWSDto.add(linkInstantTemperature, linkInstantWind,
            linkMaxWindOverPeriod, linkSunriseOrSunset);
    }
}
