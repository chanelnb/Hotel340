package controller;
/**
 *model for users 
 * 
 * last update 11/30/20
 * 
 * @author amad
 * @author chanel
 */
import Main.Main;
import Databases.UserModel;
import Databases.MySqlConnector;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML LoginController class
 *
 * @author chanel
 * @author amad
 * 
 */
public class LoginController implements Initializable {

    @FXML
    private PasswordField loginPasswordField;

    @FXML
    private TextField loginUsernameField;

    private Main main;
    
    private MySqlConnector mysqlconnector = new MySqlConnector();
    
    private UserModel user;
    
    public static String username;

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
        try {
            // view
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/Views/signup.fxml"));
                       
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void signsIn(ActionEvent event) throws IOException {
        if (checkFields()) { // if everything is ok it will go to home window     
        
            username = loginUsernameField.getText();
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
