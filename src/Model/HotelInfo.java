package Model;

/**
 *model for hotel
 * 
 * last update 11/29/20
 * 
 * @author sogol
 */
public class HotelInfo{
    private String hotelName;
    private int hotelPhoneNumber;
    private String hotelAdress;
    private int hotelNumberOfRooms;
    
//===================GETTERS=====================
    
    /**
     * @return the hotelName
     */
    public String getHotelName() {
        return hotelName;
    }

    /**
     * @return the hotelPhoneNumber
     */
    public int getHotelPhoneNumber() {
        return hotelPhoneNumber;
    }

    /**
     * @return the hotelAdress
     */
    public String getHotelAdress() {
        return hotelAdress;
    }

    /**
     * @return the hotelNumberOfRooms
     */
    public int getHotelNumberOfRooms() {
        return hotelNumberOfRooms;
    }
//===================SETTERS=====================    
    /**
     * @param _hotelName the hotelName to set
     */
    public void setHotelName(String _hotelName) {
        this.hotelName = _hotelName;
    }

    /**
     * @param _hotelPhoneNumber the hotelPhoneNumber to set
     */
    public void setHotelPhoneNumber(int _hotelPhoneNumber) {
        this.hotelPhoneNumber = _hotelPhoneNumber;
    }

    /**
     * @param _hotelAdress the hotelAdress to set
     */
    public void setHotelAdress(String _hotelAdress) {
        this.hotelAdress = _hotelAdress;
    }

    /**
     * @param _hotelNumberOfRooms the hotelNumberOfRooms to set
     */
    public void setHotelNumberOfRooms(int _hotelNumberOfRooms) {
        this.hotelNumberOfRooms = _hotelNumberOfRooms;
    }
    
}
