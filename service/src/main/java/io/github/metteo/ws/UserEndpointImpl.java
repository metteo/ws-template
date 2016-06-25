package io.github.metteo.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import javax.annotation.Resource;
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
	
	private AtomicLong mIdGenerator = new AtomicLong();
	private Map<Long, User> mDatabase = new ConcurrentHashMap<>();

	@Override
	public User createUser(User user) throws UserFault {
		assertUser(user);
		
		if (user.id == null) {
			user.id = mIdGenerator.addAndGet(1);
		} else if (mDatabase.containsKey(user.id)) {
			throw new UserFault(new UserFaultDetails(2, "User with id=" + user.id + " already exists"));
		}

		mDatabase.put(user.id, user);
		
		return user;
	}

	private void assertUser(User user) throws UserFault {
		if (user == null) {
			throw new UserFault(new UserFaultDetails(1, "Cannot create null user"));
		}
	}

	@Override
	public User findUser(long id) throws UserFault {
		return mDatabase.get(id);
	}

	@Override
	public List<User> findAllUsers() throws UserFault {
		return new ArrayList<>(mDatabase.values());
	}

	@Override
	public User updateUser(User user) throws UserFault {
		assertUser(user);
		
		if (user.id == null) {
			return null;
		}
		
		mDatabase.put(user.id, user);
		
		return user;
	}

	@Override
	public User deleteUser(User user) throws UserFault {
		assertUser(user);
		
		if (user.id == null) {
			return null;
		}
		
		user = mDatabase.remove(user.id);
		
		return user;
	}
 
	/**
	 * Helper publishing method for quick service startup
	 * @param args
	 */
	public static void main(String[] args) {
		logger.info("Publishing enpoint");
		
		Endpoint.publish("http://localhost:8080/ws/" + UserService.SERVICE_NAME, new UserEndpointImpl());
	}
}