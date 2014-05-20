package com.foodit.adam.service;

import com.foodit.adam.model.Meal;
import com.foodit.adam.model.Menu;
import com.foodit.adam.model.Order;
import com.foodit.test.sample.controller.RestaurantData;
import com.google.appengine.api.search.query.ExpressionParser.name_return;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

public class FoodITServiceImp implements FoodITService {
	
	public Collection<Meal> getAllPopularMeals(){
		Collection<Meal> popularMeals = new  ArrayList<Meal>();
		RestaurantService rs = new RestaurantServiceImp();
		Collection<RestaurantData> restaurants = rs.getRestaurants();
		for(RestaurantData restaurant: restaurants) {
			String name = restaurant.getRestaurant();
			popularMeals.add(getMostOrderedMeal(name));
		}
		return popularMeals;
	}
	
	public Meal getMostOrderedMeal(String restaurant) {
		RestaurantService rs = new RestaurantServiceImp();
		Menu menu = rs.getMenu(restaurant);
		Collection<Order> orders = rs.getOrders(restaurant);
		Meal mostPopularMeal = getMostOrderedMeal(orders);
		Integer mostPopularMealID = mostPopularMeal.getId();
		Meal menuMeal = getMealFromMenu(menu, mostPopularMealID);
		return menuMeal;
	}
	
	public Meal getMealFromMenu(Menu menu, Integer mealID) {
		for(Meal meal : menu.getMenu()) {
			if (meal.getId().equals(mealID)) {
				return meal;
			}
		}
		return new Meal();
	}
	public Meal getMostOrderedMeal(Collection<Order> orders) {
		Iterator it = orders.iterator();
		Meal mostOrderedMeal = new Meal();
		Integer counter= 0;
		HashMap<Integer, Integer> mealOccurrence = new HashMap<Integer, Integer>();
		
		while (it.hasNext()) {//go through all orders counting occurrence of meals
			Order order = (Order) it.next();
			Collection<Meal> orderedMeals = order.getLineItems();
			
			for(Meal meal:orderedMeals) {//get the number of times a meal appears
				Integer mealID = meal.getId();
				if (mealOccurrence.containsKey(mealID)) {
					
					//up the number of occurrence
					Integer numberOfMealOccurances = mealOccurrence.get(mealID);
					numberOfMealOccurances = numberOfMealOccurances + 1;
					mealOccurrence.put(mealID, numberOfMealOccurances );
					
					//if it's highest number of occurrence then set it
					//doing this here, so we can just do one pass.
					if (numberOfMealOccurances > counter && mealID !=null) {
						mostOrderedMeal = meal;
						counter = numberOfMealOccurances;
					}
					
				}else{
					mealOccurrence.put(mealID, 1);
				}
			}
		}		
		return mostOrderedMeal;
	}
	public Collection<Order> getAllOrders(){
		RestaurantService rs = new RestaurantServiceImp();
		Collection<RestaurantData> restaurantData = rs.getRestaurants();
		Collection<Order> allOrders = new ArrayList<Order>();
		for(RestaurantData restaurant: restaurantData) {
			Collection<Order> restaurantOrders = rs.getOrders(restaurant);
			allOrders.addAll(restaurantOrders);
		}
		return allOrders;
	}
}
