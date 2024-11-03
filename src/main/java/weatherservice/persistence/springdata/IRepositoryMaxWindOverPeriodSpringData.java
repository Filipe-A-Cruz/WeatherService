
package weatherservice.persistence.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import weatherservice.persistence.datamodel.MaxWindOverPeriodDataModel;

public interface IRepositoryMaxWindOverPeriodSpringData
    extends JpaRepository<MaxWindOverPeriodDataModel, Integer> {
}
