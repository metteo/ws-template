package io.github.metteo.ws.health;

import java.util.List;

public class Component_1_0 {
	
	public static enum Type_1_0 {
		SERVICE,
		
		EXTERNAL_SERVICE, // for exit points / proxies
		
		DATABASE, // no / sql
		
		CACHE,
		
		MESSAGE_QUEUE,
		
		MESSAGE_BUS,
		
		/*admin*/ BUS,
		
		STORAGE,
		
		MEMORY,
		
		CPU_LOAD
	}
	
	String tag; //for services 'source'? like comp-1
	String name; //e.g. display name? 'Component #1'
	Type_1_0 type;
	String description;
	List<String> owners;
	String version;
	boolean traversable;
	
	//APP_* - tpz component specific? or just 'source'
	String host;
	String env;
	String instance;
	String appName;
	
	//service check: either getVersion or getHealth
	//db check: select 1;
	//cache: return error if empty
	//mq: connection active
	//mb: connection active
	//bus: connection active
	//storage: more than 10% of free space?
	//memory: more than 10% of free memory?
	//load: less than 3 (*nix load)
	
	
}
