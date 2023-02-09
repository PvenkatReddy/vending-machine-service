package com.learning.vending.dbconfiguration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JdbcConfiguration {

	@Value("${db.driver}")
	private String DRIVER;

	@Value("${db.password}")
	private String PASSWORD;

	@Value("${db.url}")
	private String URL;

	@Value("${db.username}")
	private String USERNAME;
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(URL);
		driverManagerDataSource.setUsername(USERNAME);
		driverManagerDataSource.setPassword(PASSWORD);
		driverManagerDataSource.setDriverClassName(DRIVER);
		return driverManagerDataSource;
	}
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
}
