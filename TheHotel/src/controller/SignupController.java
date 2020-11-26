package controller;

import Main.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SignupController implements Initializable{

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label addressLabel;

    @FXML
    private Label phoneNumberLabel;

    @FXML
    private Label emailLabel;

    @FXML
    private Label usernameLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    private Button createUserButton;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField passwordConfirmationField;

    @FXML
    private Label passwordConfirmationLabel;
    
    private Main main;
    public void setMain(Main main) {
        this.main = main;
    }

    public boolean checkFields(){
        if(firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty() ||
                addressField.getText().isEmpty() || phoneNumberField.getText().isEmpty() ||
                emailField.getText().isEmpty() || usernameField.getText().isEmpty() ||
                passwordField.getText().isEmpty() || passwordConfirmationField.getText().isEmpty()){
            
        }
        return false;
    }
    @FXML
    void createUser(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
