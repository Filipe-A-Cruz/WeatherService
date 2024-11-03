
package weatherservice.persistence.datamodel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;
import weatherservice.ddd.AggregateRoot;
import weatherservice.ddd.DomainId;
import weatherservice.ddd.ValueWS;

@NoArgsConstructor
@Entity
@Table(name = "SunriseOrSunset")
public class SunriseOrSunsetDataModel {
    @Id
    private int idSunriseOrSunsetApiKey;
    private double valueWSSunriseOrSunsetMeasurement;
    private String valueWSSunriseOrSunsetUnit;
    private String valueWSSunriseOrSunsetInfo;

    public SunriseOrSunsetDataModel(AggregateRoot<DomainId, ValueWS> sunriseOrSunset) {
        this.idSunriseOrSunsetApiKey = sunriseOrSunset.getId().apiKey();
        this.valueWSSunriseOrSunsetMeasurement = sunriseOrSunset.getValueWS().getMeasurement();
        this.valueWSSunriseOrSunsetUnit = sunriseOrSunset.getValueWS().getUnit();
        this.valueWSSunriseOrSunsetInfo = sunriseOrSunset.getValueWS().getInfo();
    }

    @Override
    public String toString() {
        return "SunriseOrSunsetDataModel(" +
            "idSunriseOrSunsetApiKey=" + idSunriseOrSunsetApiKey +
            ", valueWSSunriseOrSunsetMeasurement=" + valueWSSunriseOrSunsetMeasurement +
            ", valueWSSunriseOrSunsetUnit=" + valueWSSunriseOrSunsetUnit +
            ", valueWSSunriseOrSunsetInfo=" + valueWSSunriseOrSunsetInfo +
            ')';
    }
}
