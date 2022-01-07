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
		Cheese cheese = new Cheese( 1, "Roquefort", "Barley Wine","IPA","Lambic","Saison","Triple","Dubbel","","France","Sheep","At least five months","It has a moist, crumbly paste, and a sharp, sweet and nutty flavor from the yeast with distinct grassiness from the sheep's milk. It's best eaten in the fall, when cheese made from early spring milk is just coming to market.","Eaten as is, or with nuts and honey.","None yet.");
		cheeseRepository.save(cheese);

		Cheese cheese2 = new Cheese( 2, "Camembert", "Altbier","Bock","Brown Ale","Doppelbock","Pale Ale","Saison","Kölsch","France (Normandy)","Cow","At least three weeks","You will not find any raw milk Camembert in the U.S. Rich, buttery, and spreadable, Camembert has a mild, mushroomy aroma.","Eaten as is, on sandwiches, baked in a crust, breaded and deep-fried (giddy-up!)","None yet.");
		cheeseRepository.save(cheese2);

		Beverage beverage = new Beverage(1,"Weissbock", "Chèvre","","","","");
		beverageRepository.save(beverage);

		Beverage beverage2 = new Beverage(2,"Weissbier", "Feta","","","","");
		beverageRepository.save(beverage2);
	}

}
