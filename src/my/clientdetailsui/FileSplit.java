/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.clientdetailsui;

import java.awt.Component;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kss
 */
public class FileSplit {
    private static Component rootPane;

    public static String[] main(File file) {

        String[] chunkedContents = new String[4];

        FileInputStream fis = null;
        try {
            File fileToChunk = file;
            fis = new FileInputStream(fileToChunk);
            //File f1=new File();

            int len = (int) fileToChunk.length();

            int size1 = len / 4, size2 = (len / 2) - (len / 4),
                    size3 = ((len * 3) / 4) - (len / 2), size4 = len - ((len * 3) / 4);
            int tempSize1 = 0;

            System.out.println(size1 + " " + size2 + " " + size3 + " " + size4 + " ");

            byte[] getBytes = new byte[len];//Gets the size of overall file
            byte[] part1 = new byte[size1];
            byte[] part2 = new byte[size2];
            byte[] part3 = new byte[size3];
            byte[] part4 = new byte[size4];
            try {
                
                fis.read(getBytes);
                
                System.out.println(getBytes.length);

                for (int i = 0; i < size1; i++) {

                    part1[i] = getBytes[tempSize1++];

                }
                //fis.read(part1, 0,size1);
                System.out.println("part1 length:" + part1.length);

                for (int i = 0; i < size2; i++) {

                    part2[i] = getBytes[tempSize1++];

                }
                System.out.println("part2 length:" + part2.length);

                for (int i = 0; i < size3; i++) {

                    part3[i] = getBytes[tempSize1++];

                }
                System.out.println("part3 length:" + part3.length);

                for (int i = 0; i < size4; i++) {

                    part4[i] = getBytes[tempSize1++];

                }
                System.out.println("part4 length:" + part4.length);
                
                System.out.println("File Size:"+(size1 + size2 + size3 + size4));
                try {
                    
                    //Encrypt the bytes
                    String encPart1 = Encrypt.main(part1);
                    String s1=SHA256.main(encPart1);
                                       
                    String encPart2 = Encrypt.main(part2);
                    String s2=SHA256.main(encPart2);
                    String encPart3 = Encrypt.main(part3);
                    String s3=SHA256.main(encPart3);
                    String encPart4 = Encrypt.main(part4);
                    String s4=SHA256.main(encPart4);
                    
                   


                    //Converting String to Binary

                    String c1 =StringToBinary.main(encPart1);
                    String c2 =StringToBinary.main(encPart2);
                    String c3 =StringToBinary.main(encPart3);
                    String c4 =StringToBinary.main(encPart4);


                    //Returning the cipher stream
                    chunkedContents[0] = c1;
                    chunkedContents[1] = c2;
                    chunkedContents[2] = c3;
                    chunkedContents[3] = c4;
                    
                    partHexSignature.main(s1,s2,s3,s4);
               
                } catch (Exception ex) {
                    Logger.getLogger(FileSplit.class.getName()).log(Level.SEVERE, null, ex);
                }

                //To merge the chunked bytes

            } catch (IOException ex) {
                Logger.getLogger(FileSplit.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileSplit.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(FileSplit.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        //Retruning the chunked contents to the calling method
        return chunkedContents;
    }
}