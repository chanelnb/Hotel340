/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Main.Main;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import Databases.DataObject;

/**
 *
 * @author cah
 */
public class MySqlConnector {
    
    
    PreparedStatement pst;
    ResultSet rs;
    Stage stage;
    
    Main main = new Main();
    
    
    public static Connection getConnection(){
        Connection con = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
            try {
                con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/hotelmanagementsystem", "root", "");
            } catch (SQLException ex) {
                Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
            }

            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
            }
         return con;
    
    } 
    
    public void checkUser (String username, String password) throws IOException {
        String query = "SELECT * FROM `user` WHERE username = ? AND password = ?";
            try {
                pst = getConnection().prepareStatement(query);
                pst.setString(1,username);
                pst.setString(2,password);

                rs = pst.executeQuery();
                if(rs.next()){
                    //if login successful show a new form
              
                   try {
                       FXMLLoader fxmlLoader = new FXMLLoader();
                       fxmlLoader.setLocation(getClass().getResource("/Views/HomeScreen.fxml"));
                       
                       Scene scene = new Scene(fxmlLoader.load(), 600, 400);
                       Stage stage = new Stage();
                       stage.setScene(scene);
                       stage.show();    
                       
                   } catch (IOException e) {
                       e.printStackTrace();
                   }
                }else{
                    // if login unsuccessful show error message
                   Alert alert = new Alert(Alert.AlertType.WARNING);
                   alert.setTitle("Warning");
                   alert.setContentText("Invalid username or password");
                   alert.showAndWait();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public boolean isExist(String email) throws IOException{
        String query = "SELECT * FROM `user` WHERE email = ?";
        boolean user_exist = false;
            try{
                pst = getConnection().prepareStatement(query);
                pst.setString(1,email);
                
                rs = pst.executeQuery();
                if(rs.next()){
                   user_exist = true;
                }
            }
            catch (SQLException ex) {
                Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
            
            }
            return user_exist;
    }
    
    public void userExist (String fname, String lname, String address, String phone, String email,String username, String password) throws IOException{
        
            String query2 = "INSERT into 'user' ('uuid','fname','lname','address','phone','email',username','password') values (?,?,?,?,?,?,?,?)";
                    
        try{ 
            pst = getConnection().prepareStatement(query2);
            pst.setString(1,DataObject.generateUuid());
            pst.setString(2,fname);
            pst.setString(3,lname);
            pst.setString(4,address);
            pst.setString(5,phone);
            pst.setString(6,email);
            pst.setString(7,username);
            pst.setString(8,password);
         
                    
                    if(isExist(email)){
                         //if user already exists
                   Alert alert = new Alert(Alert.AlertType.WARNING);
                   alert.setTitle("Warning");
                   alert.setContentText("User already exists!");
                   alert.showAndWait();
                }
                    else{
                        
                    
                    if(pst.executeUpdate() != 0){
                        try {
                       FXMLLoader fxmlLoader = new FXMLLoader();
                       fxmlLoader.setLocation(getClass().getResource("/Views/login.fxml"));
                       
                       Scene scene = new Scene(fxmlLoader.load());
                       Stage stage = new Stage();
                       stage.setScene(scene);
                       stage.show();    
                       
                        } catch (IOException e) {
                       e.printStackTrace();
                   }
                    
                }
                    }
             
    }
        catch (SQLException ex){
                Logger.getLogger(MySqlConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}