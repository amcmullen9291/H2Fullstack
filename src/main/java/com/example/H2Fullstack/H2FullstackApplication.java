package com.example.H2Fullstack;

import com.example.H2Fullstack.Entity.Beverage;
import com.example.H2Fullstack.Entity.Cheese;
import com.example.H2Fullstack.Repository.BeverageRepository;
import com.example.H2Fullstack.Repository.CheeseRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class H2FullstackApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext configurableApplicationContext =
				SpringApplication.run(H2FullstackApplication.class, args);

		CheeseRepository cheeseRepository =
				configurableApplicationContext.getBean(CheeseRepository.class);

		BeverageRepository beverageRepository =
				configurableApplicationContext.getBean(BeverageRepository.class);
		Cheese cheese = new Cheese( 1, "cheese", "cheese","cheese","cheese","cheese","cheese","cheese","cheese","cheese","cheese","cheese","cheese","cheese","cheese");
		cheeseRepository.save(cheese);

		Cheese cheese2 = new Cheese( 2, "cheese2", "cheese","cheese","cheese","cheese","cheese","cheese","cheese","cheese","cheese","cheese","cheese","cheese","cheese");
		cheeseRepository.save(cheese2);

		Beverage beverage = new Beverage(1, "beverage", "beverage", "beverage", "beverage", "beverage", "beverage");
		beverageRepository.save(beverage);
	}

}
