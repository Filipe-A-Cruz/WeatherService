
package weatherservice.service;

import org.springframework.stereotype.Component;
import weatherservice.ddd.AggregateRoot;
import weatherservice.ddd.DomainId;
import weatherservice.ddd.ValueWS;
import weatherservice.domain.instant_wind.InstantWind;

import java.io.IOException;

@Component
public class FactoryInstantWind implements IFactoryInstantWind<DomainId, ValueWS> {
    @Override
    public AggregateRoot<DomainId, ValueWS> createInstantWind
        (int apiKey, double latitude, double longitude, int hour) throws IOException {
        return new InstantWind(apiKey, latitude, longitude, hour);
    }
}
