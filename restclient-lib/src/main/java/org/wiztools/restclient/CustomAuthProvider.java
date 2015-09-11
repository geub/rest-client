package org.wiztools.restclient;

import java.util.Collection;

import org.wiztools.restclient.CustomAuthInstallerModule.CustomAuth;

public interface CustomAuthProvider {

	Collection<Class<? extends CustomAuth>> getCustomAuthClasses();
}
