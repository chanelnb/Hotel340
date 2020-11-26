/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import controller.LoginController;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author sogol
 */
public class Main extends Application {
    
    private Stage stage;
    
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        loginWindow();
    }
    
    // login window 
    public void loginWindow() {
        try {
            // view
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("/Views/login.fxml"));
            Parent root = loader.load();
            
            // controller
            LoginController loginController = loader.getController();
            loginController.setMain(this);
            
            //scene on stage
            Scene scene = new Scene(root);    
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
