package com.ceiba.estacionamiento.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.ceiba.estacionamiento.repository")
@EntityScan(basePackages = "com.ceiba.estacionamiento.model")
@EnableTransactionManagement
public class RepositoryConfig {

}
