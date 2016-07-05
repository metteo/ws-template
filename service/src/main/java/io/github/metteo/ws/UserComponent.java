package io.github.metteo.ws;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules=UserModule.class)
public interface UserComponent {
	void inject(UserEndpointImpl target);
}
