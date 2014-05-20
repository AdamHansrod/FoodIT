package com.foodit.adam.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.google.appengine.api.datastore.Text;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

public class Meal {
	String id;
	String name;
	String description;
	String category;
	HashMap<String,BigDecimal> sizeAndPrice;
	Collection<MealOption> mealTypeOptions;
	BigDecimal startingFromPrice;
	
	public Meal(String id, String name, String description, String category,
			HashMap<String, BigDecimal> sizeAndPrice,
			Collection<MealOption> mealTypeOptions, BigDecimal startingFromPrice) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.sizeAndPrice = sizeAndPrice;
		this.mealTypeOptions = mealTypeOptions;
		this.startingFromPrice = startingFromPrice;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public HashMap<String, BigDecimal> getSizeAndPrice() {
		return sizeAndPrice;
	}
	public void setSizeAndPrice(HashMap<String, BigDecimal> sizeAndPrice) {
		this.sizeAndPrice = sizeAndPrice;
	}
	public Collection<MealOption> getMealTypeOptions() {
		return mealTypeOptions;
	}
	public void setMealTypeOptions(Collection<MealOption> mealTypeOptions) {
		this.mealTypeOptions = mealTypeOptions;
	}
	public BigDecimal getStartingFromPrice() {
		return startingFromPrice;
	}
	public void setStartingFromPrice(BigDecimal startingFromPrice) {
		this.startingFromPrice = startingFromPrice;
	}
	
}
