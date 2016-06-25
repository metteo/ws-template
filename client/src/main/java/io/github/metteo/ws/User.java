package io.github.metteo.ws;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class User {
	
	public Long id;
	
	public String name;
	
	public State state;

	public User() {}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", state=" + state + "]";
	}
}
