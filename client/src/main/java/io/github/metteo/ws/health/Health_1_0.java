package io.github.metteo.ws.health;

import java.util.List;

import javax.xml.bind.annotation.XmlType;

@XmlType(name = "Health_1_0")
public class Health_1_0 {
	
	public static enum Status_1_0 {
		/**
		 * status is not known
		 * color: white/transparent
		 */
		UNKNOWN, 
		/**
		 * no errors during health check execution
		 * color: gray (NOT green)
		 */
		PASSING, 
		/**
		 * some errors but not preventing from functioning, e.g. empty cache?
		 * or if the duration passed a threshold
		 * color: orange
		 */
		WARNING, 
		/**
		 * critical errors, unable to function properly
		 * color: red
		 */
		CRITICAL
	}

	Component_1_0 component;
	
	Status_1_0 status;
	
	/**
	 * Latency, how long it took
	 */
	Long duration;
	
	List<Health_1_0> dependencies;
}
