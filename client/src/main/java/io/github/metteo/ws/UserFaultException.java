package io.github.metteo.ws;

import javax.xml.ws.WebFault;

@WebFault(targetNamespace = UserService.SCHEMA_NAMESPACE, faultBean=UserFaultInfo.NAME)
public class UserFaultException extends Exception {

	private static final long serialVersionUID = 7765080042856886265L;
	
	private UserFaultInfo faultInfo;
	
	public UserFaultException(){
		faultInfo = new UserFaultInfo(-1, "");
	}
	
	public UserFaultException(String message) {
		super(message);
		
		faultInfo = new UserFaultInfo(-1, message);
	}
	
	public UserFaultException(Throwable cause) {
		super(cause);
		
		faultInfo = new UserFaultInfo(-1, "");
	}
	
	public UserFaultException(String message, Throwable cause) {
		super(message, cause);

		faultInfo = new UserFaultInfo(-1, message);
	}
	
	public UserFaultException(UserFaultInfo bean){
		super(bean.getMessage());
		
		faultInfo = bean;
	}
	
	public UserFaultException(String message, UserFaultInfo bean){
		super(message);
		
		faultInfo = bean;
	}
	
	public UserFaultException(String message, Throwable cause, UserFaultInfo bean){
		super(message, cause);
		
		faultInfo = bean;
	}

	public UserFaultInfo getFaultInfo() {
		return faultInfo;
	}
}
