
package student.database.pstu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author SUDIPTOB2
 */
public class Javaconnect {
    
    public static Connection  connectDatabase()
    {
                try {
                    Class.forName("org.sqlite.JDBC");
                    Connection conn = DriverManager.getConnection("jdbc:sqlite:studentdata.sqlite");
                    //JOptionPane.showMessageDialog(null, "connection Established");
                    return conn;
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                    return null;
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                    return null;
                }
                
    }
}
