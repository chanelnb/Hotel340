package controller;

import Main.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *model for users 
 * 
 * last update 12/01/20
 * 
 * @author chanel
 */

public class HomeScreenController implements Initializable {
    
    private Main main;
    
    
    //connect main class to controller
    public void setMain(Main main) {
        this.main = main;
        
    }
    
     @FXML
    void signIn(ActionEvent event) throws IOException {   
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/Views/login.fxml"));
                       
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show(); 
    }
    
     @FXML
    void goesToReservation(ActionEvent event) throws IOException {   
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/Views/reservation.fxml"));
                       
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show(); 
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}







