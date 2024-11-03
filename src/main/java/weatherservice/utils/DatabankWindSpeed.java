
package weatherservice.utils;

import java.io.IOException;

public final class DatabankWindSpeed {
    private final double[] windSpeedTable;

    public DatabankWindSpeed() throws IOException {
        this.windSpeedTable = tableBuilder();
    }

    private static double[] tableBuilder() throws IOException {
        return Functions.importWindSpeed();
    }

    public double getWindSpeedData(int hour) {
        return windSpeedTable[hour];
    }
}
