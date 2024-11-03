
package weatherservice.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import weatherservice.ddd.AggregateRoot;
import weatherservice.ddd.DomainId;
import weatherservice.ddd.IRepository;
import weatherservice.ddd.ValueWS;

import java.io.IOException;

@Service
public class ServiceMaxWindOverPeriod {
    private final IFactoryMaxWindOverPeriod<DomainId, ValueWS> factoryMaxWindOverPeriod;
    private final IRepository<DomainId, ValueWS, AggregateRoot<DomainId, ValueWS>>
        repositoryMaxWindOverPeriodSpringData;

    public ServiceMaxWindOverPeriod
        (IFactoryMaxWindOverPeriod<DomainId, ValueWS> factoryMaxWindOverPeriod,
         @Qualifier("maxWindOverPeriodSpringData")
         IRepository<DomainId, ValueWS, AggregateRoot<DomainId, ValueWS>> repositoryMaxWindOverPeriodSpringData) {
        this.factoryMaxWindOverPeriod = factoryMaxWindOverPeriod;
        this.repositoryMaxWindOverPeriodSpringData = repositoryMaxWindOverPeriodSpringData;
    }

    public ValueWS getMaxWindOverPeriod
        (int apiKey, double latitude, double longitude, int hourStart, int hourEnd) throws IOException {
        final AggregateRoot<DomainId, ValueWS> maxWindOverPeriod
            = factoryMaxWindOverPeriod.createMaxWindOverPeriod(apiKey, latitude, longitude, hourStart, hourEnd);
        repositoryMaxWindOverPeriodSpringData.save(maxWindOverPeriod);
        return maxWindOverPeriod.getValueWS();
    }
}
