
package weatherservice.utils;

import java.io.IOException;

public final class DatabankTemperature {
    private final double[] temperatureTable;

    public DatabankTemperature() throws IOException {
        this.temperatureTable = tableBuilder();
    }

    private static double[] tableBuilder() throws IOException {
        return Functions.importTemperature();
    }

    public double getTemperatureData(int hour) {
        return temperatureTable[hour];
    }
}
