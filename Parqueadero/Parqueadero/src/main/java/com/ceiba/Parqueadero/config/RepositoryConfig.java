package com.ceiba.parqueadero.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.ceiba.Parqueadero.repository")
@EntityScan(basePackages = "com.ceiba.Parqueadero.model")
@EnableTransactionManagement
public class RepositoryConfig {

}
