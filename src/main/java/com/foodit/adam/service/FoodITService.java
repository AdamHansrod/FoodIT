package com.foodit.adam.service;

import com.foodit.adam.model.Meal;
import com.foodit.adam.model.Order;
import com.foodit.test.sample.controller.RestaurantData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class FoodITService {
	
	public Integer getMostOrderedMealID() {
		Collection<Order> allOrders = getAllOrders();
		
		Iterator it = allOrders.iterator();
		
		Integer mostCommonOrderID = 0;
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
						mostCommonOrderID = mealID;
						counter = numberOfMealOccurances;
					}
					
				}else{
					mealOccurrence.put(mealID, 1);
				}
			}
		}		
		return mostCommonOrderID;
	}
	
	public Collection<Order> getAllOrders(){
		RestaurantService rs = new RestaurantService();
		Collection<RestaurantData> restaurantData = rs.getRestaurants();
		Collection<Order> allOrders = new ArrayList<Order>();
		for(RestaurantData restaurant: restaurantData) {
			Collection<Order> restaurantOrders = rs.getOrders(restaurant);
			allOrders.addAll(restaurantOrders);
		}
		return allOrders;
	}

}
