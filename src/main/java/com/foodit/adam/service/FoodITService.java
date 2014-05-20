package com.foodit.adam.service;

import com.foodit.adam.model.Meal;
import com.foodit.adam.model.MealPopularity;
import com.foodit.adam.model.Menu;
import com.foodit.adam.model.Order;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface FoodITService {
	
	public Collection<Meal> getAllPopularMeals();
	
	public Meal getMostOrderedMeal(String restaurant);
		
	public Meal getMostOrderedMeal(Collection<Order> orders); 
	public Meal getMealFromMenu(Menu menu, Integer mealID);
	
	public Collection<Order> getAllOrders();

}
