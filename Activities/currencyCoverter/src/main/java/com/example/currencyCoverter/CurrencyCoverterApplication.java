package com.example.currencyCoverter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CurrencyCoverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyCoverterApplication.class, args);
	}
	
	@Bean
	CommandLineRunner bootitup(ApplicationContext ctx) {
		return (a) -> {
			int count = ctx.getBeanDefinitionCount();
			System.out.println("Total Bean Count = " + count);
			String beans[] = ctx.getBeanDefinitionNames();
			
			  for (int i = 0; i < count; i++) { System.out.println(beans[i]); }
		};
	}


}
