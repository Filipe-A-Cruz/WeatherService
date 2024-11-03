
package weatherservice.utils;

public class Parameters {
    public static final int ZERO = 0;
    public static final int ONE = 1;
    public static final double ZERO_DOUBLE_ONE_DECIMAL_PLACE = 0.0;
    public static final String NULL = "null";
    public static final int API_KEY_LOWER_BOUNDARY = 1;
    public static final int API_KEY_UPPER_BOUNDARY = 75;
    public static final double LATITUDE_LOWER_BOUNDARY = -90.00;
    public static final double LATITUDE_UPPER_BOUNDARY = 90.00;
    public static final double LONGITUDE_LOWER_BOUNDARY = -180.00;
    public static final double LONGITUDE_UPPER_BOUNDARY = 180.00;
    public static final int HOUR_LOWER_BOUNDARY = 0;
    public static final int HOUR_UPPER_BOUNDARY = 23;
    public static final String TEMPERATURE_UNIT = "C";
    public static final String TEMPERATURE_INFO = "dry bulb";
    public static final String WIND_SPEED_UNIT = "km/h";
    public static final int INVERSE_WIND_SPEED_PRECISION = 100;
    public static final String SUNRISE = "sunrise";
    public static final String SUNSET = "sunset";
    public static final String DAWN = "dawn";
    public static final String DUSK = "dusk";
    public static final String SUNRISE_OR_SUNSET_TIME_UNIT = "h";
    public static final double ASSERT_EQUALS_DOUBLES_TOLERANCE = 0.01;
    public static final String PERSISTENCE_UNIT_NAME = "weatherservice";
    public static final String EMPTY_STRING = "";
    public static final String INVALID_ARGUMENTS = "Invalid arguments.";
    public static final int HTTP_STATUS_CODE_400 = 400;

    protected Parameters() {
        //Avoid relying on default constructor.
    }

    @Override
    public String toString() {
        return "Parameters()";
    }
}
