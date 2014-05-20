package com.foodit.adam.service;

import com.foodit.adam.model.Meal;
import com.foodit.adam.model.Menu;
import com.foodit.adam.model.Order;
import com.foodit.test.sample.controller.RestaurantData;

import java.math.BigDecimal;
import java.util.Collection;

public interface RestaurantService {

	public Collection<RestaurantData> getRestaurants();

	public RestaurantData getRestaurant(String name);

	public Collection<Order> getOrders(String restaurant);

	public Collection<Order> getOrders(RestaurantData rd);
	
	public BigDecimal getTotalSales(String restaurant);
	
	public Menu getMenu(String restaurant);
	
	public Menu getMenu(RestaurantData rd);
	
	public Collection<Meal> getMeals(String restaurant);
	
	public String getMostOrderedCategory(String restaurant);
	
}
