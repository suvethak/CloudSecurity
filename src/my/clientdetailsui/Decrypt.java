/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.clientdetailsui;

import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.BASE64Decoder;

/**
 *
 * @author Arun Kumar
 */
public class Decrypt {

    /*  Mode = CipherMode.CBC,-( Cipher-block chaining)
    Padding = PaddingMode.PKCS7 or PKCS5,
    KeySize = 128,
    BlockSize = 128,
    Key = keyBytes,
    IV = keyBytes */
    Cipher cipher;

    public static byte[] main(String recData) throws Exception {

        // Input encrypted String
        String input = recData;

        // password to decrypt 16 bit
        String strPassword = "password12345678";

        // put this as key in AES
        SecretKeySpec key = new SecretKeySpec(strPassword.getBytes(), "AES");

        AlgorithmParameterSpec paramSpec = new IvParameterSpec(strPassword.getBytes());
        //Whatever you want to encrypt/decrypt using AES /CBC padding
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        //You can use ENCRYPT_MODE or DECRYPT_MODE
        cipher.init(Cipher.DECRYPT_MODE, key, paramSpec);

        //decode data using standard decoder
        byte[] output = new BASE64Decoder().decodeBuffer(input.toString());

        // Decrypt the data
        byte[] decrypted = cipher.doFinal(output);

        System.out.println("Decrypted byte"+decrypted.toString());
        System.out.println("Original string: "
                + new String(input));

        // decryptedData .;
        System.out.println("Decrypted string: " + new String(decrypted));
                return decrypted;
    }
}
