
package weatherservice.persistence.springdata;

import org.springframework.stereotype.Repository;
import weatherservice.ddd.AggregateRoot;
import weatherservice.ddd.DomainId;
import weatherservice.ddd.IRepository;
import weatherservice.ddd.ValueWS;
import weatherservice.persistence.datamodel.MaxWindOverPeriodDataModel;

@Repository("maxWindOverPeriodSpringData")
public class RepositoryMaxWindOverPeriodSpringData
    implements IRepository<DomainId, ValueWS, AggregateRoot<DomainId, ValueWS>> {
    private final IRepositoryMaxWindOverPeriodSpringData repositoryMaxWindOverPeriodSpringData;

    public RepositoryMaxWindOverPeriodSpringData
        (IRepositoryMaxWindOverPeriodSpringData repositoryMaxWindOverPeriodSpringData) {
        this.repositoryMaxWindOverPeriodSpringData = repositoryMaxWindOverPeriodSpringData;
    }

    @Override
    public boolean save(AggregateRoot<DomainId, ValueWS> maxWindOverPeriod) {
        final MaxWindOverPeriodDataModel maxWindOverPeriodDataModel
            = new MaxWindOverPeriodDataModel(maxWindOverPeriod);
        repositoryMaxWindOverPeriodSpringData.save(maxWindOverPeriodDataModel);
        return true;
    }
}
