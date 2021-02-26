package it.engineering.tasker.web.context;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import it.engineering.tasker.app.repository.impl.UserRepositoryImpl;
import it.engineering.tasker.app.service.UserService;
import it.engineering.tasker.app.service.impl.UserServiceImpl;
import it.engineering.tasker.common.exception.UserException;
import it.engineering.tasker.common.model.User;

@WebListener("Component Configuration")
public class StartupContext implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		UserService userService = new UserServiceImpl(new UserRepositoryImpl());
		try {
			userService.save(new User(1, "Admin", "admin", "admin"));
			userService.save(new User(2, "John Doe", "john", "john"));
		} catch (UserException e) {
			e.printStackTrace();
		}
		// User service registration
		sce.getServletContext().setAttribute("userService", userService);

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
	}

}
