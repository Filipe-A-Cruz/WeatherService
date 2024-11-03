
package weatherservice.persistence.springdata;

import org.springframework.stereotype.Repository;
import weatherservice.ddd.AggregateRoot;
import weatherservice.ddd.DomainId;
import weatherservice.ddd.IRepository;
import weatherservice.ddd.ValueWS;
import weatherservice.persistence.datamodel.InstantTemperatureDataModel;

@Repository("repositoryInstantTemperatureSpringData")
public class RepositoryInstantTemperatureSpringData
    implements IRepository<DomainId, ValueWS, AggregateRoot<DomainId, ValueWS>> {
    private final IRepositoryInstantTemperatureSpringData repositoryInstantTemperatureSpringData;

    public RepositoryInstantTemperatureSpringData
        (IRepositoryInstantTemperatureSpringData repositoryInstantTemperatureSpringData) {
        this.repositoryInstantTemperatureSpringData = repositoryInstantTemperatureSpringData;
    }

    @Override
    public boolean save(AggregateRoot<DomainId, ValueWS> instantTemperature) {
        final InstantTemperatureDataModel instantTemperatureDataModel
            = new InstantTemperatureDataModel(instantTemperature);
        repositoryInstantTemperatureSpringData.save(instantTemperatureDataModel);
        return true;
    }
}
