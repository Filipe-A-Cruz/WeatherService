
package weatherservice.domain.max_wind_over_period;

import lombok.Getter;
import weatherservice.ddd.ValueWS;
import weatherservice.utils.DatabankWindDirection;
import weatherservice.utils.DatabankWindSpeed;
import weatherservice.utils.Parameters;

import java.io.IOException;

@Getter
public final class ValueWSMaxWindOverPeriod implements ValueWS {
    private final double measurement;
    private final String unit;
    private final String info;

    public ValueWSMaxWindOverPeriod
        (int hourStart, int hourEnd) throws IOException {
        if (isInvalidArguments(hourStart, hourEnd)) {
            throw new IllegalArgumentException("Invalid arguments passed to constructor.");
        }
        final DatabankWindSpeed databankWindSpeed = new DatabankWindSpeed();
        this.measurement = measurementLookup(databankWindSpeed, hourStart, hourEnd);
        this.unit = Parameters.WIND_SPEED_UNIT;
        final DatabankWindDirection databankWindDirection = new DatabankWindDirection();
        this.info = infoLookup(databankWindSpeed, databankWindDirection, hourStart, hourEnd, measurement);
    }

    private static boolean isInvalidArguments(int hourStart, int hourEnd) {
        if (hourStart < Parameters.HOUR_LOWER_BOUNDARY || hourStart > Parameters.HOUR_UPPER_BOUNDARY) {
            return true;
        }
        if (hourEnd < Parameters.HOUR_LOWER_BOUNDARY || hourEnd > Parameters.HOUR_UPPER_BOUNDARY) {
            return true;
        }
        return hourStart > hourEnd;
    }

    private static double measurementLookup(DatabankWindSpeed databankWindSpeed, int hourStart, int hourEnd) {
        double maxWindSpeed = 0.00;
        for (int i = hourStart; i <= hourEnd; i++) {
            maxWindSpeed = Math.max(maxWindSpeed, databankWindSpeed.getWindSpeedData(i));
        }
        return maxWindSpeed;
    }

    private static String infoLookup(DatabankWindSpeed databankWindSpeed, DatabankWindDirection databankWindDirection,
                                     int hourStart, int hourEnd, double maxMeasurement) {
        final StringBuilder maxWindSpeedDirections = new StringBuilder();
        for (int i = hourStart; i <= hourEnd; i++) {
            if (Math.abs(Math.round(databankWindSpeed.getWindSpeedData(i)
                * Parameters.INVERSE_WIND_SPEED_PRECISION)
                - Math.round(maxMeasurement
                * Parameters.INVERSE_WIND_SPEED_PRECISION)) < Parameters.ONE) {
                maxWindSpeedDirections.append(databankWindDirection.getWindDirectionData(i)).append(' ');
            }
        }
        return maxWindSpeedDirections.substring(Parameters.ZERO, maxWindSpeedDirections.length() - Parameters.ONE);
    }

    @Override
    public String toString() {
        return "ValueWSMaxWindOverPeriod(" +
            "measurement=" + measurement +
            ", unit=" + unit +
            ", info=" + info +
            ')';
    }
}
