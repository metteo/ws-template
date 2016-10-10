package io.github.metteo.ws;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Element1To2Adapter extends XmlAdapter<Element_1_0, Element_2_0> {

	@Override
	public Element_2_0 unmarshal(Element_1_0 v) throws Exception {
		if (v == null) { return null; }
		
		Element_2_0 result = new Element_2_0();
		result.value1 = v.value1;
		result.value2 = v.value2;
		
		return result;
	}

	@Override
	public Element_1_0 marshal(Element_2_0 v) throws Exception {
		if (v == null) { return null; }
		
		Element_1_0 result = new Element_1_0();
		result.value1 = v.value1;
		result.value2 = v.value2;
		
		return result;
	}

}
