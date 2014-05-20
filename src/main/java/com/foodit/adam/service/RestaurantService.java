package com.foodit.adam.service;

import com.foodit.adam.model.Order;
import com.foodit.test.sample.controller.RestaurantData;
import com.google.appengine.labs.repackaged.com.google.common.collect.Lists;
import com.google.common.io.Resources;
import com.google.gson.Gson;
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
import java.net.URL;
import java.util.List;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

import static com.googlecode.objectify.ObjectifyService.ofy;

public class RestaurantService {

	public List<RestaurantData> getRestaurants() {
		return ofy().load().type(RestaurantData.class).list();
	}

	public RestaurantData getRestaurant(String name) {
		return ofy().load().type(RestaurantData.class).filter("restaurant ==", name).list().get(0);
	}

	public List<Order> getOrders(String restaurant) {
		RestaurantData rd = getRestaurant(restaurant);
		List<Order> orders = getOrders(rd);
		return orders;
	}

	public List<Order> getOrders(RestaurantData rd) {
		Gson gson = new Gson();
		Type type = new TypeToken<List<Order>>(){}.getType();
		String orderString = rd.getOrdersJson().getValue();
		List<Order> orders = gson.fromJson(orderString, type );
		return orders;
	}
	
	public double getTotalSales(String restaurant) {
		List<Order> orders = getOrders(restaurant);
		double total = 0;
		for(Order order:orders) {
			total += order.getTotalValue();
		}
		return total;
	}
	
}
