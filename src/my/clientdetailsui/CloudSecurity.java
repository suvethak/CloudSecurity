/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package my.clientdetailsui;

/**
 *
 * @author Suvetha Kannan
 */

    /*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */ 



/*
 * CloudSecurity.java
 *
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;

public class CloudSecurity {
    
        
  /**
     * Prepare the global variables for the other splash functions
     */
    
    private static void splashInit()
    {
        
        if (mySplash != null)
        {   // if there are any problems displaying the splash this will be null
            Dimension ssDim = mySplash.getSize();
            int height = ssDim.height;
            int width = ssDim.width;
            // stake out some area for our status information
            //splashTextArea = new Rectangle2D.Double(15., height*0.88, width * .45, 32.);
            splashProgressArea = new Rectangle2D.Double(width *.07, height*.55, width*.85, 14 );

            // create the Graphics environment for drawing status info
            splashGraphics = mySplash.createGraphics();
            font = new Font("Dialog", Font.PLAIN, 14);
            splashGraphics.setFont(font);
            
            // initialize the status info
            //splashText("Starting");
            splashProgress(0);
        }
    }
    
    /**
     * Display text in status area of Splash.  Note: no validation it will fit.
     * @param str - text to be displayed
     */
    public static void splashText(String str)
    {
        if (mySplash != null && mySplash.isVisible())
        {   // important to check here so no other methods need to know if there
            // really is a Splash being displayed

            // erase the last status text
            //splashGraphics.setPaint(Color.LIGHT_GRAY);
            //splashGraphics.fill(splashTextArea);

            // draw the text
            //splashGraphics.setPaint(Color.BLACK);
           // splashGraphics.drawString(str, (int)(splashTextArea.getX() + 10),(int)(splashTextArea.getY() + 15));

            // make sure it's displayed
            mySplash.update();
        }
    }
    
    /**
     * Display a (very) basic progress bar
     * @param pct how much of the progress bar to display 0-100
     */
    public static void splashProgress(int pct)
    {
        if (mySplash != null && mySplash.isVisible())
        {

            // Note: 3 colors are used here to demonstrate steps
            // erase the old one
            splashGraphics.setPaint(Color.LIGHT_GRAY);
            splashGraphics.fill(splashProgressArea);

            // draw an outline
           splashGraphics.setPaint(Color.BLACK);
           splashGraphics.draw(splashProgressArea);

            // Calculate the width corresponding to the correct percentage
            int x = (int) splashProgressArea.getMinX();
            int y = (int) splashProgressArea.getMinY();
            int wid = (int) splashProgressArea.getWidth();
            int hgt = (int) splashProgressArea.getHeight();

            int doneWidth = Math.round(pct*wid/100.f);
            doneWidth = Math.max(0, Math.min(doneWidth, wid-1));  // limit 0-width

            // fill the done part one pixel smaller than the outline
            splashGraphics.setPaint(Color.DARK_GRAY);
            splashGraphics.fillRect(x, y+1, doneWidth, hgt-1);

            // make sure it's displayed
            mySplash.update();
        }
    }
    /**
     * just a stub to simulate a long initialization task that updates
     * the text and progress parts of the status in the Splash
     */
    private static void appInit()
    {
        for(int i=1;i<=10;i++)
        {
            int pctDone = i * 10;
            splashText("Doing task #" + i);
            splashProgress(pctDone);
            try
            {
                Thread.sleep(1);//1000  MODIFY IT LATER  SUVETHA!!!!
            }
            catch (InterruptedException ex)
            {
                // ignore it
            }
        }
    }
    
    public static void main (String args[]) {
        splashInit();           // initialize splash overlay drawing parameters
        appInit();              // simulate what an application would do 
                                // before starting
        if (mySplash != null)   // check if we really had a spash screen
            mySplash.close();   // if so we're now done with it
        
        // begin with the interactive portion of the program
        ClientUI.main();  
    }
    
    private final static SplashScreen mySplash = SplashScreen.getSplashScreen();;
    private static Graphics2D splashGraphics;
    private static Font font;
    private static Rectangle2D splashProgressArea;
    private static Rectangle2D splashTextArea;
}
    
