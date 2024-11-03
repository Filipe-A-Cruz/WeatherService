
package weatherservice.persistence.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import weatherservice.persistence.datamodel.InstantWindDataModel;

public interface IRepositoryInstantWindSpringData
    extends JpaRepository<InstantWindDataModel, Integer> {
}
