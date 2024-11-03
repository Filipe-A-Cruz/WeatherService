
package weatherservice.utils;

import java.io.IOException;

public final class DatabankWindDirection {
    private final String[] windDirectionTable;

    public DatabankWindDirection() throws IOException {
        this.windDirectionTable = tableBuilder();
    }

    private static String[] tableBuilder() throws IOException {
        return Functions.importWindDirection();
    }

    public String getWindDirectionData(int hour) {
        return windDirectionTable[hour];
    }
}
