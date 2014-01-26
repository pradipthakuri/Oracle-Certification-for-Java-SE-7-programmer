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
import java.util.ArrayList;

//imports all classes from java.io packages.
import java.io.*;

public class PackageTest {
    public static void main(String[] args)
    {
        //creats console from java.io package
        Console console = System.console();
        String myLang = console.readLine("\nEnter your favourite programming language: ");
        
        //creates list for languages
        ArrayList<String> langList = new ArrayList<String>();
        langList.add(myLang); //adds the users input to the arraylist
        langList.add("Python"); //adds the string to the arraylist
        
        System.out.println("\nMy favourites programming languages are: " + langList);
    }
}
