package io.github.metteo.ws;

import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType
public class User {
	
	public Long id;
	
	@NotNull
	@Size(min = 6, max = 20)
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
