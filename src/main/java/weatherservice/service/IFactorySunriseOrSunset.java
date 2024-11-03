package weatherservice.service;

import weatherservice.ddd.AggregateRoot;
import weatherservice.ddd.DomainId;
import weatherservice.ddd.ValueWS;

import java.io.IOException;

public interface IFactorySunriseOrSunset<I extends DomainId, V extends ValueWS> {
    AggregateRoot<I, V> createSunriseOrSunset
        (int apiKey, double latitude, double longitude, String option) throws IOException;
}
