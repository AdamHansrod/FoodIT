package adam.test;


import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import com.foodit.adam.model.Meal;
import com.foodit.adam.model.Menu;
import com.foodit.adam.model.Order;
import com.foodit.adam.service.RestaurantService;
import com.foodit.test.sample.controller.DataLoadController;
import com.foodit.test.sample.controller.RestaurantData;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

public class RestaurantServiceTest {

    @Rule
    public SetupAppengine setupAppengine = new SetupAppengine();
    @Rule
    public SetupObjectify setupObjectify = new SetupObjectify(RestaurantData.class);
	
	static final String RESTAURANT_NAME = "bbqgrill";
	RestaurantService restaurantService;

	@Before
	public void setUp() throws Exception {
		DataLoadController dataLoadController = new DataLoadController();
		dataLoadController.load();
		restaurantService = new RestaurantService();
		try {
		    Thread.sleep(2000);//make sure the data is written in time otherwise some tests will randomly fail. Silly eventual consistenancy.
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}

	@Test
	public void testRetrievingAllRestarurants() {
		List<RestaurantData> rd = restaurantService.getRestaurants();
		assertNotNull(restaurantService.getRestaurants());
		assertTrue(rd.size() >= 0);
	}
	
	@Test
	public void testRetrievingARestarurant() {
		RestaurantData restaurant = restaurantService.getRestaurant(RESTAURANT_NAME);
		assertNotNull(restaurant);
		assertTrue(restaurant.getRestaurant().equals(RESTAURANT_NAME));
	}

	@Test
	public void testGetOrders() {
		Collection<Order> orders = restaurantService.getOrders(RESTAURANT_NAME);
		assertNotNull(orders);
		assertTrue(orders.size() > 0);
	}
	
	@Test
	public void testGetTotalSales() {
		BigDecimal total = restaurantService.getTotalSales(RESTAURANT_NAME);
		assertTrue(total.intValue() > 0);
	}
	
	@Test
	public void testGetMenu() {
		Menu menu = restaurantService.getMenu(RESTAURANT_NAME);
		assertNotNull(menu);
	}
	
	@Test
	public void testGetMeals() {
		Collection<Meal> meal = restaurantService.getMeals(RESTAURANT_NAME);
		assertNotNull(meal);
	}
}
