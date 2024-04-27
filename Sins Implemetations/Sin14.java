/**
 * Sin 14 is about simplicity on the user and balancing safety
 * This is a code example of encryption software UI, not the actual encryption, just what the user would see
 * Mason Myre
 */

import java.util.Scanner;


public class Sin14 {
    
    public static void main(String[] args) throws InterruptedException {
        //badExample();
        goodExample();
    }
    
    public static void badExample() throws InterruptedException{ //our bad example of an encryptor ui
        Scanner in = new Scanner(System.in);
        System.out.println("Hello and welcome to the file encryptor UI");
        System.out.println("Enter the encryption algorithm that you would like to use");
        System.out.println("1: AES\n2: RSA\n3: Blowfish\n4: Twofish\n5: DES"); //overloading user with information
        String option = in.nextLine();
        System.out.println();

        System.out.println("Please enter the key you will be using for encryption: "); //overloading user with information
        String key = in.nextLine();
        System.out.println();

        System.out.println("Encrypting with settings from user input"); //psychologically reminding them that the input was entirely their own, despite them likely not knowing anything about encryption
        System.out.print("Encrypting");
        for(int i = 0; i < 9; i++){
            Thread.sleep(500); //haha funny dots go brrrr
            System.out.print(" .");
        }
        System.out.println();

        System.out.println("Your \"file\" is now \"encrypted\""); 

        in.close();
    }

    public static void goodExample() throws InterruptedException{ //a better example of user friendliness
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the file encryptor: "); //a bit more welcoming
        System.out.println("Please select your encryption method by typing the corresponding number and pressing the enter key: "); //giving information on how to use the UI
        System.out.println("1: AES (Recommended Choice)\n2: RSA\n3: Blowfish\n4: Twofish\n5: DES"); //giving a recommended choice to the user
        String input = in.nextLine();

        System.out.print("Running key generation"); //doing key generation for user automatically
        for(int i = 0; i < 6; i++){
            Thread.sleep(500); //funny dots go brrrr again
            System.out.print(" .");
        }
        System.out.println(); //spacing

        System.out.println("A secure key has been generated"); //letting the user know the key has been made
        Thread.sleep(1000); //waiting a second to give the user time to process things (a good program would still have stuff running in the background here)
        System.out.println("File encryption started using the generated key"); //giving user relevant infomation
        System.out.print("Encrypting");
        for(int i = 0; i < 9; i++){
            Thread.sleep(500); //funny dots go brrrr for the last time
            System.out.print(" .");
        }

        System.out.println("Your file has been encrypted, thank you for using the file encryptor!"); //user friendly UI

    }



}
