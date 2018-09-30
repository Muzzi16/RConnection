package com.statefarm.remoteserver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration

@PropertySource("classpath:server.properties")
public class ServerConfig {

	// add support to resolve ${...} properties
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceHolderConfigurer() {

		return new PropertySourcesPlaceholderConfigurer();
	}

	@Bean
	public ServerStart serverStart() {

		return new ServerStart();
	}

}
