
package weatherservice.service;

import org.springframework.stereotype.Component;
import weatherservice.ddd.AggregateRoot;
import weatherservice.ddd.DomainId;
import weatherservice.ddd.ValueWS;
import weatherservice.domain.instant_temperature.InstantTemperature;

import java.io.IOException;

@Component
public class FactoryInstantTemperature implements IFactoryInstantTemperature<DomainId, ValueWS> {
    @Override
    public AggregateRoot<DomainId, ValueWS> createInstantTemperature
        (int apiKey, double latitude, double longitude, int hour) throws IOException {
        return new InstantTemperature(apiKey, latitude, longitude, hour);
    }
}
