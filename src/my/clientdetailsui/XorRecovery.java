/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.clientdetailsui;


/**
 *
 * @author Suvetha Kannan
 */

import java.util.BitSet;

public class XorRecovery {
    /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
  
    private static BitSet fromString(final String s) {
        int count = 0;
        BitSet bs=new BitSet(s.length());
        for (char a : s.toCharArray())
        {
            if(a=='0')
            {
                bs.set(count,false);
               
            }
            else
            {
                bs.set(count,true);
                
            }
            count++; 
        }
       return bs;
    }

    private static String toString(BitSet bs) {
       int count = 0;
       String output="";
        
        for (int i=0;i<bs.length();i++)
        {
            if(bs.get(i)==false)
            {
                output=output+"0";
            }
            else
            {
                output=output+"1";
            }
        }
       return output;
    }
    
     public static String[] main(String[] xorContents) {
        
        String[] XoredContents= new String[4];
        int maxLength=0;
        BitSet bits1 = fromString(xorContents[0]);
        BitSet bits2 = fromString(xorContents[1]);
        BitSet bits3 = fromString(xorContents[2]);
        BitSet bits4 = fromString(xorContents[3]);
        
        //System.out.println(getContents[0]);
        //System.out.println(getContents[1]);
        
        System.out.println("getContents from XS1"+toString(bits1)); 
        System.out.println("getContents from XS2"+toString(bits2)); 
        System.out.println("getContents from XS3"+toString(bits3)); 
        System.out.println("getContents from XS3"+toString(bits3));
        
        //CS1 or CS2 contents
        
        XoredContents[0]=toString(bits1);
       
        bits2.xor(bits1); 
        XoredContents[1]=toString(bits2);
        if(xorContents[0].length()<=xorContents[1].length())
            {
                maxLength=xorContents[1].length();
            }
        
        for(int i=XoredContents[1].length();i<maxLength;i++)
        {
            XoredContents[1]+="0";
        }
        System.out.println("Xored Contents:"+XoredContents);
        
        //CS3
        bits2 = fromString(xorContents[1]);
        bits3 = fromString(xorContents[2]);
        bits3.xor(bits2);
        XoredContents[2]=toString(bits3);
        
        if(xorContents[1].length()<=xorContents[2].length())
            {
                maxLength=xorContents[2].length();
            }
        
        for(int i=XoredContents[2].length();i<maxLength;i++)
        {
            XoredContents[2]+="0";
        }
        System.out.println("Xored Contents:"+XoredContents);
        
        //CS4
        bits3 = fromString(xorContents[2]);
        bits4 = fromString(xorContents[3]);
        bits4.xor(bits3);
        XoredContents[3]=toString(bits4);
        
        if(xorContents[2].length()<=xorContents[3].length())
            {
                maxLength=xorContents[3].length();
            }
        
        for(int i=XoredContents[3].length();i<maxLength;i++)
        {
            XoredContents[3]+="0";
        }
        System.out.println("Xored Contents:"+XoredContents);
        
        
        return XoredContents;
        
        //System.out.println("Xored bits"+toString(bits2)); 
        
    }
    
    
}



