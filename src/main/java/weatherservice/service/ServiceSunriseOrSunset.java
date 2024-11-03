
package weatherservice.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import weatherservice.ddd.AggregateRoot;
import weatherservice.ddd.DomainId;
import weatherservice.ddd.IRepository;
import weatherservice.ddd.ValueWS;

import java.io.IOException;

@Service
public class ServiceSunriseOrSunset {
    private final IFactorySunriseOrSunset<DomainId, ValueWS> factorySunriseOrSunset;
    private final IRepository<DomainId, ValueWS, AggregateRoot<DomainId, ValueWS>>
        repositorySunriseOrSunsetSpringData;

    public ServiceSunriseOrSunset
        (IFactorySunriseOrSunset<DomainId, ValueWS> factorySunriseOrSunset,
         @Qualifier("sunriseOrSunsetSpringData")
         IRepository<DomainId, ValueWS, AggregateRoot<DomainId, ValueWS>> repositorySunriseOrSunsetSpringData) {
        this.factorySunriseOrSunset = factorySunriseOrSunset;
        this.repositorySunriseOrSunsetSpringData = repositorySunriseOrSunsetSpringData;
    }

    public ValueWS getSunriseOrSunset
        (int apiKey, double latitude, double longitude, String option) throws IOException {
        final AggregateRoot<DomainId, ValueWS> sunriseOrSunset
            = factorySunriseOrSunset.createSunriseOrSunset(apiKey, latitude, longitude, option);
        repositorySunriseOrSunsetSpringData.save(sunriseOrSunset);
        return sunriseOrSunset.getValueWS();
    }
}
