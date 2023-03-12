package com.edu.domain.entityFactory;

import java.util.HashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource({ "classpath:application.properties" })
@EnableTransactionManagement
@EnableJpaRepositories(
    basePackages = { "com.edu.infrastructure.ReportRepository" },
    entityManagerFactoryRef = "reportEntityManager",
    transactionManagerRef = "reportTransactionManager"
)
public class reportConfig {
    @Autowired
    Environment env;


    @Bean
    public LocalContainerEntityManagerFactoryBean reportEntityManager() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(reportDataSource());
        em.setPackagesToScan(new String[] {"com.edu.domain.secondModel"});
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.ddl-auto", env.getProperty("hibernate.ddl-auto"));
        properties.put("database-platform", env.getProperty("database-platform"));
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean
    @ConfigurationProperties(prefix="spring.report")
    public DataSource reportDataSource() {
    	return DataSourceBuilder.create()
	            .driverClassName("org.postgresql.Driver")
	            .url("jdbc:postgresql://localhost:32768/postgres")
	            .build();
    }

    @Bean
    public PlatformTransactionManager reportTransactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(reportEntityManager().getObject());
        return transactionManager;
    }

}
