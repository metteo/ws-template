package io.github.metteo.ws;

public class UserComponentProvider {

	private static UserComponent sInstance;
	
	public static UserComponent get() {
		return sInstance;
	}
	
	public static void set(UserComponent instance) {
		sInstance = instance;
	}
}
