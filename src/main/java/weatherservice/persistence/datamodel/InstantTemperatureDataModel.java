
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
@Table(name = "InstantTemperature")
public class InstantTemperatureDataModel {
    @Id
    private int idInstantTemperatureApiKey;
    private double valueWSInstantTemperatureMeasurement;
    private String valueWSInstantTemperatureUnit;
    private String valueWSInstantTemperatureInfo;

    public InstantTemperatureDataModel(AggregateRoot<DomainId, ValueWS> instantTemperature) {
        this.idInstantTemperatureApiKey = instantTemperature.getId().apiKey();
        this.valueWSInstantTemperatureMeasurement = instantTemperature.getValueWS().getMeasurement();
        this.valueWSInstantTemperatureUnit = instantTemperature.getValueWS().getUnit();
        this.valueWSInstantTemperatureInfo = instantTemperature.getValueWS().getInfo();
    }

    @Override
    public String toString() {
        return "InstantTemperatureDataModel(" +
            "idInstantTemperatureApiKey=" + idInstantTemperatureApiKey +
            ", valueWSInstantTemperatureMeasurement=" + valueWSInstantTemperatureMeasurement +
            ", valueWSInstantTemperatureUnit=" + valueWSInstantTemperatureUnit +
            ", valueWSInstantTemperatureInfo=" + valueWSInstantTemperatureInfo +
            ')';
    }
}
