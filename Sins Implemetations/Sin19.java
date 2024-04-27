import java.util.Scanner;

public class Sin19 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean badPassword = true;

        System.out.println("Create an account.");
        System.out.print("Enter a username. There are no requirements.");
        String username = scan.nextLine();

        while (badPassword) {
            // Ensure there are requirements for the password
            System.out.print("Enter a password. Ensure it contains at least 12 characters,");
            System.out.print("including one lowercase letter, one uppercase letter, one number, and one special character.\n");
            String password = scan.nextLine();

            if (verifyPassword(password)) {
                System.out.println("Valid password. Account was created.");
                break;
            }
            else {
                // Do not specify whether the username or password was incorrect to maintain security
                System.out.print("Invalid username or password.\n");
            }
        }

        scan.close();
    }

    private static boolean verifyPassword(String password) {
        // Ensure the password is an adequate length for security
        if (password.length() < 12) {
            return false;
        }

        // Ensure other requirements for password creation
        boolean hasLowercase = false, hasUppercase = false, hasNumber = false, hasSpecialCharacter = false;

        for (char c : password.toCharArray()) {
            if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isDigit(c)) {
                hasNumber = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecialCharacter = true;
            }

            // Check if all conditions are met to break the loop; otherwise, the password will be invalid
            if (hasLowercase && hasUppercase && hasNumber && hasSpecialCharacter) {
                return true;
            }
        }

        return hasLowercase && hasUppercase && hasNumber && hasSpecialCharacter;
    }
}
