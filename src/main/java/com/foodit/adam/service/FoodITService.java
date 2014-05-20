package com.foodit.adam.service;

import com.foodit.adam.model.Meal;
import com.foodit.adam.model.Order;

import java.util.Collection;

public interface FoodITService {
	
	public Meal getMostOrderedMeal(); 
	
	public Collection<Order> getAllOrders();

}
