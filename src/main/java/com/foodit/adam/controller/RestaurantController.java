package com.foodit.adam.controller;


import java.util.HashMap;
import java.util.Map;

import com.foodit.adam.service.RestaurantService;
import com.foodit.adam.service.RestaurantServiceImp;
import com.threewks.thundr.view.json.JsonView;

public class RestaurantController {
	RestaurantService rs = new RestaurantServiceImp();
    public JsonView viewStats(String restaurant) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("mostPopularCategory", rs.getMostOrderedCategory(restaurant));
        return new JsonView(model);
    }
    public JsonView viewSaleTotal(String restaurant) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("totalSales", rs.getTotalSales(restaurant));
        return new JsonView(model);
    }
    public JsonView viewOrderTotal(String restaurant) {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("totalOrders", rs.getOrders(restaurant).size());
        return new JsonView(model);
    }

}