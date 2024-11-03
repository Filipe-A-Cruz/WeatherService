
package weatherservice.persistence.springdata;

import org.springframework.stereotype.Repository;
import weatherservice.ddd.AggregateRoot;
import weatherservice.ddd.DomainId;
import weatherservice.ddd.IRepository;
import weatherservice.ddd.ValueWS;
import weatherservice.persistence.datamodel.InstantWindDataModel;

@Repository("repositoryInstantWindSpringData")
public class RepositoryInstantWindSpringData
    implements IRepository<DomainId, ValueWS, AggregateRoot<DomainId, ValueWS>> {
    private final IRepositoryInstantWindSpringData repositoryInstantWindSpringData;

    public RepositoryInstantWindSpringData
        (IRepositoryInstantWindSpringData repositoryInstantWindSpringData) {
        this.repositoryInstantWindSpringData = repositoryInstantWindSpringData;
    }

    @Override
    public boolean save(AggregateRoot<DomainId, ValueWS> instantWind) {
        final InstantWindDataModel instantWindDataModel
            = new InstantWindDataModel(instantWind);
        repositoryInstantWindSpringData.save(instantWindDataModel);
        return true;
    }
}
