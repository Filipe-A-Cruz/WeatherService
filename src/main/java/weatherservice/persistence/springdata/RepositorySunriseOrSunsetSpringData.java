
package weatherservice.persistence.springdata;

import org.springframework.stereotype.Repository;
import weatherservice.ddd.AggregateRoot;
import weatherservice.ddd.DomainId;
import weatherservice.ddd.IRepository;
import weatherservice.ddd.ValueWS;
import weatherservice.persistence.datamodel.SunriseOrSunsetDataModel;

@Repository("sunriseOrSunsetSpringData")
public class RepositorySunriseOrSunsetSpringData
    implements IRepository<DomainId, ValueWS, AggregateRoot<DomainId, ValueWS>> {
    private final IRepositorySunriseOrSunsetSpringData repositorySunriseOrSunsetSpringData;

    public RepositorySunriseOrSunsetSpringData
        (IRepositorySunriseOrSunsetSpringData repositorySunriseOrSunsetSpringData) {
        this.repositorySunriseOrSunsetSpringData = repositorySunriseOrSunsetSpringData;
    }

    @Override
    public boolean save(AggregateRoot<DomainId, ValueWS> sunriseOrSunset) {
        final SunriseOrSunsetDataModel sunriseOrSunsetDataModel
            = new SunriseOrSunsetDataModel(sunriseOrSunset);
        repositorySunriseOrSunsetSpringData.save(sunriseOrSunsetDataModel);
        return true;
    }
}
