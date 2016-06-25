package io.github.metteo.ws;

import javax.xml.ws.WebFault;

@WebFault(targetNamespace = UserService.SCHEMA_NAMESPACE, faultBean=UserFaultDetails.NAME)
public class UserFault extends Exception {

	private static final long serialVersionUID = 7765080042856886265L;
	
	private UserFaultDetails details;
	
	public UserFault(){
		details = new UserFaultDetails(-1, "");
	}
	
	public UserFault(String message) {
		super(message);
		
		details = new UserFaultDetails(-1, message);
	}
	
	public UserFault(Throwable cause) {
		super(cause);
		
		details = new UserFaultDetails(-1, "");
	}
	
	public UserFault(String message, Throwable cause) {
		super(message, cause);

		details = new UserFaultDetails(-1, message);
	}
	
	public UserFault(UserFaultDetails bean){
		super(bean.getMessage());
		
		details = bean;
	}
	
	public UserFault(String message, UserFaultDetails bean){
		super(message);
		
		details = bean;
	}
	
	public UserFault(String message, Throwable cause, UserFaultDetails bean){
		super(message, cause);
		
		details = bean;
	}

	public UserFaultDetails getDetails() {
		return details;
	}
}
