package controller;

import Main.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Model.Usermodel;


public class LoginController implements Initializable{

    @FXML
    private Button SignInButton;

    @FXML
    private Button SignUpButton;

    @FXML
    private Label UsernameLabel;

    @FXML
    private Label PasswordLabel;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;
    
    
    private Main main;
    
    
    //connect main class to controller
    public void setMain(Main main) {
        this.main = main;
        
    }
    public boolean checkFields(){
        if(usernameField.getText().isEmpty() || passwordField.getText().isEmpty()){
            return false;
        }
        else{
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
        if(checkFields()){
            main.searchWindow();
       
    }
    }
    /**
     * Initializes the controller class.
     */
   
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
    }
}
    

