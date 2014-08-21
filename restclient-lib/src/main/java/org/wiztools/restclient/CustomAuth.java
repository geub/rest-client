package org.wiztools.restclient;

import java.awt.Component;
import java.util.List;

import org.wiztools.restclient.bean.Auth;
import org.wiztools.restclient.bean.Request;


public interface CustomAuth extends Auth {

	String getName();

	Component getFormInputView();

	void configureRequest(Request request);

	List<String> getFormInputValidationMessages();

}
