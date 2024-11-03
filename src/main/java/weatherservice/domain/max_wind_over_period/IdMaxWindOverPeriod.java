
package weatherservice.domain.max_wind_over_period;

import weatherservice.ddd.DomainId;
import weatherservice.utils.Parameters;

public record IdMaxWindOverPeriod(int apiKey) implements DomainId {
    public IdMaxWindOverPeriod {
        if (isInvalidArguments(apiKey)) {
            throw new IllegalArgumentException("Invalid arguments passed to constructor.");
        }
    }

    private static boolean isInvalidArguments(int apiKey) {
        return apiKey < Parameters.API_KEY_LOWER_BOUNDARY
            || apiKey > Parameters.API_KEY_UPPER_BOUNDARY;
    }
}
