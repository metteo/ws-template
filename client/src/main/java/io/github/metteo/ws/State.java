package io.github.metteo.ws;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum(String.class)
public enum State {
	/**
	 * User account is enabled
	 */
	ENABLED, 
	/**
	 * User account is disabled
	 */
	DISABLED;
}
