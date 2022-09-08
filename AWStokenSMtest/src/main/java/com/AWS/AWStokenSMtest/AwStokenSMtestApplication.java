package com.AWS.AWStokenSMtest;

import com.AWS.AWStokenSMtest.Config.AppConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;

@SpringBootApplication(exclude = ContextStackAutoConfiguration.class)
public class AwStokenSMtestApplication {
	
	@Autowired
	private AppConfig appConfig;

	public static void main(String[] args) {
		SpringApplication.run(AwStokenSMtestApplication.class, args);
	
	}
	
	public void getKeys() {
		System.out.println("Private Key: " +appConfig.getSecret().getPubkey());
		System.out.println("Public Key:  " +appConfig.getSecret().getPrikey());
	}
	
	

}
