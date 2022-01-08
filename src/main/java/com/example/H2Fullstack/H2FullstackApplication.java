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

		Cheese cheese3 = new Cheese(3,"Hefeweizen", "Witbier", "Lambic", "Weissbock", "","", "", "", "France", "Goat", "Varies", "Chèvre is unaged and eaten almost immediately after it is made. Fresh chèvre tends to be moist, bright and acidic, with a lemony flavor and slightly chalky finish in the mouth.", "Crumbled in salads, breaded and fried, in sandwiches, in macaroni and cheese.", "");
		cheeseRepository.save(cheese3);

		Cheese cheese4 = new Cheese(4, "Feta", "Hefeweizen", "IPA", "Pale Ale", "Weissbier", "Witbier", "ESB", "", "Greece", "Sheep and goat", "About 3 months", "A brined cheese, Feta is made by soaking freshly pressed curds in salt water. Tangy and moist, feta can range from completely crumbly to moderately creamy and pairs well with fresh summer fruit.", "Broiled with olive oil. Crumbled in salads. Sandwiches. Use in place of Cotija in tacos and other Mexican dishes.", "" );
		cheeseRepository.save(cheese4);

		Cheese cheese5 = new Cheese(5, "Emmental","Doppelbock", "Old Ale", "Oktoberfest", "Bock", "ESB", "", "", "Switzerland", "Cow", "At least 4 months", "This cheese has a certain sweetness with a piquancy that hits the back of the tongue on the finish. What is more, like all Alpine cheeses, it is a great melter.", "Fondue, grilled cheese, casseroles.", "" );
		cheeseRepository.save(cheese5);

		Cheese cheese6 = new Cheese (6, "Cheddar", "Pilsner","Triple", "Imperial Stout", "Pale Ale", "Barley Wine", "IPA", "Lambic", "England", "Cow", "No minimum, but good ones are generally aged at least one year", "Cheddar cheeses made in a traditional fashion are dry and crumbly in texture, with a deep, tangy, nutty flavor. A far cry from the smooth mild American-style cheddars you might find on top of a burger.", "As is, in sandwiches, grilled cheese, casseroles.", "");
		cheeseRepository.save(cheese6);

		Cheese cheese7 = new Cheese (7, "Gouda", "Brown Ale", "Doppelbock", "Witbier", "ESB", "Imperial Stout", "Hefeweizen", "Old Ale", "Netherlands", "Cow", "At least 4 weeks, but better ones are aged at least a year", "Flavor can vary wildly from the mild, creamy wax-coated lunchbox versions to those specimens that are hard, crumbly, and deeply flavorful. Long-aged goudas will have a crunchy texture.", "Young, they can be melted. Aged cheeses are best as-is or grated into salads or over casseroles.", "");
		cheeseRepository.save(cheese7);

		Cheese cheese8 = new Cheese (8, "Monterey Jack", "Pale Ale", "Oktoberfest", "Pilsner", "Kölsch", "IPA", "Witbier", "", "United States of America (California)", "Cow", "About one month", "Very mild and buttery in flavor with a bit of tang, Monterey Jack is one of the few all-American cheeses.", "Melted in casseroles, grilled cheese, over chili, cheese dip, any time you want a good melting cheese.", "");
		cheeseRepository.save(cheese8);

		Beverage beverage = new Beverage(1,"Weissbock", "Chèvre","","","","");
		beverageRepository.save(beverage);

		Beverage beverage2 = new Beverage(2,"Weissbier", "Feta","","","","");
		beverageRepository.save(beverage2);
	}

}
