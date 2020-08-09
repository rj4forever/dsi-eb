package com.dsi.eb.persistence.config;

import java.util.Properties;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@EnableJpaRepositories(basePackages = {
		"com.dsi.eb" }, entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class PersisteceConfig {

	public PersisteceConfig() {
	}

	/**
	 * The method that configures the datasource bean
	 */

	@Resource
	private Environment env;

	@Bean(destroyMethod = "close")
	DataSource dataSource() {
		HikariConfig dataSourceConfig = new HikariConfig();
		dataSourceConfig.setJdbcUrl(env.getRequiredProperty("spring.datasource.url"));
		dataSourceConfig.setDriverClassName(env.getRequiredProperty("spring.datasource.driverClassName"));
		dataSourceConfig.setUsername(env.getRequiredProperty("spring.datasource.username"));
		dataSourceConfig.setPassword(env.getRequiredProperty("spring.datasource.password"));
		return new HikariDataSource(dataSourceConfig);
	}

	/**
	 * The method that configures the entity manager factory
	 */
	@Bean
	LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource, Environment env) {
		LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
		entityManagerFactoryBean.setDataSource(dataSource);
		entityManagerFactoryBean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		entityManagerFactoryBean.setPackagesToScan("com.dsi.eb");

		Properties jpaProperties = new Properties();

		jpaProperties.put("hibernate.dialect", env.getRequiredProperty("spring.jpa.dialect"));
		jpaProperties.put("hibernate.show_sql", env.getRequiredProperty("spring.jpa.show-sql"));

		entityManagerFactoryBean.setJpaProperties(jpaProperties);

		return entityManagerFactoryBean;
	}

	/**
	 * The method that configures the transaction manager
	 */
	@Bean
	JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}
}