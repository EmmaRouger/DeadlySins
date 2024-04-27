import java.util.ArrayList;
import java.util.Scanner;

public class App {

    private static ArrayList<Account> accounts = new ArrayList<Account>();
    public static void main(String[] args) throws Exception {
        System.out.println("This is a login test!");

        accounts.add(new Account("John", "1997"));
        accounts.add(new Account("Timmy", "Superman"));
        accounts.add(new Account("King", "BretHarte"));

        Scanner scan = new Scanner(System.in);
        printMenu(scan);
    }

    private static void printMenu(Scanner scan){
        
        System.out.println("\nPlease select an option from the list: \n");
        System.out.println("To Create Account, enter 1");
        System.out.println("To Login to an Account, enter 2");
        System.out.println("To Exit, enter 3\n");
        String option = scan.nextLine();
        int key = testOption(option);

        switch (key) {
            case 1:
                createAccount(scan);        
                break;
            case 2:
                login(scan);
            case 3: 
                System.out.println("Goodbye!");
                scan.close();
                System.exit(0);
            default:
            System.out.println("Not a valid option. Please try again.");
            printMenu(scan);
                break;
        }
    }

    private static int testOption(String option){
        try {
            int key = Integer.parseInt(option);
            return key;
        } catch (Exception NumberFormatException) {
            // Implemetation sin 11: Error Handling
            // Instead of printing stack trace for generic Exception, catch the specific exception for the parse Int function
            return -1;
        }
    }

    private static void createAccount(Scanner scan){
        String username; 
        String password;

        System.out.println("Please enter a username you want to use: ");
        username = scan.nextLine();
        System.out.println("Please enter a password you want to use: ");
        password = scan.nextLine();

        accounts.add(new Account(username, password));
        System.out.println("Account created!");
        printMenu(scan);   
    }

    private static void login(Scanner scan){
        String username; 
        String password;
        System.out.println("Please enter username: ");
        username = scan.nextLine();
        System.out.println("Please enter a password: ");
        password = scan.nextLine();

        boolean result = false;
        for (Account account : accounts) {
            if (account.Login(username, password)) {
                result = true;
            }
        }
        // Implementation Sin 12: Information Leakage
        // With the way this check is designed, instead of printing an error when reaching the end of the accounts list 
        // OR an error based on if the username or passwords worked
        // We simply give the user the least amount of information possible, without revealing anything valuable
        if (result) {
            System.out.println("Login Successful!");
            printMenu(scan);
        }
        else{
            System.out.println("Invalid credentials!");
            printMenu(scan);
        }
    }
}
