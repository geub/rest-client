package org.wiztools.restclient;

import java.awt.Component;
import java.util.List;
import java.util.ServiceLoader;

import org.wiztools.restclient.bean.Auth;
import org.wiztools.restclient.bean.Request;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;


public class CustomAuthInstallerModule extends AbstractModule {

	@Override
	protected void configure() {
		Multibinder<CustomAuth> binder = Multibinder.newSetBinder(binder(), CustomAuth.class);
		for (CustomAuthProvider provider : ServiceLoader.load(CustomAuthProvider.class)) {
			for (Class<? extends CustomAuth> clazz : provider.getCustomAuthClasses()) {
				binder.addBinding().to(clazz);
			}
		}
	}

	public static interface CustomAuth extends Auth {

		String getName();

		Component getFormInputView();

		void configureRequest(Request request);

		List<String> getFormInputValidationMessages();
	}
}
