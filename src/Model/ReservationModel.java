/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author sogol
 */
public class ReservationModel extends UserModel{
    private String checkInDate;
    private String checkOut;

//===================GETTERS=====================
    
    /**
     * @return the checkInDate
     */
    public String getCheckInDate() {
        return checkInDate;
    }
    
    /**
     * @return the checkOut
     */
    public String getCheckOut() {
        return checkOut;
    }

//===================SETTERS=====================    
    
    /**
     * @param checkInDate the checkInDate to set
     */
    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    /**
     * @param checkOut the checkOut to set
     */
    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }
}
