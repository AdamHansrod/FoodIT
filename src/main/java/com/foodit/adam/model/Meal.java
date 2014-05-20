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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result
//				+ ((category == null) ? 0 : category.hashCode());
//		result = prime * result
//				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
//		result = prime * result
//				+ ((mealTypeOptions == null) ? 0 : mealTypeOptions.hashCode());
//		result = prime * result + ((name == null) ? 0 : name.hashCode());
//		result = prime * result + ((price == null) ? 0 : price.hashCode());
//		result = prime * result + (promotion ? 1231 : 1237);
//		result = prime * result
//				+ ((quantity == null) ? 0 : quantity.hashCode());
//		result = prime * result
//				+ ((sizeAndPrice == null) ? 0 : sizeAndPrice.hashCode());
//		result = prime
//				* result
//				+ ((startingFromPrice == null) ? 0 : startingFromPrice
//						.hashCode());
//		result = prime * result + ((total == null) ? 0 : total.hashCode());
//		result = prime * result
//				+ ((unitPrice == null) ? 0 : unitPrice.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meal other = (Meal) obj;
//		if (category == null) {
//			if (other.category != null)
//				return false;
//		} else if (!category.equals(other.category))
//			return false;
//		if (description == null) {
//			if (other.description != null)
//				return false;
//		} else if (!description.equals(other.description))
//			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
//		if (mealTypeOptions == null) {
//			if (other.mealTypeOptions != null)
//				return false;
//		} else if (!mealTypeOptions.equals(other.mealTypeOptions))
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		if (price == null) {
//			if (other.price != null)
//				return false;
//		} else if (!price.equals(other.price))
//			return false;
//		if (promotion != other.promotion)
//			return false;
//		if (quantity == null) {
//			if (other.quantity != null)
//				return false;
//		} else if (!quantity.equals(other.quantity))
//			return false;
//		if (sizeAndPrice == null) {
//			if (other.sizeAndPrice != null)
//				return false;
//		} else if (!sizeAndPrice.equals(other.sizeAndPrice))
//			return false;
//		if (startingFromPrice == null) {
//			if (other.startingFromPrice != null)
//				return false;
//		} else if (!startingFromPrice.equals(other.startingFromPrice))
//			return false;
//		if (total == null) {
//			if (other.total != null)
//				return false;
//		} else if (!total.equals(other.total))
//			return false;
//		if (unitPrice == null) {
//			if (other.unitPrice != null)
//				return false;
//		} else if (!unitPrice.equals(other.unitPrice))
//			return false;
		return true;
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
