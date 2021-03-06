import com.foodit.adam.service.FoodITService;
import com.foodit.adam.service.FoodITServiceImp;
import com.foodit.adam.service.RestaurantService;
import com.foodit.adam.service.RestaurantServiceImp;
import com.foodit.test.sample.controller.RestaurantData;
import com.googlecode.objectify.ObjectifyService;
import com.threewks.thundr.gae.GaeModule;
import com.threewks.thundr.gae.objectify.ObjectifyModule;
import com.threewks.thundr.injection.BaseModule;
import com.threewks.thundr.injection.UpdatableInjectionContext;
import com.threewks.thundr.module.DependencyRegistry;
import com.threewks.thundr.route.Routes;

public class ApplicationModule extends BaseModule {
	private ApplicationRoutes applicationRoutes = new ApplicationRoutes();

	@Override
	public void requires(DependencyRegistry dependencyRegistry) {
		super.requires(dependencyRegistry);
		dependencyRegistry.addDependency(GaeModule.class);
		dependencyRegistry.addDependency(ObjectifyModule.class);
	}

	@Override
	public void configure(UpdatableInjectionContext injectionContext) {
		super.configure(injectionContext);
		configureObjectify();
		configureServicesInjection(injectionContext);
	}

	@Override
	public void start(UpdatableInjectionContext injectionContext) {
		super.start(injectionContext);
		Routes routes = injectionContext.get(Routes.class);
		applicationRoutes.addRoutes(routes);
	}

	private void configureObjectify() {
		ObjectifyService.register(RestaurantData.class);
	}
	private void configureServicesInjection(UpdatableInjectionContext injectionContext) {
		injectionContext.inject(FoodITServiceImp.class).as(FoodITService.class);
		injectionContext.inject(RestaurantServiceImp.class).as(RestaurantService.class);
	}
}
