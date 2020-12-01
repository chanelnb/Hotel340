/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import controller.SignupController;
import controller.SearchController;
import controller.LoginController;
import controller.HomeScreenController;
import controller.ReservationController;
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
            AnchorPane login = (AnchorPane)loader.load();
            
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
    
    // home window
    public void homeWindow() {
        try {
            // view
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/Views/HomeScreen.fxml"));
            AnchorPane home = (AnchorPane) loader.load();
            
            // controller
            HomeScreenController homeController = loader.getController();
            homeController.setMain(this);
            
            //scene on stage
            Scene scene = new Scene(home);    
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // reservation window
    public void reservationWindow() {
        try {
            // view
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/Views/reservation.fxml"));
            AnchorPane reservation = (AnchorPane) loader.load();
            
            // controller
            ReservationController reservationController = loader.getController();
            reservationController.setMain(this);
            
            //scene on stage
            Scene scene = new Scene(reservation);    
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
