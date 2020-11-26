package controller;

import Main.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LoginController implements Initializable{

    @FXML
    private Button SignInButton;

    @FXML
    private Button SignUpButton;

    @FXML
    private Label UsernameLabel;

    @FXML
    private Label PasswordLabel;

    private Main main;
    
    //connect main class to controller
    public void setMain(Main main) {
        this.main = main;
    }
    //when this method is called it goes to sign up page
    @FXML
    void goesToSignUp(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/Views/signup.fxml"));
        Parent signupParent = loader.load();
            
        Scene signupScene = new Scene(signupParent);
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(signupScene);
        window.show();
    }

    @FXML
    void signsIn(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("/Views/signup.fxml"));
        Parent signinParent = loader.load();
        
        Scene signinScene = new Scene(signinParent);

                
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(signinScene);
        window.show();
    }
    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
