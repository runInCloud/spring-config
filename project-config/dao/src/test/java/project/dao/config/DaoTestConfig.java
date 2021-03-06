package project.dao.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import project.dao.Model;

import static project.dao.config.Placeholders.JDBC_URL;

/**
 * Created by dimon on 18.08.14.
 */
@Configuration
@Import(DaoConfig.class)
@PropertySource("classpath:dao-default.properties")
@PropertySource("classpath:dao-test.properties")
public class DaoTestConfig {

    @Value(JDBC_URL)
    private String url;

    @Bean
    public Model model() {
        return new Model(url);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setLocalOverride(true);
        return configurer;
    }

}
