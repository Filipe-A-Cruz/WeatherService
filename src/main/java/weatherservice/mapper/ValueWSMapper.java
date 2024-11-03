
package weatherservice.mapper;

import org.springframework.stereotype.Component;
import weatherservice.ddd.ValueWS;

@Component
public class ValueWSMapper {
    public ValueWSDto valueWSToDto(ValueWS valueWS) {
        final double measurement = valueWS.getMeasurement();
        final String unit = valueWS.getUnit();
        final String info = valueWS.getInfo();
        return new ValueWSDto(measurement, unit, info);
    }
}
