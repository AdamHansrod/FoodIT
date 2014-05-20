package com.foodit.adam.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.google.appengine.api.datastore.Text;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class MealOption {
	String name;
	boolean multiSelect;
	boolean dropDown;
	List<Option> options;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isMultiSelect() {
		return multiSelect;
	}
	public void setMultiSelect(boolean multiSelect) {
		this.multiSelect = multiSelect;
	}
	public boolean isDropDown() {
		return dropDown;
	}
	public void setDropDown(boolean dropDown) {
		this.dropDown = dropDown;
	}
	public List<Option> getOptions() {
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	
}
