
package weatherservice.mapper;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.hateoas.RepresentationModel;

@Getter
public final class ValueWSDto extends RepresentationModel<ValueWSDto> {
    private final double measurement;
    private final String unit;
    private final String info;

    @JsonCreator
    public ValueWSDto(@JsonProperty("measurement") double measurement,
                      @JsonProperty("unit") String unit,
                      @JsonProperty("info") String info) {
        this.measurement = measurement;
        this.unit = unit;
        this.info = info;
    }

    @NonNull
    @Override
    public String toString() {
        return "ValueWSDto(" +
            "measurement=" + measurement +
            ", unit=" + unit +
            ", info=" + info +
            ')';
    }
}
