package org.wiztools.restclient.ui.reqauth;

import java.util.List;

import org.wiztools.restclient.bean.Auth;
import org.wiztools.restclient.ui.ViewPanel;

import com.google.inject.ImplementedBy;

/**
 *
 * @author subwiz
 */
@ImplementedBy(ReqAuthPanelImplWithCustomAuthSupport.class)
public interface ReqAuthPanel extends ViewPanel {

	void setAuth(Auth auth);
	Auth getAuth();
	List<String> validateIfFilled();
}
