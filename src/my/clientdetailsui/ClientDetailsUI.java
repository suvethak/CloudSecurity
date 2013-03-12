package my.clientdetailsui;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.RequestTokenPair;
import com.dropbox.client2.session.Session.AccessType;
import com.dropbox.client2.session.WebAuthSession;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientDetailsUI {
	
	// App key & secret that Dropbox's developer website gives your app
	final static private String APP_KEY1= "cma320mhxw1hc6u";
	final static private String APP_SECRET1 = "mldfz7xk2k4jzua";
        
        final static private String APP_KEY2 = "jwmi5jjfuctta3r";
	final static private String APP_SECRET2 = "wcy0zm9ix3l540s";
        
        final static private String APP_KEY3 = "ekiufyg1kx4to1n";
	final static private String APP_SECRET3 = "l465skj8npupqae";
        
        final static private String APP_KEY4 = "p1rfcvcddy4r2cb";
	final static private String APP_SECRET4 = "jqbd7r2xip54hsj";
        
        final static private String APP_KEY5= "losdms3ielkrh9a";
	final static private String APP_SECRET5 = "9jp5h46ge6t8p3l";
        
        final static private String APP_KEY6 = "1qy2y3oj3hso3fk";
	final static private String APP_SECRET6 = "9upoechj34nr7go";
        
        final static private String APP_KEY7 = "ua5q4g4wxpvj9c7";
	final static private String APP_SECRET7 = "8w87lztt9tk0kue";
        
        final static private String APP_KEY8 = "ykjg9vz0jx21bnm";
	final static private String APP_SECRET8 = "g1xughgfxtr72sg";
        
        final static private String APP_KEY9 = "ke39v23v8ilbf9f";
	final static private String APP_SECRET9 = "h4iei7evhf3vgon";
        
        
	
	// Define AccessType for DropboxAPI object
	final static private AccessType ACCESS_TYPE = AccessType.APP_FOLDER;
        //For Cloud Servers
	private static DropboxAPI<WebAuthSession> mDBApi1;
        private static DropboxAPI<WebAuthSession> mDBApi2;
        private static DropboxAPI<WebAuthSession> mDBApi3;
        private static DropboxAPI<WebAuthSession> mDBApi4;
        
        //For Replica Servers
        private static DropboxAPI<WebAuthSession> mDBApi5;
        private static DropboxAPI<WebAuthSession> mDBApi6;
        private static DropboxAPI<WebAuthSession> mDBApi7;
        private static DropboxAPI<WebAuthSession> mDBApi8;
        
        private static DropboxAPI<WebAuthSession> mDBApi9;

	public static void main() throws Exception{
		
		// Initialize the goods/session
		AppKeyPair appKeys1 = new AppKeyPair(APP_KEY1, APP_SECRET1);
		WebAuthSession session1 = new WebAuthSession(appKeys1, ACCESS_TYPE);
                
                AppKeyPair appKeys2 = new AppKeyPair(APP_KEY2, APP_SECRET2);
		WebAuthSession session2 = new WebAuthSession(appKeys2, ACCESS_TYPE);
                
                AppKeyPair appKeys3 = new AppKeyPair(APP_KEY3, APP_SECRET3);
		WebAuthSession session3 = new WebAuthSession(appKeys3, ACCESS_TYPE);
                
                AppKeyPair appKeys4 = new AppKeyPair(APP_KEY4, APP_SECRET4);
		WebAuthSession session4 = new WebAuthSession(appKeys4, ACCESS_TYPE);
                
                AppKeyPair appKeys5 = new AppKeyPair(APP_KEY5, APP_SECRET5);
		WebAuthSession session5 = new WebAuthSession(appKeys5, ACCESS_TYPE);
                
                AppKeyPair appKeys6 = new AppKeyPair(APP_KEY6, APP_SECRET6);
		WebAuthSession session6 = new WebAuthSession(appKeys6, ACCESS_TYPE);
                
                AppKeyPair appKeys7 = new AppKeyPair(APP_KEY7, APP_SECRET7);
		WebAuthSession session7 = new WebAuthSession(appKeys7, ACCESS_TYPE);
                
                AppKeyPair appKeys8 = new AppKeyPair(APP_KEY8, APP_SECRET8);
		WebAuthSession session8 = new WebAuthSession(appKeys8, ACCESS_TYPE);
                
                AppKeyPair appKeys9 = new AppKeyPair(APP_KEY9, APP_SECRET9);
		WebAuthSession session9 = new WebAuthSession(appKeys9, ACCESS_TYPE);
		
		// Initialize DropboxAPI object
		mDBApi1 = new DropboxAPI<WebAuthSession>(session1);
		mDBApi2 = new DropboxAPI<WebAuthSession>(session2);
                mDBApi3 = new DropboxAPI<WebAuthSession>(session3);
		mDBApi4 = new DropboxAPI<WebAuthSession>(session4);
                mDBApi5 = new DropboxAPI<WebAuthSession>(session5);
		mDBApi6 = new DropboxAPI<WebAuthSession>(session6);
                mDBApi7 = new DropboxAPI<WebAuthSession>(session7);
		mDBApi8 = new DropboxAPI<WebAuthSession>(session8);
                mDBApi9 = new DropboxAPI<WebAuthSession>(session9);
                
		// Get ready for user input
		Scanner input = new Scanner(System.in);
		
		// Open file that stores tokens, MUST exist as a blank file
		File tokensFile1 = new File("AppKeyFile1");
                File tokensFile2 = new File("AppKeyFile2");
                File tokensFile3 = new File("AppKeyFile3");
                File tokensFile4 = new File("AppKeyFile4");
                
                File tokensFile5 = new File("AppKeyFile5");
                File tokensFile6 = new File("AppKeyFile6");
                File tokensFile7 = new File("AppKeyFile7");
                File tokensFile8 = new File("AppKeyFile8");
                File tokensFile9 = new File("AppKeyFile9");
                
                        //File Authentication
			Scanner tokenScanner1 = new Scanner(tokensFile1); 
                        Scanner tokenScanner2 = new Scanner(tokensFile2);
                        Scanner tokenScanner3 = new Scanner(tokensFile3); 
                        Scanner tokenScanner4 = new Scanner(tokensFile4);
                        Scanner tokenScanner5 = new Scanner(tokensFile5); 
                        Scanner tokenScanner6 = new Scanner(tokensFile6);
                        Scanner tokenScanner7 = new Scanner(tokensFile7); 
                        Scanner tokenScanner8 = new Scanner(tokensFile8);
                        Scanner tokenScanner9 = new Scanner(tokensFile9);
                        
                        // Initiate Scanner to read tokens from TOKEN file
			String ACCESS_TOKEN_KEY1 = tokenScanner1.nextLine();    // Read key
			String ACCESS_TOKEN_SECRET1 = tokenScanner1.nextLine(); // Read secret
                        
                         // Initiate Scanner to read tokens from TOKEN file
			String ACCESS_TOKEN_KEY2 = tokenScanner2.nextLine();    // Read key
			String ACCESS_TOKEN_SECRET2 = tokenScanner2.nextLine(); // Read secret
                        
                         // Initiate Scanner to read tokens from TOKEN file
			String ACCESS_TOKEN_KEY3 = tokenScanner3.nextLine();    // Read key
			String ACCESS_TOKEN_SECRET3 = tokenScanner3.nextLine(); // Read secret
                        
                         // Initiate Scanner to read tokens from TOKEN file
			String ACCESS_TOKEN_KEY4 = tokenScanner4.nextLine();    // Read key
			String ACCESS_TOKEN_SECRET4 = tokenScanner4.nextLine(); // Read secret
                        
                        // Initiate Scanner to read tokens from TOKEN file
			String ACCESS_TOKEN_KEY5 = tokenScanner5.nextLine();    // Read key
			String ACCESS_TOKEN_SECRET5 = tokenScanner5.nextLine(); // Read secret
                        
                         // Initiate Scanner to read tokens from TOKEN file
			String ACCESS_TOKEN_KEY6 = tokenScanner6.nextLine();    // Read key
			String ACCESS_TOKEN_SECRET6 = tokenScanner6.nextLine(); // Read secret
                        
                         // Initiate Scanner to read tokens from TOKEN file
			String ACCESS_TOKEN_KEY7 = tokenScanner7.nextLine();    // Read key
			String ACCESS_TOKEN_SECRET7 = tokenScanner7.nextLine(); // Read secret
                        
                         // Initiate Scanner to read tokens from TOKEN file
			String ACCESS_TOKEN_KEY8 = tokenScanner8.nextLine();    // Read key
			String ACCESS_TOKEN_SECRET8 = tokenScanner8.nextLine(); // Read secret
                        
                         // Initiate Scanner to read tokens from TOKEN file
			String ACCESS_TOKEN_KEY9 = tokenScanner9.nextLine();    // Read key
			String ACCESS_TOKEN_SECRET9 = tokenScanner9.nextLine(); // Read secret
                        
                        //Close Scanner 
			tokenScanner1.close(); 
                        tokenScanner2.close();
                        tokenScanner3.close(); 
                        tokenScanner4.close();
                        tokenScanner5.close(); 
                        tokenScanner6.close();
                        tokenScanner7.close(); 
                        tokenScanner8.close();
                        tokenScanner9.close();
                        
			//Re-auth
			AccessTokenPair reAuthTokens1 = new AccessTokenPair(ACCESS_TOKEN_KEY1, ACCESS_TOKEN_SECRET1);
                        AccessTokenPair reAuthTokens2 = new AccessTokenPair(ACCESS_TOKEN_KEY2, ACCESS_TOKEN_SECRET2);
                        AccessTokenPair reAuthTokens3 = new AccessTokenPair(ACCESS_TOKEN_KEY3, ACCESS_TOKEN_SECRET3);
                        AccessTokenPair reAuthTokens4 = new AccessTokenPair(ACCESS_TOKEN_KEY4, ACCESS_TOKEN_SECRET4);
                        AccessTokenPair reAuthTokens5 = new AccessTokenPair(ACCESS_TOKEN_KEY5, ACCESS_TOKEN_SECRET5);
                        AccessTokenPair reAuthTokens6 = new AccessTokenPair(ACCESS_TOKEN_KEY6, ACCESS_TOKEN_SECRET6);
                        AccessTokenPair reAuthTokens7 = new AccessTokenPair(ACCESS_TOKEN_KEY7, ACCESS_TOKEN_SECRET7);
                        AccessTokenPair reAuthTokens8 = new AccessTokenPair(ACCESS_TOKEN_KEY8, ACCESS_TOKEN_SECRET8);
                        AccessTokenPair reAuthTokens9 = new AccessTokenPair(ACCESS_TOKEN_KEY9, ACCESS_TOKEN_SECRET9);
                        
			mDBApi1.getSession().setAccessTokenPair(reAuthTokens1);
                        mDBApi2.getSession().setAccessTokenPair(reAuthTokens2);
                        mDBApi3.getSession().setAccessTokenPair(reAuthTokens3);
                        mDBApi4.getSession().setAccessTokenPair(reAuthTokens4);
                        mDBApi5.getSession().setAccessTokenPair(reAuthTokens5);
                        mDBApi6.getSession().setAccessTokenPair(reAuthTokens6);
                        mDBApi7.getSession().setAccessTokenPair(reAuthTokens7);
                        mDBApi8.getSession().setAccessTokenPair(reAuthTokens8);
                        mDBApi9.getSession().setAccessTokenPair(reAuthTokens9);
                        
                        
			System.out.println("Authentication Sucessful!");
			
			//Run test command
			System.out.println("Hello there, " + mDBApi1.accountInfo().displayName);
                        System.out.println("Hello there, " + mDBApi2.accountInfo().displayName);
                        System.out.println("Hello there, " + mDBApi3.accountInfo().displayName);
                        System.out.println("Hello there, " + mDBApi4.accountInfo().displayName);
                        System.out.println("Hello there, " + mDBApi5.accountInfo().displayName);
                        System.out.println("Hello there, " + mDBApi6.accountInfo().displayName);
                        System.out.println("Hello there, " + mDBApi7.accountInfo().displayName);
                        System.out.println("Hello there, " + mDBApi8.accountInfo().displayName);
                        System.out.println("Hello there, " + mDBApi9.accountInfo().displayName);
                  
	}
	
        public static void upload(File f,String location,int count) {
        FileInputStream fis = null;
        if(count==1)
        {    
        try {
            fis = new FileInputStream(f);
            mDBApi1.putFile("/"+location+"/"+f.getName(), fis, f.length(), null, null);
            System.out.println("Users file has been uploaded into the cloud server 1 ");
            
        } catch (DropboxException ex) {
            Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        else if(count==2)
        {    
        try {
            fis = new FileInputStream(f);
            mDBApi2.putFile("/"+location+"/"+f.getName(), fis, f.length(), null, null);
            System.out.println("Users file has been uploaded into the cloud server 2 ");
            
        } catch (DropboxException ex) {
            Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        else if(count==3)
        {    
        try {
            fis = new FileInputStream(f);
            mDBApi3.putFile("/"+location+"/"+f.getName(), fis, f.length(), null, null);
            System.out.println("Users file has been uploaded into the cloud server 3 ");
            
        } catch (DropboxException ex) {
            Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        
        else if(count==4)
        {    
        try {
            fis = new FileInputStream(f);
            mDBApi4.putFile("/"+location+"/"+f.getName(), fis, f.length(), null, null);
            System.out.println("Users file has been uploaded into the cloud server 4 ");
            
        } catch (DropboxException ex) {
            Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        else if(count==5)
        {    
        try {
            fis = new FileInputStream(f);
          
            mDBApi5.putFile("/"+location+"/"+f.getName(), fis, f.length(), null, null);
            System.out.println("Users file has been uploaded into the replica server 1 ");
        } catch (DropboxException ex) {
            Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        else if(count==6)
        {    
        try {
            fis = new FileInputStream(f);
            
            mDBApi6.putFile("/"+location+"/"+f.getName(), fis, f.length(), null, null);
            System.out.println("Users file has been uploaded into the replica server 2 ");
        } catch (DropboxException ex) {
            Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        else if(count==7)
        {    
        try {
            fis = new FileInputStream(f);
            
            mDBApi7.putFile("/"+location+"/"+f.getName(), fis, f.length(), null, null);
            System.out.println("Users file has been uploaded into the replica server 3 ");
        } catch (DropboxException ex) {
            Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        
        else if(count==8)
        {    
        try {
            fis = new FileInputStream(f);
            
            mDBApi8.putFile("/"+location+"/"+f.getName(), fis, f.length(), null, null);
            System.out.println("Users file has been uploaded into the replica server 4 ");
        } catch (DropboxException ex) {
            Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        else if(count==9)
        {    
        try {
            fis = new FileInputStream(f);
            
            mDBApi9.putFile("/"+location+"/"+f.getName(), fis, f.length(), null, null);
            System.out.println("Users file has been uploaded into the binary server ");
        } catch (DropboxException ex) {
            Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        }
        }

    public static File download(String location,String fileName,int count) {

        File file = null;
        FileOutputStream outputStream = null;
        try {
             file = new File("c:\\Temp",fileName);
            outputStream = new FileOutputStream(file);
            if(count==1)
            {    
            mDBApi1.getFile("/"+location+"/"+fileName, null, outputStream, null);
            }
            else if(count==2)
            {    
            mDBApi2.getFile("/"+location+"/"+fileName, null, outputStream, null);
            }
            else if(count==3)
            {    
            mDBApi3.getFile("/"+location+"/"+fileName, null, outputStream, null);
            }
            else if(count==4)
            {    
            mDBApi4.getFile("/"+location+"/"+fileName, null, outputStream, null);
            }
            else if(count==5)
            {    
            mDBApi5.getFile("/"+location+"/"+fileName, null, outputStream, null);
            }
            else if(count==6)
            {    
            mDBApi6.getFile("/"+location+"/"+fileName, null, outputStream, null);
            }
            else if(count==7)
            {    
            mDBApi7.getFile("/"+location+"/"+fileName, null, outputStream, null);
            }
            else if(count==8)
            {    
            mDBApi8.getFile("/"+location+"/"+fileName, null, outputStream, null);
            }
            else if(count==9)
            {    
            mDBApi9.getFile("/"+location+"/"+fileName, null, outputStream, null);
            }
        } 
        catch (DropboxException ex) {
            Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                outputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(ClientDetailsUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return file;
    }
    
}
