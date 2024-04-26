import java.io.*;

public class Sin17 {
    public static void main(String[] args) {
        // Create a file with read permissions
        File file = new File("testfile.txt");
        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully.");
                // Set read permissions make sure no write permissions so only read allowed
                file.setReadable(true);
                file.setWritable(false);
                System.out.println("File permissions set to only readable.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.err.println("Error creating the file: " + e.getMessage());
        }

        // Attempt to read from the file
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }

        // should catch error because no write permisions
        try (BufferedWriter write = new BufferedWriter(new FileWriter(file))) {
            String line = "I should not be able to write";
            write.write(line, 0, 0);
            System.out.println("wait that should not have been possible");
        } catch (IOException e) {
            System.err.println("Yay it caught the error tells me I can't write because i don't have the permissions");
        }

        file.delete();
    }
}
