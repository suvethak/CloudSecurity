/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package my.clientdetailsui;

import java.awt.Component;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Arun Kumar
 */
public class MergeFile {
    private static Component rootPane;

    public static void mergeBytes(byte[] part1, byte[] part2,
            byte[] part3, byte[] part4, int totLen,String fileName) {

        byte getBytes[] = new byte[totLen];

        int x = 0, y = 0;

        for (int i = 0; i < part1.length; i++) {

            getBytes[x] = part1[i];
            x++;
        }
        System.out.println("size of x:" + x);

        for (int i = 0; i < part2.length; i++) {

            getBytes[x] = part2[i];
            x++;
        }
        System.out.println("size of x:" + x);

        for (int i = 0; i < part3.length; i++) {

            getBytes[x] = part3[i];
            x++;
        }
        System.out.println("size of x:" + x);

        for (int i = 0; i < part4.length; i++) {

            getBytes[x] = part4[i];
            x++;
        }
        System.out.println("size of x:" + x + " " + getBytes.length);

        File fout = new File("C:\\Download\\",fileName);
        
        try {

            FileOutputStream fos = new FileOutputStream(fout);
            try {
                fos.write(getBytes);
           
                fos.flush();
                fos.close();
                System.out.println(fout.length());
            } catch (IOException ex) {
                Logger.getLogger(FileSplit.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileSplit.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
