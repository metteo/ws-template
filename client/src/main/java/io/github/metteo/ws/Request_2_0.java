package io.github.metteo.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Request_2_0")
@XmlAccessorType(XmlAccessType.FIELD)
public class Request_2_0 {
	
	public Element_2_0 element;

	@Override
	public String toString() {
		return "Request_2_0 [element=" + element + "]";
	}
}
