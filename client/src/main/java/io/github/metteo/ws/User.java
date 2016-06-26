package io.github.metteo.ws;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class User {
	
	public Long id;
	
	public String name;
	
	public State state;
	
	@XmlElement(name = "permission")
	@XmlElementWrapper
	public List<String> permissions;

	public User() {}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", state=" + state
				+ ", permissions=" + permissions + "]";
	}
}
