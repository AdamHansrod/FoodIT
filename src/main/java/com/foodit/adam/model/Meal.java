package com.foodit.adam.model;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.google.appengine.api.datastore.Text;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

public class Meal {
	Integer id;
	String name;
	String description;
	String category;
	HashMap<String,BigDecimal> sizeAndPrice;
	Collection<MealOption> mealTypeOptions;
	BigDecimal startingFromPrice;
	BigDecimal total ;
	BigDecimal unitPrice;
	BigDecimal price;
	Integer quantity;
	boolean promotion;
	public Meal() {};
	
	public Meal(Integer id, String name, String description, String category,
			HashMap<String, BigDecimal> sizeAndPrice,
			Collection<MealOption> mealTypeOptions,
			BigDecimal startingFromPrice, BigDecimal total,
			BigDecimal unitPrice, BigDecimal price, Integer quantity,
			boolean promotion) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.sizeAndPrice = sizeAndPrice;
		this.mealTypeOptions = mealTypeOptions;
		this.startingFromPrice = startingFromPrice;
		this.total = total;
		this.unitPrice = unitPrice;
		this.price = price;
		this.quantity = quantity;
		this.promotion = promotion;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public boolean isPromotion() {
		return promotion;
	}
	public void setPromotion(boolean promotion) {
		this.promotion = promotion;
	}
	
	
}
