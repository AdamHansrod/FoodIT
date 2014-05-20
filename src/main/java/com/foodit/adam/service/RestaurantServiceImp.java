package com.foodit.adam.service;

import com.foodit.adam.model.Meal;
import com.foodit.adam.model.Menu;
import com.foodit.adam.model.Order;
import com.foodit.test.sample.controller.RestaurantData;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.google.gson.Gson;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class RestaurantServiceImp implements RestaurantService {

	public Collection<RestaurantData> getRestaurants() {
		return ofy().load().type(RestaurantData.class).list();
	}

	public RestaurantData getRestaurant(String name) {
		return ofy().load().type(RestaurantData.class).filter("restaurant ==", name).list().get(0);
	}

	public Collection<Order> getOrders(String restaurant) {
		RestaurantData rd = getRestaurant(restaurant);
		Collection<Order> orders = getOrders(rd);
		return orders;
	}

	public Collection<Order> getOrders(RestaurantData rd) {
		Gson gson = new Gson();
		Type type = new TypeToken<Collection<Order>>(){}.getType();
		String orderString = rd.getOrdersJson().getValue();
		Collection<Order> orders = gson.fromJson(orderString, type );
		return orders;
	}
	
	public BigDecimal getTotalSales(String restaurant) {
		Collection<Order> orders = getOrders(restaurant);
		BigDecimal total = new BigDecimal(0.0);
		for(Order order:orders) {
			total = total.add(order.getTotalValue());
		}
		return total;
	}
	
	public Menu getMenu(String restaurant) {
		RestaurantData rd = getRestaurant(restaurant);
		Menu menu = getMenu(rd);
		return menu;
	}
	
	public Menu getMenu(RestaurantData rd)  {
		String menuString = rd.getMenuJson().getValue();
		String restaurantID = "";
		Collection<Meal> meals = new ArrayList<Meal>();
		try {
		    JSONObject jObject  = new JSONObject(menuString);
		    JSONObject menu;
			menu = jObject.getJSONObject("menu");//get the menu
			restaurantID = jObject.get("restaurantId").toString();////get the restaurantID
			
			//get the map of categories (e.g. kebab:type of kebabs available)
			//This is because each restaurant can have different categories 
			//so we have to take the long way round of dynamically dealing with the category json keys, rather than hardcoding (e.g. orders)
		    Map<String,String> categoryMap = new HashMap<String,String>();
		    Iterator menuIterator = menu.keys();
		    while(menuIterator.hasNext()){
		        String key = (String)menuIterator.next();
		        String value = menu.getString(key);
		        categoryMap.put(key,value);
		        
		    }
	        //go through the type of kebabs available and convert them to meals, finally adding 
		    Iterator categoryIterator = categoryMap.entrySet().iterator();
		    while(categoryIterator.hasNext()){
		    	
		    	Entry  category = (Entry) categoryIterator.next();
		    	String categoryKey = category.getKey().toString();
		    	String categoryValues = category.getValue().toString();
		    	
				Gson gson = new Gson();
				Type type = new TypeToken<Collection<Meal>>(){}.getType();
				Collection<Meal> categoryMeals = gson.fromJson(categoryValues, type );
				
			    for(Meal meal : categoryMeals) {
			    	meals.add(meal);
			    }
		    }
			return new Menu(meals, restaurantID);
		    
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}				
	}	
	
	public Collection<Meal> getMeals(String restaurant) {
		Menu menu = getMenu(restaurant);
		Collection<Meal> meals = getMenu(restaurant).getMenu();
		return meals;
	}
	
	public String getMostOrderedCategory(String restaurant) {
		
		Collection<Meal> meals = getMeals(restaurant);
		String mostCommonCategory= "";
		Integer categoryValue= 0;
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(Meal meal:meals) {//get the number of times a category appears
			String category = meal.getCategory();
			if (map.containsKey(category)) {
				Integer val =  map.get(category)+1;
				map.put(category, val);
				
				if (val > categoryValue) {
			    	mostCommonCategory = category;
			    	categoryValue = val;
			    }
				
			}else{
				map.put(category, 1);
			}
		}		
		return mostCommonCategory;
	}
	
}
