package controller;

import Database.MySqlConnector;
import Main.Main;
import Databases.UserModel;
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
import javafx.scene.layout.AnchorPane;
import Database.MySqlConnector;

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
    
    @FXML
    private AnchorPane signupAnchorPane;

    private Main main;
    
    private MySqlConnector mysqlconnector = new MySqlConnector();
    
    private UserModel user;

    //connect main class to controller
    public void setMain(Main main) {
        this.main = main;

    }

    public boolean checkFields(){
        if(firstNameField.getText().isEmpty() || lastNameField.getText().isEmpty() ||
                addressField.getText().isEmpty() || phoneNumberField.getText().isEmpty() ||
                emailField.getText().isEmpty() || usernameField.getText().isEmpty() ||
                passwordField.getText().isEmpty() || passwordConfirmationField.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("One or more fields are empty!");
            alert.showAndWait();

            return false;
        }
        else if(!passwordField.getText().equals(passwordConfirmationField.getText())){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setContentText("Password does not match!");
            alert.showAndWait();   
            
            return false;
        }
        else
            return true;
    }
    
//    public boolean userExist(){
//        //waiting for connector
//        
//        return false;
//    }

    @FXML
    void createUser(ActionEvent event) throws Exception{
        if(checkFields()){
           String fname = firstNameField.getText();
           String lname = lastNameField.getText();
           String address = addressField.getText();
           String phone = phoneNumberField.getText();
           String email = emailField.getText();
           String username = usernameField.getText();
           String password = passwordField.getText();
           
           mysqlconnector.isExist(email);
           mysqlconnector.userExist(fname, lname, address, phone, email, username, password);
        }   
    } 
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
