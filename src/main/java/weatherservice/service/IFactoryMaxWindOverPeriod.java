package weatherservice.service;

import weatherservice.ddd.AggregateRoot;
import weatherservice.ddd.DomainId;
import weatherservice.ddd.ValueWS;

import java.io.IOException;

public interface IFactoryMaxWindOverPeriod<I extends DomainId, V extends ValueWS> {
    AggregateRoot<I, V> createMaxWindOverPeriod
        (int apiKey, double latitude, double longitude, int hourStart, int hourEnd) throws IOException;
}
