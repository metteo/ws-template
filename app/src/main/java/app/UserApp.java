package app;

import javax.xml.ws.BindingProvider;

import io.github.metteo.ws.State;
import io.github.metteo.ws.User;
import io.github.metteo.ws.UserEndpoint;
import io.github.metteo.ws.UserFault;
import io.github.metteo.ws.UserService;

public class UserApp {

	public static void main(String[] args) throws UserFault {
		UserService userService = new UserService();
		UserEndpoint userEndpoint = userService.getPort();
		BindingProvider bindingProvider = (BindingProvider) userEndpoint;
		
		String url = "http://localhost:8080/ws/" + UserService.SERVICE_NAME;
		bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
		
		System.out.println(userEndpoint.findAllUsers());
		
		User user = new User();
		user.name = "John Doe";
		user.state = State.ENABLED;
		
		System.out.println(user);
		
		user = userEndpoint.createUser(user);
		
		System.out.println(user);
		
		user.state = State.DISABLED;
		
		user = userEndpoint.updateUser(user);
		
		System.out.println(user);
		
		user = userEndpoint.deleteUser(user);
		
		System.out.println(userEndpoint.findAllUsers());
	}

}
