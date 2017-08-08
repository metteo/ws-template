package io.github.metteo.ws.health;

public interface HealthEndpoint_1_0 {

	/**
	 * Doesn't tell if everything is ok. Instead tells if sth (from areas that are checked) is wrong
	 * 
	 * AppDynamics iQ Microservices instrumentation
	 */
	Health_1_0 getHealth_1_0(String caller, HealthParams_1_0 params);
	
}
