/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.clientdetailsui;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author kss
 */
public class partHexSignature {

    static String getUser;
    static String fileName;

    public static void main(String s1, String s2, String s3, String s4) {
        DBConnection db = new DBConnection();
        Statement stmt = db.connect();
        try {
            String sql1 = "Update fileowner set part1='" + (s1)+ "', part2='" + (s2)+ "', part3='" + (s3)+ "', part4='" + (s4)+ "' where fileName = '" + (fileName) + "'";

        int rs=stmt.executeUpdate(sql1);
        } catch (SQLException ex) {
            Logger.getLogger(ClientLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void getUser(String userName, String fName) {
        getUser = userName;
        fileName = fName;
    }
}
