package controller;

import Main.Main;
import Databases.UserModel;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SignupController implements Initializable{

    //Creates a file for the stored results text file
    
    //creating models 
    UserModel user = new UserModel();
    
    //getting result and pass to database
    
    
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

    
    @FXML
    Button signupButton, loginButton;
    
    private Main main;
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
        if(checkFields())
            //goes to login
        try{
            main.loginWindow();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
