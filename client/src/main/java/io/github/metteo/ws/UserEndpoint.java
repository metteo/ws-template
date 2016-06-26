package io.github.metteo.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Action;

@SOAPBinding
@WebService(targetNamespace=UserService.SCHEMA_NAMESPACE)
public interface UserEndpoint {

	/**
	 * Creates new user
	 * 
	 * @param user
	 * @return
	 * @throws UserFaultException
	 */
	@WebMethod
	@WebResult
	@Action
	User createUser(
			@WebParam(name = "user") User user
	) throws UserFaultException;
	
	/**
	 * Returns a user with a given id
	 * 
	 * @param id
	 * @return
	 * @throws UserFaultException
	 */
	@WebMethod
	@WebResult
	@Action
	User findUser(
			@WebParam(name = "id") long id
	) throws UserFaultException;
	
	/**
	 * Returns all users
	 * 
	 * @return
	 * @throws UserFaultException
	 */
	@WebMethod
	@WebResult
	@Action
	List<User> findAllUsers() throws UserFaultException;
	
	/**
	 * Updates the user
	 * 
	 * @param user
	 * @return
	 * @throws UserFaultException
	 */
	@WebMethod
	@WebResult
	@Action
	User updateUser(
			@WebParam(name = "user") User user
	) throws UserFaultException;
	
	/**
	 * Deletes the user
	 * @param user
	 * @return
	 * @throws UserFaultException
	 */
	@WebMethod
	@WebResult
	@Action
	User deleteUser(
			@WebParam(name = "user") User user
	) throws UserFaultException;
	
}
