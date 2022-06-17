# What's Cooking? Server

In the past, recipes were passed down through families on hand-written cards or gathered in cookbooks with notes jotted in the margins.
Now you can share all of your favorite recipes with loved ones near and far. Don’t forget to include the secret ingredient!

What's Cooking? is a recipe management app that allow you to share your recipes with others. 

Each User is linked to one Cookbook, where they will save the Recipes they choose. 
The Cookbook can hold many Recipes. 
A User can make a Note per Recipe. 

View the trello board: https://trello.com/b/nzXCoDvl/whats-cooking-app

Presentation slides: https://docs.google.com/presentation/d/1Chd84AIYlSS-H38_d6vyUUoIWcVoKR0PmY14GGJTLUY/edit#slide=id.g133420955c1_0_0

## Setup

The server is set to run on port 8081.
In the application properties file remember to enter your MySQL password. 

To run the app with some pre-made Users and Recipes, uncomment the code in the command line runner in the application server file.

## Technologies Used
REST API backend with Spring Boot, JPA and Hiberate, and Swagger.

## Models

![whats-cooking-ccd](https://user-images.githubusercontent.com/88110591/174219736-e100024a-9473-4ee6-91a9-2a343197272f.png)

## Server routes table
![Screen Shot 2022-06-17 at 5 37 14 AM](https://user-images.githubusercontent.com/88110591/174219978-4dfb6baa-4dc3-4ee5-b5a7-0bb63e07c43a.png)

![Screen Shot 2022-06-17 at 5 39 37 AM](https://user-images.githubusercontent.com/88110591/174220182-dbb4a4a8-1ebc-4bcd-9901-f7ea494d7077.png)

## Future Work
There are many things I would like to add to this project, especially more interactive features for the user such as:

Ratings system for user's to rate the recipes.

Ability for users to be able to follow eachother and receive recipe suggestions or notifications based on the recipes their connected users are adding. 

## Resources
W3Schools website https://www.w3schools.com/
Baeldung website https://www.baeldung.com/
and of course my Ironhack instructors Raymond and Shaun
