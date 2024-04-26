//Sin 9 is about exception handling
//Mason Myre

import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Sin9 {

    public void readFileBadExample(String fileName){ //this is the bad example of how to catch exceptions when reading in a file
        String firstLine = "";
        try{ //here is our try block, complete with lines that have absolutely nothing to do with the try statement
            FileReader file = new FileReader(fileName); //this is the part that we are worried about failing
            BufferedReader in = new BufferedReader(file);
            String nextLine = in.readLine(); //
            firstLine = nextLine; //imagine we also want the first line of the file that we are reading in to be printed out at the end
            while(!in.equals(null)){ //while we have another line
                System.out.println(nextLine); //we print out the line
                nextLine = in.readLine();
            }
        }
        catch(IOException e){ //random catch, displaying no information
        }
        //this is a logic error
        //although it is obvious that I am trying to get the first line
        // of the input file, java is completely unaware
        System.out.println(firstLine); 

    }

    public void readFileGoodExample(String fileName){ //better example of how to handle exceptions for reading in a file
        String firstLine = ""; 
        FileReader file; //creating our variables beforehand
        BufferedReader in;
        String nextLine;
        
        try{
            file = new FileReader(fileName); //no longer declaring the variables in the try statement, instead we now merely initialize them
            in = new BufferedReader(file);
            nextLine = in.readLine(); //get the next line
            firstLine = nextLine; //get the first line to be printed out at the end
            while(!in.equals(null)) { //while we have another line
                System.out.println(nextLine); //print that line
                nextLine = in.readLine();
            }
            in.close(); //close the file correctly
        }
        catch(FileNotFoundException e){ //specific exception error handling
            System.out.println("Error, file was not found: " + fileName); //printing out errors with meaninful information
        }
        catch(IOException e){
            System.out.println("Error reading from the file " + fileName);
        }
        finally{
            System.out.println(firstLine); //only print out the first line at the end if it actually got assigned
        }

    }







}
