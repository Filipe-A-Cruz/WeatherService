
package weatherservice.persistence.springdata;

import org.springframework.data.jpa.repository.JpaRepository;
import weatherservice.persistence.datamodel.SunriseOrSunsetDataModel;

public interface IRepositorySunriseOrSunsetSpringData
    extends JpaRepository<SunriseOrSunsetDataModel, Integer> {
}
