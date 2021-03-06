import com.foodit.adam.controller.FoodITController;
import com.foodit.adam.controller.RestaurantController;
import com.foodit.test.sample.controller.DataLoadController;
import com.threewks.thundr.action.method.MethodAction;
import com.threewks.thundr.route.Route;
import com.threewks.thundr.route.Routes;

import static com.threewks.thundr.route.RouteType.GET;

public class ApplicationRoutes {
	public static class Names {
		public static final String ListTasks = "list";
		public static final String CreateTask = "create-task";
		public static final String ViewTask = "view-task";
		public static final String UpdateTask = "update-task";
		public static final String StartTask = "start-task";
		public static final String StopTask = "stop-task";
		public static final String FinishedTask = "finished-task";
		public static final String ArchiveTask = "archive-task";

		public static final String LoadData = "load-data";

		public static final String ViewInstructions = "view-instructions";
		public static final String ViewData = "view-data";
	}

	public void addRoutes(Routes routes) {

		// Loader
		routes.addRoute(new Route(GET, "/load/", Names.LoadData), new MethodAction(DataLoadController.class, "load"));

		// Instructions
		routes.addRoute(new Route(GET, "/", Names.ViewInstructions), new MethodAction(DataLoadController.class, "instructions"));
		routes.addRoute(new Route(GET, "/restaurant/{restaurant}/download", Names.ViewData), new MethodAction(DataLoadController.class, "viewData"));
		
		//get restaurants total orders, but call it order in-case we ever want to restfully get/post orders individually
		routes.addRoute(new Route(GET, "/restaurant/{restaurant}/order/total", null), new MethodAction(RestaurantController.class, "viewOrderTotal"));
		//get restaurants total sales, but call it sale in-case we ever want to restfully get/post a sale individually
		routes.addRoute(new Route(GET, "/restaurant/{restaurant}/sale/total", null), new MethodAction(RestaurantController.class, "viewSaleTotal"));
		//get restaurants stats GET stats POST stats? sounds pretty nifty. #getstatspoststats
		routes.addRoute(new Route(GET, "/restaurant/{restaurant}/stats", null), new MethodAction(RestaurantController.class, "viewStats"));	

		//get foodit stats
		routes.addRoute(new Route(GET, "/foodit/stats", null), new MethodAction(FoodITController.class, "viewStats"));	

	}
}
