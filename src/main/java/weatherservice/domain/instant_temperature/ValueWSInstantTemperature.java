
package weatherservice.domain.instant_temperature;

import lombok.Getter;
import weatherservice.ddd.ValueWS;
import weatherservice.utils.DatabankTemperature;
import weatherservice.utils.Parameters;

import java.io.IOException;

@Getter
public final class ValueWSInstantTemperature implements ValueWS {
    private final double measurement;
    private final String unit;
    private final String info;

    public ValueWSInstantTemperature(int hour) throws IOException {
        if (isInvalidArguments(hour)) {
            throw new IllegalArgumentException("Invalid arguments passed to constructor.");
        }
        final DatabankTemperature databankTemperature = new DatabankTemperature();
        this.measurement = measurementLookup(databankTemperature, hour);
        this.unit = Parameters.TEMPERATURE_UNIT;
        this.info = Parameters.TEMPERATURE_INFO;
    }

    private static boolean isInvalidArguments(int hour) {
        return hour < Parameters.HOUR_LOWER_BOUNDARY || hour > Parameters.HOUR_UPPER_BOUNDARY;
    }

    private static double measurementLookup(DatabankTemperature databankTemperature, int hour) {
        return databankTemperature.getTemperatureData(hour);
    }

    @Override
    public String toString() {
        return "ValueWSInstantTemperature(" +
            "measurement=" + measurement +
            ", unit=" + unit +
            ", info=" + info +
            ')';
    }
}
