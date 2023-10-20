import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Random rn = new Random();

        System.out.println("Encrypt (1) or decrypt (2)?");
        int option;
        do {
            option = scanner.nextInt();
        } while (option != 1 && option != 2);

        if (option == 1) {
            System.out.print("Text to encrypt: ");
            scanner.nextLine();
            String text = scanner.nextLine();
            int seed = Math.abs(rn.nextInt());
            System.out.println("Encrypted text: " + Encrypt.encrypt(text, seed) + " \n\nseed: " + seed);
        } else {
            System.out.println("Text to decrypt: ");
            scanner.nextLine();
            String text = scanner.nextLine();
            System.out.println("\nSeed: ");
            int seed = scanner.nextInt();
            System.out.println("Decrypted text: " + Encrypt.decrypt(text, seed));
        }
    }
}