
package weatherservice.domain.instant_wind;

import lombok.Getter;
import weatherservice.ddd.ValueWS;
import weatherservice.utils.DatabankWindDirection;
import weatherservice.utils.DatabankWindSpeed;
import weatherservice.utils.Parameters;

import java.io.IOException;

@Getter
public final class ValueWSInstantWind implements ValueWS {
    private final double measurement;
    private final String unit;
    private final String info;

    public ValueWSInstantWind(int hour) throws IOException {
        if (isInvalidArguments(hour)) {
            throw new IllegalArgumentException("Invalid arguments passed to constructor.");
        }
        final DatabankWindSpeed databankWindSpeed = new DatabankWindSpeed();
        this.measurement = measurementLookup(databankWindSpeed, hour);
        this.unit = Parameters.WIND_SPEED_UNIT;
        final DatabankWindDirection databankWindDirection = new DatabankWindDirection();
        this.info = infoLookup(databankWindDirection, hour);
    }

    private static boolean isInvalidArguments(int hour) {
        return hour < Parameters.HOUR_LOWER_BOUNDARY || hour > Parameters.HOUR_UPPER_BOUNDARY;
    }

    private static double measurementLookup(DatabankWindSpeed databankWindSpeed, int hour) {
        return databankWindSpeed.getWindSpeedData(hour);
    }

    private static String infoLookup(DatabankWindDirection databankWindDirection, int hour) {
        return databankWindDirection.getWindDirectionData(hour);
    }

    @Override
    public String toString() {
        return "ValueWSInstantWind(" +
            "measurement=" + measurement +
            ", unit=" + unit +
            ", info=" + info +
            ')';
    }
}
