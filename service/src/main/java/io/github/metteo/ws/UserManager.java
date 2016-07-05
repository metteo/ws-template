package io.github.metteo.ws;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class UserManager {

	private AtomicLong mIdGenerator = new AtomicLong();
	private Map<Long, User> mDatabase = new ConcurrentHashMap<>();
	
	@Inject
	public UserManager() {
		
	}

	public User createUser(User user) throws UserFaultException {
		assertUser(user);
		
		if (user.id == null) {
			user.id = mIdGenerator.addAndGet(1);
		} else if (mDatabase.containsKey(user.id)) {
			throw new UserFaultException(new UserFaultInfo(2, "User with id=" + user.id + " already exists"));
		}

		mDatabase.put(user.id, user);
		
		return user;
	}

	private void assertUser(User user) throws UserFaultException {
		if (user == null) {
			throw new UserFaultException(new UserFaultInfo(1, "User parameter cannot be null"));
		}
	}

	public User findUser(long id) throws UserFaultException {
		return mDatabase.get(id);
	}

	public List<User> findAllUsers() throws UserFaultException {
		return new ArrayList<>(mDatabase.values());
	}

	public User updateUser(User user) throws UserFaultException {
		assertUser(user);
		
		if (user.id == null) {
			return null;
		}
		
		mDatabase.put(user.id, user);
		
		return user;
	}

	public User deleteUser(User user) throws UserFaultException {
		assertUser(user);
		
		if (user.id == null) {
			return null;
		}
		
		user = mDatabase.remove(user.id);
		
		return user;
	}
}
