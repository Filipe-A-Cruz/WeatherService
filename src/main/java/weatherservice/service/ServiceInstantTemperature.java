
package weatherservice.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import weatherservice.ddd.AggregateRoot;
import weatherservice.ddd.DomainId;
import weatherservice.ddd.IRepository;
import weatherservice.ddd.ValueWS;

import java.io.IOException;

@Service
public class ServiceInstantTemperature {
    private final IFactoryInstantTemperature<DomainId, ValueWS> factoryInstantTemperature;
    private final IRepository<DomainId, ValueWS, AggregateRoot<DomainId, ValueWS>>
        repositoryInstantTemperatureSpringData;


    public ServiceInstantTemperature
        (IFactoryInstantTemperature<DomainId, ValueWS> factoryInstantTemperature,
         @Qualifier("repositoryInstantTemperatureSpringData")
         IRepository<DomainId, ValueWS, AggregateRoot<DomainId, ValueWS>> repositoryInstantTemperatureSpringData) {
        this.factoryInstantTemperature = factoryInstantTemperature;
        this.repositoryInstantTemperatureSpringData = repositoryInstantTemperatureSpringData;
    }

    public ValueWS getInstantTemperature
        (int apiKey, double latitude, double longitude, int hour) throws IOException {
        final AggregateRoot<DomainId, ValueWS> instantTemperature
            = factoryInstantTemperature.createInstantTemperature(apiKey, latitude, longitude, hour);
        repositoryInstantTemperatureSpringData.save(instantTemperature);
        return instantTemperature.getValueWS();
    }
}
