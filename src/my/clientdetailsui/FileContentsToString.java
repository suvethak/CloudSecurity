/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package my.clientdetailsui;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Suvetha Kannan
 */
public class FileContentsToString {

    public static String main(File file){

        File f=file;
        String content=null;
        try {
            content = FileUtils.readFileToString(f);
            System.out.println(content);
        } catch (IOException ex) {
            Logger.getLogger(FileContentsToString.class.getName()).log(Level.SEVERE, null, ex);
        }
        return content;
    }

}
