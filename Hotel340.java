/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hotel340;

/**
 *
 * @author cah
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Scanner;
public class Hotel340 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the dates of your stay");
        
        String date = in.nextLine();
        SimpleDateFormat format = new SimpleDateFormat("dd-mm-yyyy");
        Date stay = format.parse(date);
       
        System.out.println("Please enter the number of rooms needed");
        int rooms = in.nextInt();
        
    }
    
    static boolean searchRoom(Date stay, int rooms) {
        boolean isAvailable = false;
        
        
        if (rooms == 1) {
            // will search through the hotel rooms with only 1 room
            // if the rooms are checked in for the dates given
            //boolean isAvailable will remain false
            // else isAvaiable = true
            
        }
         if (rooms == 2) {
            // will search through the hotel rooms with only 2 rooms
            // if the rooms are checked in for the dates given
            //boolean isAvailable will remain false
            // else isAvaiable = true
        }
         
     return isAvailable;   
    }
    
}

//Testing this out for git push
