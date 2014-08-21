package org.wiztools.restclient.ui.reqauth;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

import org.wiztools.restclient.CustomAuth;
import org.wiztools.restclient.bean.Auth;

import com.google.inject.Inject;


public class ReqAuthPanelImplWithCustomAuthSupport extends ReqAuthPanelImpl {

	@Inject(optional = true)
	private Set<CustomAuth> customAuths;

	@Override
	@PostConstruct
	protected void init() {
		super.init();
		configureCustomAuths();
	}

	@Override
	public List<String> validateIfFilled() {
		for (CustomAuth customAuth : this.customAuths) {
			if (customAuth.getName().equals(getJcbTypes().getSelectedItem())) {
				return customAuth.getFormInputValidationMessages();
			}
		}
		return super.validateIfFilled();
	}

	private void configureCustomAuths() {
		if (this.customAuths == null) {
			return;
		}
		JComboBox<String> jcb_types = getJcbTypes();
		for (CustomAuth customAuth : this.customAuths) {
			jcb_types.addItem(customAuth.getName());
		}
		bindCustomAuthFormView(jcb_types);
	}

	private void bindCustomAuthFormView(final JComboBox<String> jcb_types) {
		jcb_types.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Auth auth = getAuth();
				if (auth instanceof CustomAuth) {
					JScrollPane jsp = (JScrollPane) ReqAuthPanelImplWithCustomAuthSupport.this.getComponent(1);
					jsp.setViewportView(((CustomAuth) auth).getFormInputView());
				}
			}
		});
	}

	@Override
	public Auth getAuth() {
		Auth auth = super.getAuth();
		if (auth != null) {
			return auth;
		}
		JComboBox<String> jcb_types = getJcbTypes();
		for (CustomAuth customAuth : this.customAuths) {
			if (customAuth.getName().equals(jcb_types.getSelectedItem())) {
				return customAuth;
			}
		}
		return null;
	}


	@SuppressWarnings("unchecked")
	private JComboBox<String> getJcbTypes() {
		return (JComboBox<String>) getComponent(0);
	}
}
