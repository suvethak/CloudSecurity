/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.clientdetailsui;

import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author kss
 */
public class PartByPartHexSignature {
    private static Component rootPane;
    
    public static void main(String hex[],String getClient,String fileName) throws SQLException
    {
        DBConnection db = new DBConnection();
        Statement stmt = db.connect();
         ResultSet rs = stmt.executeQuery("select * from fileowner where owner= "
                        + "'" + getClient + "' and fileName='" + fileName + "'");
                while (rs.next()) {

                    String p1 = rs.getString("part1");
                    if(p1.equals(hex[0]))
                    {
                        System.out.println("File integrity verified in Cloud Server 1");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(rootPane,"File integrity is lost in Cloud Server 1");
                    }
                    String p2 = rs.getString("part2");
                    if(p2.equals(hex[1]))
                    {
                        System.out.println("File integrity verified in Cloud Server 2");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(rootPane,"File integrity is lost in Cloud Server 2");
                    }
                    String p3 = rs.getString("part3");
                    if(p3.equals(hex[2]))
                    {
                        System.out.println("File integrity verified in Cloud Server 3");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(rootPane,"File integrity is lost in Cloud Server 3");
                    }
                    String p4 = rs.getString("part4");
                    if(p4.equals(hex[3]))
                    {
                        System.out.println("File integrity verified in Cloud Server 4");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(rootPane,"File integrity is lost in Cloud Server 4");
                    }
                }
    }
    
}
