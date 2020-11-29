/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import controller.SignupController;
import controller.SearchController;
import controller.LoginController;
import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;


/**
 *
 * @author sogol
 * @author Chanel
 * 
 */
public class Main extends Application {
    
    private Stage stage;
    private AnchorPane signup;
    
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        loginWindow();
        
    }
    
    // login window 
    public void loginWindow() {
        try {
            // view
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/Views/login.fxml"));
            AnchorPane login = (AnchorPane) loader.load();
            
            // controller
            LoginController loginController = loader.getController();
            loginController.setMain(this);
            
            //scene on stage
            Scene scene = new Scene(login);    
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // signup window 
    public void signUpWindow() {
        try {
            // view
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/Views/signup.fxml"));
            AnchorPane signup = (AnchorPane) loader.load();
            
            // controller
            SignupController signUpController = loader.getController();
            signUpController.setMain(this);
            
            //scene on stage
            Scene scene = new Scene(signup);    
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // search window 
    public void searchWindow() {
        try {
            // view
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/Views/search.fxml"));
            AnchorPane search = (AnchorPane) loader.load();
            
            // controller
            SearchController searchController = loader.getController();
            searchController.setMain(this);
            
            //scene on stage
            Scene scene = new Scene(search);    
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