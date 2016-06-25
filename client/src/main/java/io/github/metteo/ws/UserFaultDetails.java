package io.github.metteo.ws;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class UserFaultDetails implements Serializable {

	private static final long serialVersionUID = 2837381651976887654L;
	
	public static final String NAME = "io.github.metteo.ws.UserFaultDetails";

	private int code;

	private String message;
	
	public UserFaultDetails() {}
	
	public UserFaultDetails(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + code;
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserFaultDetails other = (UserFaultDetails) obj;
		if (code != other.code)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserFaultBean [code=" + code + ", message=" + message + "]";
	}
}
