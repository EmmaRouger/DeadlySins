//Sin 9 is about exception handling
//Mason Myre

import java.util.*;
import java.io.*;
import java.util.Scanner;

public class Sin9 {

    public void readFileBadExample(String fileName){
        String firstLine = "";
        try{
            FileReader file = new FileReader(fileName);
            BufferedReader in = new BufferedReader(file);
            String nextLine = in.readLine();
            firstLine = nextLine;
            while(!in.equals(null)){
                System.out.println(nextLine);
                nextLine = in.readLine();
            }
        }
        catch(IOException e){
        }
        //this is a logic error
        //although it is obvious that I am trying to get the first line
        // of the input file, java is completely unaware
        System.out.println(firstLine); 

    }

    public void readFileGoodExample(String fileName){
        String firstLine = "";
        FileReader file;
        BufferedReader in;
        String nextLine;
        
        try{
            file = new FileReader(fileName);
            in = new BufferedReader(file);
            nextLine = in.readLine();
            firstLine = nextLine;
            while (!in.equals(null)) {
                System.out.println(nextLine);
                nextLine = in.readLine();
            }
            in.close();
        }
        catch(FileNotFoundException e){
            System.out.println("Error, file was not found: " + fileName);
        }
        catch(IOException e){
            System.out.println("Error reading from the file " + fileName);
        }
        finally{
            System.out.println(firstLine);
        }

    }







}
