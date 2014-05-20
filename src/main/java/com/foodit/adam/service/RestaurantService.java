package com.foodit.adam.service;

import com.foodit.adam.model.Meal;
import com.foodit.adam.model.Menu;
import com.foodit.adam.model.Order;
import com.foodit.test.sample.controller.RestaurantData;

import java.math.BigDecimal;
import java.util.Collection;

public abstract interface RestaurantService {

	public abstract Collection<RestaurantData> getRestaurants();

	public abstract RestaurantData getRestaurant(String name);

	public abstract Collection<Order> getOrders(String restaurant);

	public abstract Collection<Order> getOrders(RestaurantData rd);
	
	public abstract BigDecimal getTotalSales(String restaurant);
	
	public abstract Menu getMenu(String restaurant);
	
	public abstract Menu getMenu(RestaurantData rd);
	
	public abstract Collection<Meal> getMeals(String restaurant);
	
	public abstract String getMostOrderedCategory(String restaurant);
	
}
