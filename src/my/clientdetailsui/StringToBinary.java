/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.clientdetailsui;

/**
 *
 * @author Suvetha Kannan
 */
public class StringToBinary {

    public static String main(String getVal) {
        
        String cipher = getVal;
        StringBuilder binary = null;
        try {
            byte[] bytes = cipher.getBytes();
            binary = new StringBuilder();
            for (byte b : bytes) {
                int val = b;
                for (int i = 0; i < 8; i++) {
                    binary.append((val & 128) == 0 ? 0 : 1);
                    val <<= 1;
                }
            }
            System.out.println("Binary....." + binary);
            // return binary.toString();
            
              /**  byte[] bytes0=chunkedContents[1].getBytes();
                   byte[] bytes1=chunkedContents[2].getBytes();
                   byte[] bytes2=new byte[size2];
                   for(int j=0;j<size2;j++)
                   {
                            bytes2[j] = (byte)((bytes0[j] ^ bytes1[j]));  
                   }
                    
                    String xor1 = bytes2.toString();
                    System.out.println("Xored Bytes " + bytes2);
                    String xor = StringToBinary.main(xor1);
             */ 
            
           
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex);
        }
        
        return binary.toString();
    }
}
