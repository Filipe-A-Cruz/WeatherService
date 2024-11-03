
package weatherservice.domain.instant_temperature;

import weatherservice.ddd.AggregateRoot;
import weatherservice.ddd.DomainId;
import weatherservice.ddd.ValueWS;
import weatherservice.utils.Functions;

import java.io.IOException;

public final class InstantTemperature implements AggregateRoot<DomainId, ValueWS> {
    private final DomainId idInstantTemperature;
    private final ValueWS valueWSInstantTemperature;

    public InstantTemperature(int apiKey, double latitude, double longitude, int hour)
        throws IOException {
        if (Functions.isInvalidGpsCoordinates(latitude, longitude)) {
            throw new IllegalArgumentException("Invalid arguments passed to constructor.");
        }
        this.idInstantTemperature = new IdInstantTemperature(apiKey);
        this.valueWSInstantTemperature = new ValueWSInstantTemperature(hour);
    }

    @Override
    public DomainId getId() {
        return idInstantTemperature;
    }

    @Override
    public ValueWS getValueWS() {
        return valueWSInstantTemperature;
    }

    @Override
    public String toString() {
        return "InstantTemperature(" +
            "idInstantTemperature=" + idInstantTemperature +
            ", valueWSInstantTemperature=" + valueWSInstantTemperature +
            ')';
    }
}
