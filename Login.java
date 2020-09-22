package abchotel;

import java.util.Scanner;
public class Login {

    public static void main(String[] args) {
        UserAccount account= new UserAccount();
        Scanner kb= new Scanner(System.in);
        System.out.println("Please enter your username");
        account.setUsername(kb.nextLine());
        System.out.println("Please enter your password");
        account.setPassword(kb.nextLine());
        
        Auth(account.getUsername(), account.getPassword());
    }
    
    public static void Auth(String username, String password){
        if(username.equals("amad") && password.equals("shah")){
            System.out.println("Login Successful ");
    }
        else System.out.println("Incorrect Username or Password");
    }
}
