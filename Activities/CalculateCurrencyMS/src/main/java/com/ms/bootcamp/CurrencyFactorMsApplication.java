package com.ms.bootcamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.ms.bootcamp.model.ConvertFactor;
import com.ms.bootcamp.repo.CurrencyFactorRepository;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrix
@EnableHystrixDashboard
@EnableFeignClients
public class CurrencyFactorMsApplication {

	
	@Autowired
	CurrencyFactorRepository repo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CurrencyFactorMsApplication.class, args);
	}
	
	
	@Bean
	CommandLineRunner bootitup(ApplicationContext ctx) {
		return (a) -> {
			
			ConvertFactor objCF = new ConvertFactor("EUR", 80.0);
			repo.save(objCF);
			objCF = new ConvertFactor("USD", 65.0);
			repo.save(objCF);
			objCF = new ConvertFactor("CAD", 60.0);
			repo.save(objCF);
			objCF = new ConvertFactor("INR", 1.0);
			repo.save(objCF);
			
		};
	}

}
