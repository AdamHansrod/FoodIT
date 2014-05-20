package com.foodit.adam.controller;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.foodit.adam.model.Meal;
import com.foodit.adam.model.Order;
import com.foodit.adam.service.FoodITService;
import com.foodit.adam.service.FoodITServiceImp;
import com.foodit.adam.service.RestaurantService;
import com.threewks.thundr.view.json.JsonView;
import com.threewks.thundr.view.jsp.JspView;

public class FoodITController {
	FoodITService fs = new FoodITServiceImp();
    public JsonView viewStats() {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("PopularMeals", fs.getAllPopularMeals());
        return new JsonView(model);
    }
        
}