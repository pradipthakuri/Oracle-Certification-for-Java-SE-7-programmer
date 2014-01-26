/*
*This Client class in contained in a package client which is the subpackage of packageTest
*/

package packageTest.client;

import java.io.*;
import java.net.*;
import java.util.*;

import packageTest.shared.Utilities;

public class Client extends Thread
{
    Socket clientSocket = null;
    
    //constructor
    public Client(Socket s)
    {
        clientSocket = s;
    }
    
    public void run()
    {
        if (clientSocket == null)
        {
            return;
        }
        
        PrintStream out = null;
        
        Utilities.printMsg("creating output stream..");
        
        try
        {
            out = new PrintStream(clientSocket.getOutputStream());
        }
        catch (IOException e)
        {
            System.err.println("Error binding output to socket, " + e);
            System.exit(1);
        }
        
        Utilities.printMsg("Writing current date..");
        Date d = new Date();
        out.println(d);
        
        try
        {
            out.close();
            clientSocket.close();
        }
        catch (IOException e)
        {}
        
 
    }
    
    protected void finalize()
    {
        if (clientSocket != null)
        {
            try
            {
                clientSocket.close();
            }
            catch (IOException e)
            { }
            clientSocket = null;
        }
    }
    
   
}