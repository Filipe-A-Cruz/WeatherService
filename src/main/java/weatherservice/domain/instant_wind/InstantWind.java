
package weatherservice.domain.instant_wind;

import weatherservice.ddd.AggregateRoot;
import weatherservice.ddd.DomainId;
import weatherservice.ddd.ValueWS;
import weatherservice.utils.Functions;

import java.io.IOException;

public final class InstantWind
    implements AggregateRoot<DomainId, ValueWS> {
    private final DomainId idInstantWind;
    private final ValueWS valueWSInstantWind;

    public InstantWind(int apiKey, double latitude, double longitude, int hour)
        throws IOException {
        if (Functions.isInvalidGpsCoordinates(latitude, longitude)) {
            throw new IllegalArgumentException("Invalid arguments passed to constructor.");
        }
        this.idInstantWind = new IdInstantWind(apiKey);
        this.valueWSInstantWind = new ValueWSInstantWind(hour);
    }

    @Override
    public DomainId getId() {
        return idInstantWind;
    }

    @Override
    public ValueWS getValueWS() {
        return valueWSInstantWind;
    }

    @Override
    public String toString() {
        return "InstantWind(" +
            "idInstantWind=" + idInstantWind +
            ", valueWSInstantWind=" + valueWSInstantWind +
            ')';
    }
}
