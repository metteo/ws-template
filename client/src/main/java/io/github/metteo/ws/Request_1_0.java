package io.github.metteo.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlType(name = "Request_1_0")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Element_1_0.class})
public class Request_1_0 {
	
	@XmlJavaTypeAdapter(Element1To2Adapter.class)
	public Element_2_0 element;

	@Override
	public String toString() {
		return "Request_1_0 [element=" + element + "]";
	}
}
