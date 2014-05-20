package com.foodit.adam.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

import com.google.appengine.api.datastore.Text;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Option {
	String label;
	HashMap<String,BigDecimal> pricesForSize;
	
	public Option() {};
	
	public Option(String label, HashMap<String, BigDecimal> pricesForSize) {
		super();
		this.label = label;
		this.pricesForSize = pricesForSize;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public HashMap<String, BigDecimal> getPricesForSize() {
		return pricesForSize;
	}
	public void setPricesForSize(HashMap<String, BigDecimal> pricesForSize) {
		this.pricesForSize = pricesForSize;
	}
	
}
