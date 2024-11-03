
package weatherservice.persistence.springdata;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import jakarta.persistence.EntityManagerFactory;
import weatherservice.utils.Parameters;

@Configuration
@EnableJpaRepositories(basePackages = "weatherservice.persistence.springdata")
@ComponentScan("weatherservice.persistence.springdata")
public class SpringDataConfig {
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        final LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setPersistenceXmlLocation("classpath:META-INF/persistence.xml");
        emf.setPersistenceUnitName(Parameters.PERSISTENCE_UNIT_NAME);
        emf.setPackagesToScan("weatherservice.persistence.jpa.datamodel");
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return emf;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(entityManagerFactory);
        return transactionManager;
    }

    @Override
    public String toString() {
        return "SpringDataConfig()";
    }
}
