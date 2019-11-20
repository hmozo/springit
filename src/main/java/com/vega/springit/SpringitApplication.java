package com.vega.springit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import com.vega.springit.config.SpringitProperties;

@SpringBootApplication
@EnableConfigurationProperties(SpringitProperties.class)
public class SpringitApplication {

	@Autowired
	private SpringitProperties springitProperties;
	
	private static final Logger log= LoggerFactory.getLogger(SpringitApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringitApplication.class, args);
		System.out.println("Welcome to SPRING-BOOT");
		
	}
	
	@Bean
	@Profile("dev")
	CommandLineRunner runner() {
		return args->{
			System.out.println("Welcome message: " + springitProperties.getWelcomeMsg());
			log.error("ERROR log: CommandLineRunner runner()");
			log.warn("WARN log: CommandLineRunner runner()");
			log.info("INFO log: CommandLineRunner runner()");
			log.debug("DEBUG log: CommandLineRunner runner()");
			//log.trace("TRACE log: CommandLineRunner runner()");
		};
	}

}
