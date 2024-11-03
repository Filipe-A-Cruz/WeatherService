
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
@Table(name = "InstantWind")
public class InstantWindDataModel {
    @Id
    private int idInstantWindApiKey;
    private double valueWSInstantWindMeasurement;
    private String valueWSInstantWindUnit;
    private String valueWSInstantWindInfo;

    public InstantWindDataModel(AggregateRoot<DomainId, ValueWS> instantWind) {
        this.idInstantWindApiKey = instantWind.getId().apiKey();
        this.valueWSInstantWindMeasurement = instantWind.getValueWS().getMeasurement();
        this.valueWSInstantWindUnit = instantWind.getValueWS().getUnit();
        this.valueWSInstantWindInfo = instantWind.getValueWS().getInfo();
    }

    @Override
    public String toString() {
        return "InstantWindDataModel(" +
            "idInstantWindApiKey=" + idInstantWindApiKey +
            ", valueWSInstantWindMeasurement=" + valueWSInstantWindMeasurement +
            ", valueWSInstantWindUnit=" + valueWSInstantWindUnit +
            ", valueWSInstantWindInfo=" + valueWSInstantWindInfo +
            ')';
    }
}
