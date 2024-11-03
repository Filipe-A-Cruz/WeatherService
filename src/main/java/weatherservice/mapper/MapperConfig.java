
package weatherservice.mapper;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("weatherservice.mapper")
public class MapperConfig {
    @Override
    public String toString() {
        return "MapperConfig()";
    }
}
