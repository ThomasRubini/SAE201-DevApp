
package fr.univ_amu.iut.loginPrompt;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    private PasswordField password;

    @FXML
    private Button log;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        
        EventHandler<ActionEvent> handleLogin = event ->{
            // TODO Use SecretProvider
            System.out.println(password.getText());
        };
        log.setOnAction(handleLogin);
        
    }

}
