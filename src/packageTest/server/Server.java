/*
*This Server class in contained in a package server which is the subpackage of packageTest
*/

package packageTest.server;

/**
 *
 * @author pradip
 */

import java.io.*;
import java.net.*;
import packageTest.shared.Utilities;    //imports Utilities class from packageTest.shared.
import packageTest.client.Client;       //imports Client class from packageTest.client.

public class Server {
    public static void main(String args[])
    {
        ServerSocket serverSocket = null;
        
        Utilities.printMsg("Creating server socket");
        
        try
        {
            serverSocket = new ServerSocket(4444);
        }
        catch (IOException e)
        {
            System.err.println("Unable to create server socket, " + e);
            System.exit(1);
        }
        
        Utilities.printMsg("accepting client connections..");
        
        while (true)
        {
            try
            {
                Socket clientSocket = serverSocket.accept();
                new Client(clientSocket).start();   //calls the constructor of Client class
            }
            catch (IOException e)
            {
                System.err.println("Unable to accept socket connection, " + e);
                System.exit(1);
            }
        }
    }
}
