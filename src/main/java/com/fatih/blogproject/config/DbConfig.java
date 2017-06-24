package com.fatih.blogproject.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = { "com.fatih.blogproject.repository" })
@EnableTransactionManagement
public class DbConfig {

	@Autowired
	private Environment environment;

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(environment.getProperty("jdbc.driverClassName"));
		dataSource.setUrl(environment.getProperty("jdbc.url"));
		dataSource.setUsername(environment.getProperty("jdbc.username"));
		dataSource.setPassword(environment.getProperty("jdbc.password"));
		
		

		return dataSource;
	}

	private DatabasePopulator databasePopulator(){
		ResourceDatabasePopulator databasePopulator=new ResourceDatabasePopulator();
		databasePopulator.setContinueOnError(true);
		//databasePopulator.addScript(new ClassPathResource("dbschema.sql"));
		databasePopulator.addScript(new ClassPathResource("test-data.sql"));
		return databasePopulator;
	}
	
	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		
		DatabasePopulatorUtils.execute(databasePopulator(), dataSource());
		return transactionManager;
	}

	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();

		jpaVendorAdapter.setDatabase(Database.MYSQL);
		jpaVendorAdapter.setShowSql(true);

		return jpaVendorAdapter;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean entityManagerFactory = new LocalContainerEntityManagerFactoryBean();

		entityManagerFactory.setDataSource(dataSource());

		entityManagerFactory.setJpaVendorAdapter(jpaVendorAdapter());
		
		entityManagerFactory.setPackagesToScan("com.fatih.blogproject");
		

		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		jpaProperties.setProperty("hibernate.connection.characterEncoding","utf8");
		
		

		entityManagerFactory.setJpaProperties(jpaProperties);

		return entityManagerFactory;
	}

}
