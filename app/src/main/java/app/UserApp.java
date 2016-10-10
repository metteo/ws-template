package app;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.ws.BindingProvider;

import io.github.metteo.ws.Element_2_0;
import io.github.metteo.ws.Priority;
import io.github.metteo.ws.Request_1_0;
import io.github.metteo.ws.Request_2_0;
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
		user.priority = Priority.HIGH;
		
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
			User u = new User();
			u.setType("NOT_FROM_ENUM");
			userEndpoint.createUser(u);
		} catch (UserFaultException e) {
			logger.log(Level.SEVERE, "Error during create: ", e);
		}
		
		//Compatibility using @XmlAdapter
		
		Element_2_0 el2 = new Element_2_0();
		el2.value1 = "val1";
		el2.value2 = "val2";
		
		Request_1_0 req1 = new Request_1_0();
		req1.element = el2;
		
		Request_2_0 req2 = new Request_2_0();
		req2.element = el2;

		logger.info("Req1 before: " + req1);
		req1 = userEndpoint.echo_1_0(req1);
		logger.info("Req1 after: " + req1);
		
		logger.info("Req2 before: " + req2);
		req2 = userEndpoint.echo_2_0(req2);
		logger.info("Req2 after: " + req2);
	}

}
