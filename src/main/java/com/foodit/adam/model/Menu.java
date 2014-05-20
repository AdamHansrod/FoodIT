package com.foodit.adam.model;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.google.appengine.api.datastore.Category;
import com.google.appengine.api.datastore.Text;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

public class Menu {
	Collection<Meal> meals;
	String restaurantId;
	
	public Menu(Collection<Meal> menu, String restaurantId) {
		super();
		this.meals = menu;
		this.restaurantId = restaurantId;
	}
	public Collection<Meal> getMenu() {
		return meals;
	}
	public void setMenu(Collection<Meal> menu) {
		this.meals = menu;
	}

	public String getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}


}
