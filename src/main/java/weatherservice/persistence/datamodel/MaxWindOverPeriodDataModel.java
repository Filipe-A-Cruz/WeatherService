
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
@Table(name = "MaxWindOverPeriod")
public class MaxWindOverPeriodDataModel {
    @Id
    private int idMaxWindOverPeriodApiKey;
    private double valueWSMaxWindOverPeriodMeasurement;
    private String valueWSMaxWindOverPeriodUnit;
    private String valueWSMaxWindOverPeriodInfo;

    public MaxWindOverPeriodDataModel(AggregateRoot<DomainId, ValueWS> maxWindOverPeriod) {
        this.idMaxWindOverPeriodApiKey = maxWindOverPeriod.getId().apiKey();
        this.valueWSMaxWindOverPeriodMeasurement = maxWindOverPeriod.getValueWS().getMeasurement();
        this.valueWSMaxWindOverPeriodUnit = maxWindOverPeriod.getValueWS().getUnit();
        this.valueWSMaxWindOverPeriodInfo = maxWindOverPeriod.getValueWS().getInfo();
    }

    @Override
    public String toString() {
        return "MaxWIndOverPeriodDataModel(" +
            "idMaxWIndOverPeriodApiKey=" + idMaxWindOverPeriodApiKey +
            ", valueWSMaxWIndOverPeriodMeasurement=" + valueWSMaxWindOverPeriodMeasurement +
            ", valueWSMaxWIndOverPeriodUnit=" + valueWSMaxWindOverPeriodUnit +
            ", valueWSMaxWIndOverPeriodInfo=" + valueWSMaxWindOverPeriodInfo +
            ')';
    }
}
