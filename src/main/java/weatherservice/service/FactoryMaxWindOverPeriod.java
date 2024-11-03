
package weatherservice.service;

import org.springframework.stereotype.Component;
import weatherservice.ddd.AggregateRoot;
import weatherservice.ddd.DomainId;
import weatherservice.ddd.ValueWS;
import weatherservice.domain.max_wind_over_period.MaxWindOverPeriod;

import java.io.IOException;

@Component
public class FactoryMaxWindOverPeriod implements IFactoryMaxWindOverPeriod<DomainId, ValueWS> {
    @Override
    public AggregateRoot<DomainId, ValueWS> createMaxWindOverPeriod
        (int apiKey, double latitude, double longitude, int hourStart, int hourEnd) throws IOException {
        return new MaxWindOverPeriod(apiKey, latitude, longitude, hourStart, hourEnd);
    }
}
