
package weatherservice.domain.sunrise_or_sunset;

import weatherservice.ddd.AggregateRoot;
import weatherservice.ddd.DomainId;
import weatherservice.ddd.ValueWS;
import weatherservice.utils.Functions;

import java.io.IOException;

public final class SunriseOrSunset
    implements AggregateRoot<DomainId, ValueWS> {
    private final DomainId idSunriseOrSunset;
    private final ValueWS valueWSSunriseOrSunset;

    public SunriseOrSunset(int apiKey, double latitude, double longitude, String option)
        throws IOException {
        if (Functions.isInvalidGpsCoordinates(latitude, longitude)) {
            throw new IllegalArgumentException("Invalid arguments passed to constructor.");
        }
        this.idSunriseOrSunset = new IdSunriseOrSunset(apiKey);
        this.valueWSSunriseOrSunset = new ValueWSSunriseOrSunset(option);
    }

    @Override
    public DomainId getId() {
        return idSunriseOrSunset;
    }

    @Override
    public ValueWS getValueWS() {
        return valueWSSunriseOrSunset;
    }

    @Override
    public String toString() {
        return "SunriseOrSunset(" +
            "idSunriseOrSunset=" + idSunriseOrSunset +
            ", valueWSSunriseOrSunset=" + valueWSSunriseOrSunset +
            ')';
    }
}
