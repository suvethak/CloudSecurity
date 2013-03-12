/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.clientdetailsui;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Suvetha Kannan
 */
public class GetIP {

    private String ipaddr;

    public String getIPaddr() {
        try {
            InetAddress addr = InetAddress.getLocalHost();
            ipaddr=addr.getHostAddress();

        } catch (UnknownHostException ex) {
            Logger.getLogger(GetIP.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ipaddr;
    }

   
}
