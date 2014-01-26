/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package packageTest;

/**
 *
 * @author pradip
 */

import java.io.*;
import java.text.*;
import java.util.*;
import java.util.logging.*;

public class PackageImportTest {
    public static void main(String[] args) throws IOException
    {
        //Ensure directory has been created
        new File("logs").mkdir();
        
        //get the date to be used in the filename
        DateFormat df = new SimpleDateFormat("yyyyMMddhhmmss");
        Date now = new Date();
        String date = df.format(now);
        
        //set the filename in the logs directory
        String logFileName = "logs\\testlog-" + date + ".txt";
        
        //set up logger
        FileHandler myFileHandler = new FileHandler(logFileName);
        myFileHandler.setFormatter(new SimpleFormatter());
        Logger myLogger = Logger.getLogger("My Logger");
        myLogger.setLevel(Level.ALL);
        myLogger.addHandler(myFileHandler);
        
        //log message
        myLogger.info("\nThis si a logged information msg.");
        
        //close the file
        myFileHandler.close();
    }
}
