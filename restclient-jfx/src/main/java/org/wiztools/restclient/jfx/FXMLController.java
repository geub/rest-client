package org.wiztools.restclient.jfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class FXMLController implements Initializable {
    
    @FXML
    private ComboBox urlCombo;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        urlCombo.setValue("http://www.wiztools.org/");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
