
package weatherservice.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import weatherservice.ddd.AggregateRoot;
import weatherservice.ddd.DomainId;
import weatherservice.ddd.IRepository;
import weatherservice.ddd.ValueWS;

import java.io.IOException;

@Service
public class ServiceInstantWind {
    private final IFactoryInstantWind<DomainId, ValueWS> factoryInstantWind;
    private final IRepository<DomainId, ValueWS, AggregateRoot<DomainId, ValueWS>>
        repositoryInstantWindSpringData;

    public ServiceInstantWind
        (IFactoryInstantWind<DomainId, ValueWS> factoryInstantWind,
         @Qualifier("repositoryInstantWindSpringData")
         IRepository<DomainId, ValueWS, AggregateRoot<DomainId, ValueWS>> repositoryInstantWindSpringData) {
        this.factoryInstantWind = factoryInstantWind;
        this.repositoryInstantWindSpringData = repositoryInstantWindSpringData;
    }

    public ValueWS getInstantWind
        (int apiKey, double latitude, double longitude, int hour) throws IOException {
        final AggregateRoot<DomainId, ValueWS> instantWind
            = factoryInstantWind.createInstantWind(apiKey, latitude, longitude, hour);
        repositoryInstantWindSpringData.save(instantWind);
        return instantWind.getValueWS();
    }
}
