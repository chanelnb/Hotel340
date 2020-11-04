package abchotel;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect {
    

public static Connection getConnection(){
    Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/hotelmanagementsystem", "root", "");
        } catch (SQLException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    return con;
} 

}

