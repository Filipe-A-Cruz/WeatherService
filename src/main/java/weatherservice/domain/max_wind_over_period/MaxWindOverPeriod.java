
package weatherservice.domain.max_wind_over_period;

import weatherservice.ddd.AggregateRoot;
import weatherservice.ddd.DomainId;
import weatherservice.ddd.ValueWS;
import weatherservice.utils.Functions;

import java.io.IOException;

public final class MaxWindOverPeriod
    implements AggregateRoot<DomainId, ValueWS> {
    private final DomainId idMaxWindOverPeriod;
    private final ValueWS valueWSMaxWindOverPeriod;

    public MaxWindOverPeriod(int apiKey, double latitude, double longitude, int hourStart, int hourEnd)
        throws IOException {
        if (Functions.isInvalidGpsCoordinates(latitude, longitude)) {
            throw new IllegalArgumentException("Invalid arguments passed to constructor.");
        }
        this.idMaxWindOverPeriod = new IdMaxWindOverPeriod(apiKey);
        this.valueWSMaxWindOverPeriod = new ValueWSMaxWindOverPeriod(hourStart, hourEnd);
    }

    @Override
    public DomainId getId() {
        return idMaxWindOverPeriod;
    }

    @Override
    public ValueWS getValueWS() {
        return valueWSMaxWindOverPeriod;
    }

    @Override
    public String toString() {
        return "MaxWindOverPeriod(" +
            "idMaxWindOverPeriod=" + idMaxWindOverPeriod +
            ", valueWSMaxWindOverPeriod=" + valueWSMaxWindOverPeriod +
            ')';
    }
}
