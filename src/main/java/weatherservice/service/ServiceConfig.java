
package weatherservice.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("weatherservice.service")
public class ServiceConfig {
    @Override
    public String toString() {
        return "ServiceConfig()";
    }
}
