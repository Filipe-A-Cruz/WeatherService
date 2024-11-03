
package weatherservice.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Functions {
    protected Functions() {
        //Avoid relying on default constructor.
    }

    public static boolean isInvalidGpsCoordinates(double latitude, double longitude) {
        if (latitude < Parameters.LATITUDE_LOWER_BOUNDARY
            || latitude > Parameters.LATITUDE_UPPER_BOUNDARY
            || Double.isNaN(latitude)) {
            return true;
        }
        return longitude < Parameters.LONGITUDE_LOWER_BOUNDARY
            || longitude > Parameters.LONGITUDE_UPPER_BOUNDARY
            || Double.isNaN(longitude);
    }

    public static double[] importSunriseAndSunset() throws IOException {
        final Path path = Paths.get("src/main/java/weatherservice/utils/rawSunriseAndSunset.txt");
        final String[] strings = readTextFile(path);
        return stringToDouble(strings);
    }

    public static double[] importTemperature() throws IOException {
        final Path path = Paths.get("src/main/java/weatherservice/utils/rawTemperature.txt");
        final String[] strings = readTextFile(path);
        return stringToDouble(strings);
    }

    public static String[] importWindDirection() throws IOException {
        //Directions in radians
        //0.00 E
        //0.79 NE
        //1.57 N
        //2.36 NW
        //3.14 W
        //3.93 SW
        //4.71 S
        //5.50 SE
        final Path path = Paths.get("src/main/java/weatherservice/utils/rawWindDirection.txt");
        return readTextFile(path);
    }

    public static double[] importWindSpeed() throws IOException {
        final Path path = Paths.get("src/main/java/weatherservice/utils/rawWindSpeed.txt");
        final String[] strings = readTextFile(path);
        return stringToDouble(strings);
    }

    private static String[] readTextFile(Path path) throws IOException {
        final List<String> listOfStrings = Files.readAllLines(path);
        return listOfStrings.toArray(new String[Parameters.ZERO]);
    }

    private static double[] stringToDouble(String[] strings) {
        return Arrays.stream(strings).mapToDouble(Double::parseDouble).toArray();
    }

    @Override
    public String toString() {
        return "Functions()";
    }
}
