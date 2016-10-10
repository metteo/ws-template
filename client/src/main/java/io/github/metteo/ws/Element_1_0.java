package io.github.metteo.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Element_1_0")
@XmlAccessorType(XmlAccessType.FIELD)
public class Element_1_0 {
	
	public String value1;
	public String value2;
	
	@Override
	public String toString() {
		return "Element_1_0 [value1=" + value1 + ", value2=" + value2 + "]";
	}
}
