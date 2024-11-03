
package weatherservice.domain.sunrise_or_sunset;

import weatherservice.ddd.DomainId;
import weatherservice.utils.Parameters;

public record IdSunriseOrSunset(int apiKey) implements DomainId {
    public IdSunriseOrSunset {
        if (isInvalidArguments(apiKey)) {
            throw new IllegalArgumentException("Invalid arguments passed to constructor.");
        }
    }

    private static boolean isInvalidArguments(int apiKey) {
        return apiKey < Parameters.API_KEY_LOWER_BOUNDARY
            || apiKey > Parameters.API_KEY_UPPER_BOUNDARY;
    }
}
