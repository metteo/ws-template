package app;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.ws.BindingProvider;

import io.github.metteo.ws.State;
import io.github.metteo.ws.User;
import io.github.metteo.ws.UserConstants;
import io.github.metteo.ws.UserEndpoint;
import io.github.metteo.ws.UserFaultException;
import io.github.metteo.ws.UserService;

public class UserApp {
	
	private static final Logger logger = Logger.getLogger("UserApp");

	public static void main(String[] args) throws UserFaultException {
		UserService userService = new UserService();
		UserEndpoint userEndpoint = userService.getPort();
		BindingProvider bindingProvider = (BindingProvider) userEndpoint;
		
		String url = "http://localhost:8080/ws/" + UserConstants.SERVICE_NAME;
		bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
		
		logger.info("findAllUsers: " + userEndpoint.findAllUsers());
		
		User user = new User();
		user.name = "John Doe";
		user.state = State.ENABLED;
		
		logger.info("newUser: " + user);
		
		user = userEndpoint.createUser(user);
		
		logger.info("createdUser: " + user);
		
		user.permissions = new ArrayList<>();
		user.permissions.add("CREATE");
		user.permissions.add("UPDATE");
		
		user = userEndpoint.updateUser(user);
		
		logger.info("updatedUser: " + user);
		
		userEndpoint.disableUser(user.id);
		
		logger.info("afterDisable: " + userEndpoint.findAllUsers());
		
		user = userEndpoint.deleteUser(user);
		
		logger.info("afterDelete: " + userEndpoint.findAllUsers());
		
		//trigger exception at the end
		try {
			userEndpoint.deleteUser(null);
		} catch (UserFaultException e) {
			logger.log(Level.SEVERE, "Error during delete: ", e);
		}
		
		//trigger validation exception
		try {
			userEndpoint.createUser(new User());
		} catch (UserFaultException e) {
			logger.log(Level.SEVERE, "Error during create: ", e);
		}
	}

}
