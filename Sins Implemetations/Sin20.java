import java.security.SecureRandom;
import java.util.Random;

public class RandomNumber {
    public static void main(String[] args) {
        // This is the common way to generate a random number
        Random rand = new Random();
        int arr1[] = new int[20];
        for (int i = 0; i < 20; i++) {
            arr1[i] = rand.nextInt(100);
        }
        System.out.print("{");
        for (int i = 0; i < 19; i++) {
            System.out.print(arr1[i] + ", ");
        }
        System.out.print(arr1[19] + "}\n");

        // This is the secure way to generate a random number - do this one.
        SecureRandom secRand = new SecureRandom();
        int arr2[] = new int[20];
        for (int i = 0; i < 20; i++) {
            arr2[i] = secRand.nextInt(100);
        }
        System.out.print("{");
        for (int i = 0; i < 19; i++) {
            System.out.print(arr2[i] + ", ");
        }
        System.out.print(arr2[19] + "}\n");
    }
}
