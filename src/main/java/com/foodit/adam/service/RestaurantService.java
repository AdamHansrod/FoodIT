package com.foodit.adam.service;

import com.foodit.adam.model.Meal;
import com.foodit.adam.model.Menu;
import com.foodit.adam.model.Order;
import com.foodit.adam.tools.*;
import com.foodit.test.sample.controller.RestaurantData;
import com.google.appengine.api.datastore.Category;
import com.google.appengine.labs.repackaged.com.google.common.collect.Lists;
import com.google.appengine.labs.repackaged.org.json.JSONException;
import com.google.appengine.labs.repackaged.org.json.JSONObject;
import com.google.cloud.sql.jdbc.GoogleDataSource;
import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.googlecode.objectify.Key;
import com.threewks.thundr.http.ContentType;
import com.threewks.thundr.http.HttpSupport;
import com.threewks.thundr.logger.Logger;
import com.threewks.thundr.view.jsp.JspView;
import com.threewks.thundr.view.string.StringView;

import org.apache.commons.io.IOUtils;

import javax.naming.ldap.Rdn;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Array;
import java.lang.reflect.Type;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class RestaurantService {

	public List<RestaurantData> getRestaurants() {
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
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(Meal meal:meals) {//get the number of times a category appears
			String category = meal.getCategory();
			if (map.containsKey(category)) {
				map.put(category, map.get(category)+1 );
			}else{
				map.put(category, 1);
			}
		}
		Iterator it = map.entrySet().iterator();
		String mostCommonCategory= "";
		Integer categoryValue= 0;
		while (it.hasNext()) {//work out which most commonly appears		    
	    	String  key = (String)  it.next();
		    Integer val = (Integer) map.get(key);
		    if (val > categoryValue) {
		    	mostCommonCategory = key;
		    	categoryValue = val;
		    }
		}
		return mostCommonCategory;
	}
	
}
