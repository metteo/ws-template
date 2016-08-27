package app;

import io.github.metteo.ws.State;
import io.github.metteo.ws.User;
import io.github.metteo.ws.UserConstants;
import io.github.metteo.ws.UserEndpointAsync;
import io.github.metteo.ws.UserFaultException;
import io.github.metteo.ws.UserService;
import io.github.metteo.ws.jaxws.FindAllUsersResponse;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.ws.AsyncHandler;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Response;

public class UserAppAsync {
	
	private static final Logger logger = Logger.getLogger("UserApp");

	public static void main(String[] args) throws UserFaultException, InterruptedException, ExecutionException {
		UserService userService = new UserService();
		UserEndpointAsync userEndpoint = userService.getAsyncPort();
		BindingProvider bindingProvider = (BindingProvider) userEndpoint;
		
		String url = "http://localhost:8080/ws/" + UserConstants.SERVICE_NAME;
		bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, url);
		
		User user = new User();
		user.name = "Jane Doe";
		user.state = State.DISABLED;
		
		logger.info("newUser: " + user);
		
		user = userEndpoint.createUser(user);
		
		logger.info("findAllUsersAsync1: " + userEndpoint.findAllUsersAsync().get().getReturn());
		
		Future<?> future = userEndpoint.findAllUsers(new AsyncHandler<FindAllUsersResponse>() {
			
			@Override
			public void handleResponse(Response<FindAllUsersResponse> res) {
				try {
					logger.info("findAllUsersAsync2: " + res.get().getReturn());
				} catch (InterruptedException | ExecutionException e) {
					logger.log(Level.WARNING, "", e);
				}
			}
		});
		
		//while(!future.isDone()){
			Thread.sleep(1000); //simulate app still running
	    //}
			
		logger.info("UserAppAsync exited");
	}

}
