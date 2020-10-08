
/**
 *
 * @author chanel brown
 */
public class Room {
    private int roomId;
    private int numRooms;
    
    private String roomType;
    private int pricePerNight;
    
    private boolean available;
    
    
    public int getRoomId() {
        return roomId;
    }
    
    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
    
    public int getNumRooms()  {
        return numRooms;
    }
    
    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }
    
    public String getRoomType() {
        return roomType;
    }
    
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
    
    public int getPricePerNight() {
        return pricePerNight;
    }
    
    public void setPricePerNight(int PricePerNight) {
        this.pricePerNight= pricePerNight;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    
}
