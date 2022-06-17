package com.ironhack.whatscookingserver;

import com.ironhack.whatscookingserver.models.Cookbook;
import com.ironhack.whatscookingserver.models.Note;
import com.ironhack.whatscookingserver.models.Recipe;
import com.ironhack.whatscookingserver.models.User;
import com.ironhack.whatscookingserver.repository.CookbookRepository;
import com.ironhack.whatscookingserver.repository.NoteRepository;
import com.ironhack.whatscookingserver.repository.RecipeRepository;
import com.ironhack.whatscookingserver.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

@SpringBootApplication
@EnableSwagger2
public class WhatsCookingServerApplication {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(WhatsCookingServerApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer(){
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry){
				registry.addMapping("/**").allowedMethods("*").allowedOrigins("http://localhost:3000");
			}
		};
	}

//	@Bean
//	CommandLineRunner run(PasswordEncoder passwordEncoder, UserRepository userRepository, CookbookRepository cookbookRepository, RecipeRepository recipeRepository, NoteRepository noteRepository) {
//		return args -> {
//			User user1 = new User("Beth", "beth@email.com", "P@ssw0rdbeth");
//			user1.setPassword(passwordEncoder.encode(user1.getPassword()));
//			User user2 = new User("Allison", "allison@email.com", "P@ssw0rdallison");
//			user2.setPassword(passwordEncoder.encode(user2.getPassword()));
//			User user3 = new User("Margaret", "margaret@email.com", "P@ssw0rdmargaret");
//			user3.setPassword(passwordEncoder.encode(user3.getPassword()));
////			User user4 = new User("Pat", "pat@email.com", "P@ssw0rdpat");
////			user4.setPassword(passwordEncoder.encode(user4.getPassword()));
////			User user5 = new User("Daniel", "daniel@email.com", "P@ssw0rddaniel");
////			user5.setPassword(passwordEncoder.encode(user5.getPassword()));
////			User user6 = new User("Mario", "mario@email.com", "P@ssw0rdmario");
////			user6.setPassword(passwordEncoder.encode(user6.getPassword()));
////			User user7 = new User("Tamara", "tamara@email.com", "P@ssw0rdtamara");
////			user7.setPassword(passwordEncoder.encode(user7.getPassword()));
////			User user8 = new User("Julia", "julia@email.com", "P@ssw0rdjulia");
////			user8.setPassword(passwordEncoder.encode(user8.getPassword()));
////			User user9 = new User("Elena", "elena@email.com", "P@ssw0rdelena");
////			user9.setPassword(passwordEncoder.encode(user9.getPassword()));
////			User user10 = new User("Carlos", "carlos@email.com", "P@ssw0rdcarlos");
////			user10.setPassword(passwordEncoder.encode(user10.getPassword()));
//			userRepository.saveAll(List.of(user1, user2, user3));
//
//			Recipe recipe1 = new Recipe("Strawberry Tart", 35, 20, 8, "300g " +
//					"all-purpose flour, 1 tablespoon granulated sugar, 1 teaspoon kosher salt, 230g unsalted butter cold, " +
//					"60-120ml ice water, 340g crème fraîche or sour cream, 340g fresh soft goat cheese, 1/4 teaspoon sea salt," +
//					" 1/4 teaspoon white pepper, 2 pints strawberries, Balsamic vinegar, 1 tablespoon finely chopped fresh chives",
//					"1.  For the tart crust: Put the flour, sugar and salt and butter in a food processor and " +
//							"pulse until the chunks of butter are broken down to the size of peas and the flour feels " +
//							"like wet sand. You can also combine quickly using your fingertips. Add 1/4 cup of the ice water " +
//							"and pulse until the dough comes together easily. If it immediately separates into clumps, " +
//							"add 2 tablespoons of the remaining water at a time. You can always add more water but not more " +
//							"flour, so be careful not to add too much!   2. Divide the dough into 2 balls and set them on top " +
//							"of 2 sheets of plastic wrap. Loosely wrap up each ball and press down to flatten into a " +
//							"1-inch-thick disk. 3. Refrigerate for at least 30 minutes before using. 4. When ready to bake, " +
//							"preheat the oven to 220 degrees C. 5. Roll out 1 dough disk (see Cook’s Note) on a lightly " +
//							"floured surface to 1/8 inch thick and lay over a 9-inch tart pan. Gently press the dough into " +
//							"the pan, careful not to stretch or rip it (you can patch holes with excess dough).Prick the dough " +
//							"with a fork, cover the pan with parchment paper and fill with dried beans or pie weights. Bake for " +
//							"10 minutes, then lower the oven temperature to 375 degrees F. Remove the beans or weights and the " +
//							"parchment, and finish baking until golden brown, 10 to 15 minutes. Set the tart shell aside to cool " +
//							"completely. 6. For the filling: Whip the crème fraîche, goat cheese, salt and pepper together in a " +
//							"large bowl with a handheld electric mixer until smooth and light. Spread into the cooled tart crust " +
//							"and top with the strawberries around the edges.Drizzle with balsamic vinegar and sprinkle with " +
//							"the chives.This tart is best the same day it’s made.", user1);
//			Recipe recipe2 = new Recipe("Baked Feta Pasta", 30, 45, 4,
//					"2 pt. cherry or grape tomatoes, 1 shallot, quartered, 3 cloves garlic, 1/2 c. extra-virgin olive oil, " +
//					"Kosher salt, Pinch crushed red pepper flakes, 1 (8-oz.) block feta, 3 sprigs fresh thyme, 10 oz. pasta, " +
//					"Zest of 1 lemon (optional), Fresh basil, for garnish", "1. Preheat oven to 400°. In a large " +
//					"ovenproof skillet or medium baking dish, combine tomatoes, shallot, garlic, and all but 1 tablespoon " +
//					"oil. Season with salt and red pepper flakes and toss to combine. 2. Place feta into center of tomato " +
//					"mixture and drizzle with remaining 1 tablespoon oil. Scatter thyme sprigs over tomatoes. Bake for " +
//					"40 to 45 minutes, until tomatoes are bursting and feta is golden on top. 3. Meanwhile, in a large pot " +
//					"of boiling salted water, cook pasta until al dente according to package directions. Reserve ½ cup " +
//					"pasta water before draining. 4. To skillet with tomatoes and feta, add cooked pasta, reserved pasta " +
//					"water, and lemon zest (if using) and stir until combined. Garnish with basil.", user2);
//			Recipe recipe3 = new Recipe("Black Bean Tostadas", 5, 20, 4,
//					"2 (15-oz.) cans black beans rinsed and drained, 8 tostadas, 2 c. shredded pepper jack " +
//							"cheese, Avocado, Hot sauce", "1. Preheat oven to 350°. In a small saucepan over " +
//					"medium heat, add beans and 1 cup of water. Bring to a simmer and let simmer until beans are warmed " +
//					"through, about 10 minutes. Smash with a wooden spoon until most of the beans are smashed with some " +
//					"whole remaining. Add more water as needed to help create a smoother consistency.  2. Meanwhile, " +
//					"place tostadas on a large baking sheet and sprinkle cheese evenly over each. 3. Bake until cheese is " +
//					"melty, about 5 minutes." +
//					"Top tostadas with beans, avocado slices, and hot sauce.", user3);
//			Recipe recipe4 = new Recipe("Honey Garlic Salmon", 5, 20, 4, "1/3 c. honey, 1/4 c. low-sodium soy sauce, " +
//					"2 tbsp. lemon juice, 1 tsp. red pepper flakes, 3 tbsp. extra-virgin olive oil divided, 4 6-oz. salmon " +
//					"fillets, Kosher salt, Freshly ground black pepper, 3 cloves garlic minced, 1 lemon sliced into " +
//					"rounds", "1. In a medium bowl, whisk together honey, soy sauce, lemon juice and red pepper flakes. " +
//					"2. In a large skillet over medium-high heat, heat two tablespoons oil. When oil is hot but not smoking, " +
//					"add salmon skin-side up and season with salt and pepper. Cook salmon until deeply golden, about 6 " +
//					"minutes, then flip over and add remaining tablespoon of oil. 3. Add garlic to the skillet and cook " +
//					"until fragrant, 1 minute. Add the honey mixture and sliced lemons and cook until sauce is reduced " +
//					"by about 1/3. Baste salmon with the sauce. 4. Garnish with sliced lemon and serve.", user1);
//			Recipe recipe5 = new Recipe("Sausage and Vegetables", 15, 60, 4, "3/4 lb. baby potatoes sliced, 1 medium " +
//					"head broccoli cut, 1 red bell pepper chopped, 1/2 medium red onion quartered, 2 tbsp. extra-virgin " +
//					"olive oil, 1 tsp. garlic powder, 1 tsp. dried oregano, 1/2 tsp. ground mustard, Kosher salt, " +
//					"Freshly ground black pepper, Pinch crushed red pepper flakes, 12 oz. andouille sausage cut", "1. " +
//					"Preheat oven to 400°. Place potatoes, broccoli, bell pepper, and red onion on a large sheet tray. " +
//					"Drizzle with oil and season with garlic powder, oregano, mustard, salt, pepper, and large pinch of " +
//					"red pepper flakes. Toss to coat all the veggies, then spread out into an even layer. 2. Bake for 25 " +
//					"minutes. Remove tray from oven and add sausage. Toss veggies with sausage then spread back out into " +
//					"an even layer. 3. Bake again until sausage has darkened and is warmed through and veggies are crisp " +
//					"tender, another 20 to 25 minutes more.", user1);
//			Recipe recipe6 = new Recipe("Pork Chops", 20, 20, 4, "4 bone-in " +
//					"pork chops trimmed of fat, 2 tbsp. extra-virgin olive oil, kosher salt, Freshly ground black pepper, " +
//					"4 sprigs fresh rosemary", "1. Preheat oven to 400º. Rub pork chops with " +
//					"olive oil and season generously with salt and pepper. Set a cast-iron skillet over medium-high heat " +
//					"on the stovetop to heat up, 5 minutes. 2. Add pork chops to skillet and sear 3 minutes, then flip. " +
//					"Add rosemary sprigs to skillet then transfer to oven and continue cooking until no longer pink, 6 to " +
//					"8 minutes.", user2);
//			Recipe recipe7 = new Recipe("BBQ Chicken Nachos", 10, 25, 4, "2 c. shredded chicken, 3/4 c. barbecue sauce, " +
//					"1 (18-oz.) bag tortilla chips, 3 c. shredded cheddar, 1 c. crumbled Cotija, 1 c. pickled jalapeños, " +
//					"1/2 small red onion thinly sliced, 1 avocado thinly sliced, Freshly chopped cilantro", "1. Preheat " +
//					"oven to 400° and line a large baking sheet with foil. In a large bowl, toss chicken with barbecue " +
//					"sauce. 2. Layer half the chips, cheddar, Cotija, chicken, pickled jalapeños, and onion. Repeat. 3. " +
//					"Bake until cheese is melty and nachos warmed through, 15 minutes. 4. Top with avocado and cilantro " +
//					"before serving.", user1);
//			Recipe recipe8 = new Recipe("Grilled Cheese", 5,15,2, "5 tbsp. butter softened, 4 slices sourdough bread, " +
//					"2 c. shredded cheddar", "1. Spread 1 tablespoon butter on one side of each slice of bread. With butter " +
//					"side down, top each slice of bread with about ½ cup cheddar. 2. In a skillet over medium heat, " +
//					"melt 1 tablespoon butter. Add two slices of bread, butter side down. Cook until bread is golden and " +
//					"cheese is starting to melt, about 2 minutes. Flip one piece of bread on top of the other and " +
//					"continue to cook until cheese is melty, about 30 seconds more. 3. Repeat for the second sandwich, " +
//					"wiping skillet clean if necessary.", user3);
//			Recipe recipe9 = new Recipe("Garlic Lemon Tilapia", 5, 20, 4, "4 (6-oz.) tilapia fillets, Kosher salt, Freshly " +
//					"ground black pepper, 5 tbsp. butter melte, 2 cloves garlic minced, 1/4 tsp. red pepper flakes, Juice " +
//					"and zest from 1/2 lemon, 1 lemon sliced into rounds", "1. Preheat oven to 400°. Season tilapia with " +
//					"salt and pepper and place on a small baking sheet. 2. Mix together butter, garlic, red pepper flakes, " +
//					"lemon juice, and zest then pour over tilapia. Place lemon rounds on top and around tilapia. 3. Bake " +
//					"tilapia until fork-tender, 10 to 12 minutes.", user1);
//			Recipe recipe10 = new Recipe("Pickles", 5, 120, 10, "1 lb. Kirby or Persian cucumbers, 3 cloves garlic, " +
//					"peeled and crushed, 2 large sprigs fresh dil, 1 c. water, 3/4 c. white vinegar, 1 tbsp. kosher salt",
//					"1. Trim ends from cucumbers and slice into spears. Pack into 2 (16-oz. glass jar along with garlic " +
//							"and dill. 2. Make brine: in a small saucepan, combine water, vinegar, and salt. Bring to a " +
//							"boil, stir until salt is dissolved, and remove from heat and let cool slightly. Pour over " +
//							"cucumbers, seal jar, and shake. Let cool completely on the counter, then refrigerate until " +
//							"cold. 3. Wait at least 2 hours to eat the pickles, but the longer you wait, the more flavorful " +
//							"they’ll be. If you can, try waiting 24 hours.", user2);
//
//
//			Cookbook cookbook1 = new Cookbook(user1.getId(), user1);
//			Cookbook cookbook2 = new Cookbook(user2.getId(), user2);
//			Cookbook cookbook3 = new Cookbook(user3.getId(), user3);
////			Cookbook cookbook4 = new Cookbook(user4.getId(), user4);
////			Cookbook cookbook5 = new Cookbook(user5.getId(), user5);
////			Cookbook cookbook6 = new Cookbook(user6.getId(), user6);
////			Cookbook cookbook7 = new Cookbook(user7.getId(), user7);
////			Cookbook cookbook8 = new Cookbook(user8.getId(), user8);
////			Cookbook cookbook9 = new Cookbook(user9.getId(), user9);
////			Cookbook cookbook10 = new Cookbook(user10.getId(), user10);
//
//			recipe1.addCookbook(cookbook1);
//			recipe1.addCookbook(cookbook2);
//			recipe2.addCookbook(cookbook2);
//			recipe2.addCookbook(cookbook1);
//			recipe2.addCookbook(cookbook3);
//			recipe3.addCookbook(cookbook3);
//			recipe3.addCookbook(cookbook2);
//			recipe4.addCookbook(cookbook1);
//			recipe5.addCookbook(cookbook3);
//			recipe5.addCookbook(cookbook1);
//			recipe6.addCookbook(cookbook2);
//			recipe7.addCookbook(cookbook1);
//			recipe8.addCookbook(cookbook3);
//			recipe9.addCookbook(cookbook1);
//			recipe9.addCookbook(cookbook2);
//			recipe10.addCookbook(cookbook2);
//
//
//
//			recipeRepository.saveAll(List.of(recipe1, recipe2, recipe3, recipe4, recipe5, recipe6, recipe7, recipe8, recipe9, recipe10));
//			cookbookRepository.saveAll(List.of(cookbook1, cookbook2, cookbook3));
//		};
//	}
}
