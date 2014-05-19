

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.foodit.adam.model.Order;
import com.foodit.adam.service.RestaurantService;
import com.foodit.test.sample.controller.RestaurantData;

public class RestaurantServiceTest {
	static final String RESTAURANT_NAME = "bbqgrill";
	RestaurantService restaurantService;

	@Before
	public void setUp() throws Exception {
		restaurantService = new RestaurantService();
	}

	@Test
	public void testRetrievingAllRestarurants() {
		List<RestaurantData> rd = restaurantService.getRestaurants();
		assertNotNull(restaurantService.getRestaurants());
		assertTrue(rd.size() > 0);
	}
	
	@Test
	public void testRetrievingARestarurant() {
		RestaurantData restaurant = restaurantService.getRestaurant(RESTAURANT_NAME);
		assertNotNull(restaurant);
		assertTrue(restaurant.getRestaurant().equals(RESTAURANT_NAME));
	}

	@Test
	public void testGetOrders() {
		List<Order> orders = restaurantService.getOrders(RESTAURANT_NAME);
		assertNotNull(orders);
		assertTrue(orders.size() > 0);
	}

}
