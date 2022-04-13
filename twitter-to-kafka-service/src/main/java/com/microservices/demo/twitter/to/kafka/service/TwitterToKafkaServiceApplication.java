package com.microservices.demo.twitter.to.kafka.service;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.microservices.demo.twitter.to.kafka.service.config.TwitterToKafkaServiceConfig;
import com.microservices.demo.twitter.to.kafka.service.runner.StreamRunner;

@SpringBootApplication
@ComponentScan(basePackages = "com.microservices.demo")
public class TwitterToKafkaServiceApplication implements CommandLineRunner {
	
	private static final Logger LOG = LoggerFactory.getLogger(TwitterToKafkaServiceApplication.class);
	
	private final TwitterToKafkaServiceConfig twitterToKafkaServiceConfig;
	
	private final StreamRunner streamRunner;

	public TwitterToKafkaServiceApplication(TwitterToKafkaServiceConfig configData, StreamRunner runner) {
		this.twitterToKafkaServiceConfig = configData;
		this.streamRunner = runner;
	}

	public static void main(String[] args) {
		SpringApplication.run(TwitterToKafkaServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("App start");
		LOG.info(Arrays.toString(twitterToKafkaServiceConfig.getTwitterKeywords().toArray(new String[] {})));
		LOG.info(twitterToKafkaServiceConfig.getWelcomeMessage());
		streamRunner.start();
	}
	
}
