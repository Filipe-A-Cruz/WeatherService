
package weatherservice.domain.sunrise_or_sunset;

import lombok.Getter;
import weatherservice.ddd.ValueWS;
import weatherservice.utils.DatabankSunriseAndSunset;
import weatherservice.utils.Parameters;

import java.io.IOException;

@Getter
public final class ValueWSSunriseOrSunset implements ValueWS {
    private final double measurement;
    private final String unit;
    private final String info;

    public ValueWSSunriseOrSunset(String option) throws IOException {
        if (isInvalidArguments(option)) {
            throw new IllegalArgumentException("Invalid arguments passed to constructor.");
        }
        final DatabankSunriseAndSunset databankSunriseAndSunset = new DatabankSunriseAndSunset();
        this.measurement = measurementLookup(databankSunriseAndSunset, option);
        this.unit = Parameters.SUNRISE_OR_SUNSET_TIME_UNIT;
        this.info = option;
    }

    private static boolean isInvalidArguments(String option) {
        return option == null || !(option.equals(Parameters.SUNRISE)
            || option.equals(Parameters.SUNSET));
    }

    private static double measurementLookup(DatabankSunriseAndSunset databankSunriseAndSunset, String option) {
        return databankSunriseAndSunset.getSunriseOrSunsetData(option);
    }

    @Override
    public String toString() {
        return "ValueWSSunriseOrSunset(" +
            "measurement=" + measurement +
            ", unit=" + unit +
            ", info=" + info +
            ')';
    }
}
