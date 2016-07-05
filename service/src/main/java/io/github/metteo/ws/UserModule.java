package io.github.metteo.ws;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {

	@Provides
	@Named("random")
	public static Double provideRandom() {
		return Math.random();
	}
}
