
package weatherservice.service;

import weatherservice.ddd.AggregateRoot;
import weatherservice.ddd.DomainId;
import weatherservice.ddd.ValueWS;

import java.io.IOException;

public interface IFactoryInstantTemperature<I extends DomainId, V extends ValueWS> {
    AggregateRoot<I, V> createInstantTemperature
        (int apiKey, double latitude, double longitude, int hour) throws IOException;
}
