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
//			userRepository.saveAll(List.of(user1, user2, user3));
//
//			Recipe recipe1 = new Recipe("Recipe 1", 10, 30, 4, "1 cup ingredient1, 2T ingredient2, pinch of ingredient3", "First mix everything. Then bake for 30 min.", user1);
//			Recipe recipe2 = new Recipe("Recipe 2", 30, 60, 6, "1 cup ingredient1, 2T ingredient2, pinch of ingredient3", "First mix everything. Then bake for 30 min.", user2);
//			Recipe recipe3 = new Recipe("Recipe 3", 20, 15, 2, "1 cup ingredient1, 2T ingredient2, pinch of ingredient3", "First mix everything. Then bake for 30 min.", user3);
//
//			Note note1 = new Note(user1, recipe1, "Use 1.5 cups of ingredient 1 instead!");
//			noteRepository.save(note1);
//
//			Cookbook cookbook1 = new Cookbook(user1.getId(), user1);
//			Cookbook cookbook2 = new Cookbook(user2.getId(), user2);
//			Cookbook cookbook3 = new Cookbook(user3.getId(), user3);
//
//			recipe1.addCookbookToList(cookbook1);
//			recipe1.addCookbookToList(cookbook3);
//			recipe2.addCookbookToList(cookbook2);
//			recipe2.addCookbookToList(cookbook3);
//			recipe3.addCookbookToList(cookbook3);
//			recipe3.addCookbookToList(cookbook2);
//			recipeRepository.saveAll(List.of(recipe1, recipe2, recipe3));
//			cookbookRepository.saveAll(List.of(cookbook1, cookbook2, cookbook3));
//		};
//	}
}
