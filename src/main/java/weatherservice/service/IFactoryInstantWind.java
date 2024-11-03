package weatherservice.service;

import weatherservice.ddd.AggregateRoot;
import weatherservice.ddd.DomainId;
import weatherservice.ddd.ValueWS;

import java.io.IOException;

public interface IFactoryInstantWind<I extends DomainId, V extends ValueWS> {
    AggregateRoot<I, V> createInstantWind
        (int apiKey, double latitude, double longitude, int hour) throws IOException;
}
