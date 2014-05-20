package com.foodit.adam.service;

import com.foodit.adam.model.Meal;
import com.foodit.adam.model.Order;

import java.util.Collection;

public abstract interface FoodITService {
	
	public abstract Meal getMostOrderedMeal(); 
	
	public abstract Collection<Order> getAllOrders();

}
