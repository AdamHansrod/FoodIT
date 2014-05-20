package adam.test;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import com.foodit.adam.model.Meal;
import com.foodit.adam.model.MealPopularity;
import com.foodit.adam.service.FoodITService;
import com.foodit.adam.service.FoodITServiceImp;
import com.foodit.test.sample.controller.DataLoadController;
import com.foodit.test.sample.controller.RestaurantData;

public class FoodITServiceTest {
    @Rule
    public SetupAppengine setupAppengine = new SetupAppengine();
    @Rule
    public SetupObjectify setupObjectify = new SetupObjectify(RestaurantData.class);
    
	static final String RESTAURANT_NAME = "bbqgrill";
	static final FoodITService foodITService = new FoodITServiceImp();

	@Before
	public  void setUp() throws Exception {
		DataLoadController dataLoadController = new DataLoadController();
		dataLoadController.load();
		try {
		    Thread.sleep(2000);//make sure the data is written in time otherwise some tests will randomly fail. Silly eventual consistenancy.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
	
	@Test
	public void testGetMostOrderedMeal() {
		Meal meal = foodITService.getMostOrderedMeal(RESTAURANT_NAME);
		assertNotNull(meal);
	}
	@Test
	public void testGetMostOrderedMeals() {
		Collection<Meal> meal = foodITService.getAllPopularMeals();
		assertNotNull(meal);
	}
}
