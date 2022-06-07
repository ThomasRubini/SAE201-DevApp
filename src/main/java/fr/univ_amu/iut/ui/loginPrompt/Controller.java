
package fr.univ_amu.iut.ui.loginPrompt;

import fr.univ_amu.iut.secret.SecretProvider;
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
            if(SecretProvider.getInstance().isSecretValid(password.getText())){
                System.out.println("Mot de passe OK !");
            }else{
                System.out.println("Mot de passe invalide");
            }
        };
        log.setOnAction(handleLogin);
    }
}
