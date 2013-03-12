/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.clientdetailsui;

/**
 *
 * @author kss
 */

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBConnection implements IPConfig{

    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private String query;
    private String driver = "com.mysql.jdbc.Driver";
    private String dsn = "jdbc:mysql://" + dbIP + ":3306/erasurecode", userid = "root", pwd = "shiva";

    public Statement connect() {
        try {
            Class.forName(driver);
            con = (Connection) DriverManager.getConnection(dsn, userid, pwd);
            stmt= (Statement) con.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
         return stmt;
    }
   }
