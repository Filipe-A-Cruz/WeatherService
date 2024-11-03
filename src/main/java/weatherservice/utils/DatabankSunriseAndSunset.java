
package weatherservice.utils;

import java.io.IOException;

public final class DatabankSunriseAndSunset {
    private final double[] sunriseAndSunsetTable;

    public DatabankSunriseAndSunset() throws IOException {
        this.sunriseAndSunsetTable = tableBuilder();
    }

    private static double[] tableBuilder() throws IOException {
        return Functions.importSunriseAndSunset();
    }

    public double getSunriseOrSunsetData(String option) {
        if (option.equals(Parameters.SUNRISE)) {
            return sunriseAndSunsetTable[Parameters.ZERO];
        }
        return sunriseAndSunsetTable[Parameters.ONE];
    }
}
