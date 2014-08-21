package org.wiztools.restclient;

import java.util.Set;

import org.reflections.Reflections;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;


public class CustomAuthInstallerModule extends AbstractModule {

	@Override
	protected void configure() {
		Multibinder<CustomAuth> binder = Multibinder.newSetBinder(binder(), CustomAuth.class);
		Reflections reflections = new Reflections("br.com.softplan.unj");
		Set<Class<? extends CustomAuth>> customAuths = reflections.getSubTypesOf(CustomAuth.class);
		for (Class<? extends CustomAuth> customAuthClass : customAuths) {
			binder.addBinding().to(customAuthClass);
		}
	}

}
