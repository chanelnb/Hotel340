/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Main.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author sogol
 */
public class HomeScreenController implements Initializable {
    
    @FXML
    private Button homeScreenSearchButton;

    @FXML
    private Button homeScreenLogoutButton;

    @FXML
    private Button homeScreenReservationButton;
    
    private Main main;
    
    
    //connect main class to controller
    public void setMain(Main main) {
        this.main = main;
        
    }

     @FXML
    void goesToSearch(ActionEvent event) throws IOException {   
        main.searchWindow();
    }
    
     @FXML
    void signIn(ActionEvent event) throws IOException {   
        main.loginWindow();
    }
    
     @FXML
    void goesToReservation(ActionEvent event) throws IOException {   
        main.reservationWindow();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}







