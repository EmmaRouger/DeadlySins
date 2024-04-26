import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sin10 {

    public static void main(String[] args) {
        try {
            // Step 1: Read user input from the console
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your input: ");
            String userInput = reader.readLine();

            // Step 2: Validate user input
            if (!isValidInput(userInput)) {
                System.err.println("Error: Invalid input.");
                return;
            }

            // Step 3: Construct the command with user input as an argument
            String[] command = { "cmd", "/c", "echo", userInput };

            // Step 4: Execute the command
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            Process process = processBuilder.start();

            // Step 5: Read and display the output
            BufferedReader outputReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            System.out.println("Output:");
            while ((line = outputReader.readLine()) != null) {
                System.out.println(line);
            }

            // Step 6: Handle errors
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            System.err.println("Errors:");
            while ((line = errorReader.readLine()) != null) {
                System.err.println(line);
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    // Method to validate user input
    private static boolean isValidInput(String input) {
        // Add your validation logic here, e.g., check for allowed characters
        return !input.isEmpty() && input.matches("[a-zA-Z0-9_\\-]+");
    }
}