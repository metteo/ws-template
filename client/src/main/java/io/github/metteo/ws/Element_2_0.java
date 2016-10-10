package io.github.metteo.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Element_2_0", namespace = "http://example.com/schema")
@XmlAccessorType(XmlAccessType.FIELD)
public class Element_2_0 {
	
	@XmlAttribute
	public String value1;
	
	@XmlAttribute
	public String value2;

	@Override
	public String toString() {
		return "Element_2_0 [value1=" + value1 + ", value2=" + value2 + "]";
	}
}
