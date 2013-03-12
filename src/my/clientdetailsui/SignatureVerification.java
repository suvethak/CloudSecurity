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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kss
 */
public class SignatureVerification {
    private static Component rootPane;
    static int count1,count2,count3,count4;
    public static void main(String signature,String fileName,int fileSize,String getClient ) throws IOException, SQLException
    {
        //Download function from ClientLoader for the correspoding file of the client that has to be verified by the TPA
        String[] xorContents = new String[4];
        try {
            ClientDetailsUI.main();
        } catch (Exception ex) {
            Logger.getLogger(TPALoader.class.getName()).log(Level.SEVERE, null, ex);
        }
       byte[] part1 = null, part2 = null, part3 = null, part4 = null;
        File file;

        //Connecting Database to get file size        
        DBConnection db = new DBConnection();
        Statement stmt = db.connect();
        String[] hex=new String[4];
        try {
            ResultSet rs = stmt.executeQuery("select * from fileowner where owner= "
                    + "'" + getClient + "' and fileName='" + fileName + "'");
            while (rs.next()) {

                String temp = rs.getString("fileSize");
                fileSize = Integer.parseInt(temp);
                System.out.println(fileSize);
            }


        } catch (SQLException ex) {
            Logger.getLogger(ClientLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Getting part1 data
        file = ClientDetailsUI.download("Replica Server 1", fileName,5);
        String getContents = FileContentsToString.main(file);
        BinaryToString bs = new BinaryToString();
        String orgForm = null;
        try {
            orgForm = bs.getBinaryToString(getContents);
            System.out.println("part1:"+orgForm);
            hex[0]=SHA256.main(orgForm);
        } catch (Exception ex) {
            Logger.getLogger(ClientLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            part1 = Decrypt.main(orgForm);

        } catch (Exception ex) {
            Logger.getLogger(ClientLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Getting part2 data
        file = ClientDetailsUI.download("Replica Server 2", fileName,6);
        getContents = FileContentsToString.main(file);

        orgForm = null;
        try {
            orgForm = bs.getBinaryToString(getContents);
            System.out.println("part2:"+orgForm);
            hex[1]=SHA256.main(orgForm);
        } catch (Exception ex) {
            Logger.getLogger(ClientLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            part2 = Decrypt.main(orgForm);

        } catch (Exception ex) {
            Logger.getLogger(ClientLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Getting part3
        file = ClientDetailsUI.download("Replica Server 3", fileName,7);
        getContents = FileContentsToString.main(file);

        orgForm = null;
        try {
            orgForm = bs.getBinaryToString(getContents);
            System.out.println("part3:"+orgForm);
            hex[2]=SHA256.main(orgForm);
        } catch (Exception ex) {
            Logger.getLogger(ClientLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            part3 = Decrypt.main(orgForm);

        } catch (Exception ex) {
            Logger.getLogger(ClientLoader.class.getName()).log(Level.SEVERE, null, ex);
        }


        //Getting part 4
        file = ClientDetailsUI.download("Replica Server 4", fileName,8);
        getContents = FileContentsToString.main(file);

        orgForm = null;
        try {
            orgForm = bs.getBinaryToString(getContents);
            System.out.println("part4:"+orgForm);
            hex[3]=SHA256.main(orgForm);
            
        } catch (Exception ex) {
            Logger.getLogger(ClientLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            part4 = Decrypt.main(orgForm);

        } catch (Exception ex) {
            Logger.getLogger(ClientLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Merging the Entire file after downloading
        
        MergeFile.mergeBytes(part1, part2, part3, part4, fileSize, fileName);
        
        try {
               /** File dir = new File("nameoffolder");
                dir.mkdir();
                File directory = new File("macros/bin/");
             directory.deleteOnExit();
             */
                String str=fileReader.readFile("C:\\Download\\"+fileName);
                String HexSignature=SHA256.main(str);
          if(signature.equals(HexSignature))
          {
                    JOptionPane.showMessageDialog(rootPane, "File Integrity has been verified in the replica servers");
                            
            try {
                ClientDetailsUI.main();
            } catch (Exception ex) {
                Logger.getLogger(ClientLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
           
            
            FileOutputStream fos1 = null;
            FileOutputStream fos2 = null;
            FileOutputStream fos3 = null;
            FileOutputStream fos4 = null;
            FileOutputStream fos5 = null;
            FileOutputStream fos6 = null;
            FileOutputStream fos7 = null;
            
            try {
                //Getting the chunked contents
                String location="C:\\Download\\"+fileName;
                System.out.println(location);
                File file1=new File(location);
                String[] getContent = FileSplit.main(file1);
                System.out.println(getContent[0]);
                File f1 = new File(fileName);
               
                /*
                File f2 = new File("c:\\part2\\" + fileName.getText());
                File f3 = new File("c:\\part3\\" + fileName.getText());
                File f4 = new File("c:\\part4\\" + fileName.getText());
                 */
                
                
                fos1 = new FileOutputStream(f1);
                fos2 = new FileOutputStream(f1);
                fos3 = new FileOutputStream(f1);
                fos4 = new FileOutputStream(f1);
                fos5 = new FileOutputStream(f1);
                fos6 = new FileOutputStream(f1);
                fos7 = new FileOutputStream(f1);
                
                try {

                    fos1.write(getContent[0].getBytes());
                    ClientDetailsUI.upload(f1, "Cloud Server 1",1);
                    
                    fos1.close();
                    f1.delete();
                    // fos.write("".getBytes());
                    fos2.write(getContent[1].getBytes());
                    ClientDetailsUI.upload(f1, "Cloud Server 2",2);
                   
                    fos2.close();
                    f1.delete();
                    //f2.delete();
                    //  fos3.write("".getBytes());
                    fos3.write(getContent[2].getBytes());
                    ClientDetailsUI.upload(f1, "Cloud Server 3",3);
                    
                    fos3.close();
                    f1.delete();
                    // f3.delete();
                    //   fos.write("".getBytes());
                    fos4.write(getContent[3].getBytes());
                    ClientDetailsUI.upload(f1, "Cloud Server 4",4);
                    
                    fos4.close();
                    f1.delete();
                    //f4.delete();
                    System.out.println("Your file has been uploaded into the cloud server:" + fileName);
                    JOptionPane.showMessageDialog(rootPane, "Your file has been recovered from the replica server");  
                } catch (IOException ex) {
                    Logger.getLogger(ClientLoader.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ClientLoader.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
            }
        }
        else
          {
               try {
            ClientDetailsUI.main();
        } catch (Exception ex) {
            Logger.getLogger(ClientLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
      
               
               
            FileOutputStream fos1 = null;
            FileOutputStream fos2 = null;
            FileOutputStream fos3 = null;
            FileOutputStream fos4 = null;
            
            
          ResultSet rs = stmt.executeQuery("select * from fileowner where owner= "
                    + "'" + getClient + "' and fileName='" + fileName + "'");
            while (rs.next()) {

                String p1 = rs.getString("part1");
                if(p1.equals(hex[0]))
                {
                    System.out.println("File integrity verified in Replica Server 1");
                    count1=0;
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane,"File integrity is lost in Replica Server 1");
                    count1=1;
                }
                String p2 = rs.getString("part2");
                if(p2.equals(hex[1]))
                {
                    System.out.println("File integrity verified in Replica Server 2");
                    count2=0;
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane,"File integrity is lost in Replica Server 2");
                    count2=1;
                }
                String p3 = rs.getString("part3");
                if(p3.equals(hex[2]))
                {
                    System.out.println("File integrity verified in Replica Server 3");
                    count3=0;
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane,"File integrity is lost in Replica Server 3");
                    count3=1;
                }
                String p4 = rs.getString("part4");
                if(p4.equals(hex[3]))
                {
                    System.out.println("File integrity verified in Replica Server 4");
                    count4=0;
                }
                else
                {
                    JOptionPane.showMessageDialog(rootPane,"File integrity is lost in Replica Server 4");
                    count4=1;
                }
            }      
               
       
        //Getting part1 data
        file = ClientDetailsUI.download("Xor Server 1", fileName,9);
        xorContents[0] = FileContentsToString.main(file);
        System.out.println(xorContents[0]);
        
        file = ClientDetailsUI.download("Xor Server 2", fileName,9);
        xorContents[1] = FileContentsToString.main(file);
                System.out.println(xorContents[1]);


        
        file = ClientDetailsUI.download("Xor Server 3", fileName,9);
        xorContents[2] = FileContentsToString.main(file);
                System.out.println(xorContents[2]);


        file = ClientDetailsUI.download("Xor Server 4", fileName,9);
        xorContents[3] = FileContentsToString.main(file);
                System.out.println(xorContents[3]);

        

        String[] XoredContents=XorRecovery.main(xorContents);
        
            File f1 = new File(fileName);
            
            
                fos1 = new FileOutputStream(f1);
                fos2 = new FileOutputStream(f1);
                fos3 = new FileOutputStream(f1);
                fos4 = new FileOutputStream(f1);
                
                  try {

                    fos1.write(XoredContents[0].getBytes());
                    ClientDetailsUI.upload(f1, "Cloud Server 1",1);
                    ClientDetailsUI.upload(f1, "Replica Server 1",5);
                    fos1.close();
                    f1.delete();
                    
                    // fos.write("".getBytes());
                    fos2.write(XoredContents[1].getBytes());
                    ClientDetailsUI.upload(f1, "Cloud Server 2",2);
                    ClientDetailsUI.upload(f1, "Replica Server 2",6);
                    fos2.close();
                    f1.delete();
                    //f2.delete();
                    //  fos3.write("".getBytes());
                    fos3.write(XoredContents[2].getBytes());
                    ClientDetailsUI.upload(f1, "Cloud Server 3",3);
                    ClientDetailsUI.upload(f1, "Replica Server 3",7);
                    fos3.close();
                    f1.delete();
                    // f3.delete();
                    //   fos.write("".getBytes());
                    fos4.write(XoredContents[3].getBytes());
                    ClientDetailsUI.upload(f1, "Cloud Server 4",4);
                    ClientDetailsUI.upload(f1, "Replica Server 4",8);
                    fos4.close();
                    f1.delete();
                    //f4.delete();
                    
                    
                    JOptionPane.showMessageDialog(rootPane,"File has been recovered from the Binary Server");

                } catch (IOException ex) {
                    Logger.getLogger(ClientLoader.class.getName()).log(Level.SEVERE, null, ex);
               }
       

        //Merging the Entire file after downloading

       
       
          }
         }
            
        catch(IOException ex) {
                Logger.getLogger(ClientLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
