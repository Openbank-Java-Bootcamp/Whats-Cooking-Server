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

	@Bean
	CommandLineRunner run(PasswordEncoder passwordEncoder, UserRepository userRepository, CookbookRepository cookbookRepository, RecipeRepository recipeRepository, NoteRepository noteRepository) {
		return args -> {
			User user1 = new User("Beth", "beth@email.com", "P@ssw0rdbeth");
			user1.setPassword(passwordEncoder.encode(user1.getPassword()));
			User user2 = new User("Allison", "allison@email.com", "P@ssw0rdallison");
			user2.setPassword(passwordEncoder.encode(user2.getPassword()));
			User user3 = new User("Margaret", "margaret@email.com", "P@ssw0rdmargaret");
			user3.setPassword(passwordEncoder.encode(user3.getPassword()));
			userRepository.saveAll(List.of(user1, user2, user3));

			Recipe recipe1 = new Recipe("Cookies", 20, 25, 8, "2 cups flour, 1/2 cup sugar, 1t baking powder, 1 egg, 1/4 cup water, 1/4t vanilla extract, 1/2 cup chocolate chips", "First mix everything. Then bake for 25 min.", user1);
			Recipe recipe2 = new Recipe("Pizza", 30, 35, 4, "3 cups flour, 2 eggs, water, 1/2t salt, 3/4 cup tomato sauce, 1.5 cups shredded cheese", "Combine flour, eggs, water, and salt and knead to make the dough. Form dough on pizza pan, spread sauce on top, and sprinkle the cheese. Add any toppings as desired. Bake 35 min at 400F ", user2);
			Recipe recipe3 = new Recipe("Quesadilla", 5, 5, 1, "2 tortillas, 3/4 cup cheese, tomato salsa", "Put the cheese between the tortillas. Grill 2 min on each side. Dip in salsa to eat.", user3);

//			Note note1 = new Note(user1, recipe1, "Use 1.5 cups of ingredient 1 instead!");
//			noteRepository.save(note1);

			Cookbook cookbook1 = new Cookbook(user1.getId(), user1);
			Cookbook cookbook2 = new Cookbook(user2.getId(), user2);
			Cookbook cookbook3 = new Cookbook(user3.getId(), user3);

			recipe1.addCookbook(cookbook1);
			recipe1.addCookbook(cookbook3);
			recipe2.addCookbook(cookbook2);
			recipe2.addCookbook(cookbook3);
			recipe3.addCookbook(cookbook3);
			recipe3.addCookbook(cookbook2);
			recipeRepository.saveAll(List.of(recipe1, recipe2, recipe3));
			cookbookRepository.saveAll(List.of(cookbook1, cookbook2, cookbook3));
		};
	}
}
