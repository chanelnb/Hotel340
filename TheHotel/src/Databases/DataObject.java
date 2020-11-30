/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Databases;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Chanel Brown
 */
public abstract class DataObject extends DataFactory {

    protected final String dataTable = "";
    protected int id;
    protected String uuid;
    protected String fname;
    protected String lname;
    protected String address;
    protected String phone;
    protected String email;
    protected String password;       
    protected String username;
    protected String type;
    protected int roomno;
    protected String checkin;
    protected String checkout;
    protected boolean active = true;

    public DataObject() {
        this.setUuid(DataObject.generateUuid());
    }
    
    public DataObject loadByName (String _fname) {
        HashMap<String, String> map = new HashMap<>();
        map.put("fname", _fname);
        return this.loadByCondition(map);
    }
    
    public DataObject loadById(int _id) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", Integer.toString(_id));
        return this.loadByCondition(map);
    }

    public DataObject loadByUuid(String _uuid) {
        HashMap<String, String> map = new HashMap<>();
        map.put("uuid", _uuid);
        return this.loadByCondition(map);
    }

    public DataObject loadByCondition(String _name, String _value) {
        HashMap<String, String> map = new HashMap<>();
        map.put(_name, _value);
        return this.loadByCondition(map);
    }

    public Boolean save() {
        // Has this object already been created?
        if (this.id == 0) {
            try {
                return DataStoreAdapter.createObject(this);
            } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException | NoSuchFieldException ex) {
                Logger.getLogger(DataObject.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                // This is an exisitng object in the database, just update the object.
                return DataStoreAdapter.updateObject(this);
            } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException | NoSuchFieldException ex) {
                Logger.getLogger(DataObject.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public Boolean delete() {
        try {
            return DataStoreAdapter.deleteObject(this);
        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException | NoSuchFieldException ex) {
            Logger.getLogger(DataObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void makeActive() {
        this.active = true;
    }

    public void makeInactive() {
        this.active = false;
    }

    protected static String generateUuid() {
        return UUID.randomUUID().toString();
    }

// ================================ GETTERS ====================================

    public String getName() {
        return this.fname;
    }
    
    public int getRoom() {
        return this.roomno;
    }
    
    public String getType() {
        return this.type;
    }
    
    public String getUuid() {
        return this.uuid;
    }

    public int getId() {
        return this.id;
    }

// ================================ SETTERS ====================================

    public void setName(String _fname) {
        this.fname = _fname;
    }
    
    public void setRoom(int _roomno) {
        this.roomno = _roomno;
    }
    
    public void setType(String _type) {
        this.type = _type;
    }
    
    public void setUuid(String _uuid) {
        this.uuid = _uuid;
    }

    public void setId(int _id) {
        this.id = _id;
    }
}