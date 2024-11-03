
package weatherservice.service;

import org.springframework.stereotype.Component;
import weatherservice.ddd.AggregateRoot;
import weatherservice.ddd.DomainId;
import weatherservice.ddd.ValueWS;
import weatherservice.domain.sunrise_or_sunset.SunriseOrSunset;

import java.io.IOException;

@Component
public class FactorySunriseOrSunset implements IFactorySunriseOrSunset<DomainId, ValueWS> {
    @Override
    public AggregateRoot<DomainId, ValueWS> createSunriseOrSunset
        (int apiKey, double latitude, double longitude, String option) throws IOException {
        return new SunriseOrSunset(apiKey, latitude, longitude, option);
    }
}
