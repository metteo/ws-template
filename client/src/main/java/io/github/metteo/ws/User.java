package io.github.metteo.ws;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({UserType.class})
public class User {
	
	public Long id;
	
	@NotNull
	@Size(min = 6, max = 20)
	public String name;
	
	public State state;
	
	@XmlElement
	@XmlElementEnum(UserType.class)
	private String type;
	
	@XmlElement(name = "permission")
	@XmlElementWrapper
	public List<String> permissions;

	public User() {}

	public UserType getType() {
		if (type == null) { return null; }
		
		return UserType.valueOf(type);
	}

	public void setType(UserType type) {
		if (type == null) { this.type = null; }
		
		this.type = type.name();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", state=" + state
				+ ", type=" + type + ", permissions=" + permissions + "]";
	}
}
