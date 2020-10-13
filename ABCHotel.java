package abchotel;
/**
 * last updated 10/01/20
 * @author Sogol 
 * hotel management system
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ABCHotel extends Application{
    Button registerButton;
    
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Create Your Account");
        VBox vbox = new VBox();
        
        //email label and text field
        Label emailLabel = new Label("Email");
        TextField emailTextField = new TextField();
        
        //password label and text field
        Label passLabel = new Label("Password");
        final PasswordField pass = new PasswordField();
        
        //password confirmation label and text field
        Label passConfLabel = new Label("Confirm Password");
        final PasswordField confirmPass = new PasswordField();
        
        //name label and text field
        Label nameLabel = new Label("What is your name?");
        TextField nameTextField = new TextField();        
        
        //number label and text field
        Label numberLabel = new Label("What is your phone number?");
        TextField numberTextField = new TextField();    
        
        registerButton = new Button("Register");

        final Text registerationText = new Text();
        vbox.setSpacing(8);
        vbox.setPadding(new Insets(10, 10, 10, 10));
        vbox.getChildren().addAll(emailLabel, emailTextField, passLabel, pass, passConfLabel, confirmPass, nameLabel, nameTextField, numberLabel, numberTextField, registerButton, registerationText);
        
        registerButton.setOnAction(e -> {
            if(primaryStage != null)
                primaryStage.requestFocus();
                registerationText.setFill(Color.GREEN);
                registerationText.setText("Your Account Was Successfully Created");
            });
        
        Scene scene = new Scene(vbox, 400, 400);
        
        primaryStage.setTitle("Registration"); 
        primaryStage.setScene(scene);
        primaryStage.show();
    }
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
