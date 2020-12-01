package controller;

import Main.Main;
import Databases.UserModel;
import Database.MySqlConnector;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController implements Initializable {

    @FXML
    private Button SignInButton;

    @FXML
    private Button SignUpButton;

    @FXML
    private Label UsernameLabel;

    @FXML
    private Label PasswordLabel;

    @FXML
    private PasswordField loginPasswordField;

    @FXML
    private TextField loginUsernameField;

    private Main main;
    
    private MySqlConnector mysqlconnector = new MySqlConnector();
    
    private UserModel user;

    //connect main class to controller
    public void setMain(Main main) {
        this.main = main;

    }

    public boolean checkFields() {
        if (loginUsernameField.getText().isEmpty() || loginPasswordField.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("One or more fields are empty!");
            alert.showAndWait();
            return false;
        } else {
            return true;
        }
    }

    //when this method is called it goes to sign up page
    @FXML
    void goesToSignUp(ActionEvent event) throws IOException {
        main.signUpWindow();
    }

    @FXML
    void signsIn(ActionEvent event) throws IOException {
        if (checkFields()) { // if everything is ok it will go to home window     
        
            String username = loginUsernameField.getText();
            String password = loginPasswordField.getText();
           
           mysqlconnector.checkUser(username, password);
         
        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
