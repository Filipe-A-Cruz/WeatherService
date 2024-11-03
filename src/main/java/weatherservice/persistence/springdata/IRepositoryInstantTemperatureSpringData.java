
package weatherservice.persistence.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import weatherservice.persistence.datamodel.InstantTemperatureDataModel;

public interface IRepositoryInstantTemperatureSpringData
    extends JpaRepository<InstantTemperatureDataModel, Integer> {
}
