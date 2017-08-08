package io.github.metteo.ws.health;

public class HealthParams_1_0 {

	// 4 levels: TODO: refine
	// basic / simple - be like getVersion: local=true, deps=false;
	// basic deps - describe deps without checking their status: local=true, deps=true;
	// adv deps - describe deps and their basic status (getVersion): local=false, deps=false;
	// traverse - check status of deps and their deps: local=false, deps=true;
	
	boolean local;
	
	boolean dependencies;
	
	String path; //every services adds itself before traversing - cycle detection
	// e.g. /comp-1/comp-2/comp-3/comp-2 <- CYCLE, should not happen
	// what about services that call different instance of itself
	
}
