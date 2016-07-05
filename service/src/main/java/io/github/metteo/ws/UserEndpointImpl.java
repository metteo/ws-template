package io.github.metteo.ws;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import javax.xml.ws.WebServiceContext;

@WebService(
	endpointInterface=UserService.ENDPOINT_INTERFACE,
	serviceName=UserService.SERVICE_NAME, 
	portName=UserService.PORT_NAME, 
	targetNamespace= UserService.SCHEMA_NAMESPACE
)
public class UserEndpointImpl implements UserEndpoint {
	
	private static final Logger logger = Logger.getLogger("UserEndpointImpl");
	
	@Resource
	private WebServiceContext mContext;
	
	@Inject //singleton
	/* package */ UserManager mUserManager;
	
	@Inject @Named("random") //unscoped
	/* package */ Provider<Double> mRandom;
	
	@PostConstruct
	public void inject() {
		logger.info("inject()");
		
		UserComponentProvider.get().inject(this);
	}

	@Override
	public User createUser(User user) throws UserFaultException {
		return mUserManager.createUser(user);
	}

	@Override
	public User findUser(long id) throws UserFaultException {
		return mUserManager.findUser(id);
	}

	@Override
	public List<User> findAllUsers() throws UserFaultException {
		logger.info("Random: " + mRandom);
		return mUserManager.findAllUsers();
	}

	@Override
	public User updateUser(User user) throws UserFaultException {
		return mUserManager.updateUser(user);
	}

	@Override
	public User deleteUser(User user) throws UserFaultException {
		return mUserManager.deleteUser(user);
	}
	
	/**
	 * Helper publishing method for quick service startup
	 * @param args
	 */
	public static void main(String[] args) {
		logger.info("Publishing enpoint");
		
		UserComponentProvider.set(DaggerUserComponent.create());
		
		Endpoint.publish("http://localhost:8080/ws/" + UserService.SERVICE_NAME, new UserEndpointImpl());
	}
}
