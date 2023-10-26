import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rn = new Random();
        int seed = Math.abs(rn.nextInt());
        for (int i = 0; i < 3; i++) {
            System.out.print("Digite a linha número " + (i + 1) + ": ");
            String line = scanner.nextLine();
            String encryptedLine = Encrypt.encrypt(line, seed);
            System.out.println("Linha encriptada: " + encryptedLine);
        }

        while (true) {
            System.out.print("Deseja uma dica? (y/n): ");
            String option = scanner.nextLine();
            if (option.equalsIgnoreCase("y")) {
                System.out.println("Seed da cifra: " + seed);
                break;
            }
            if (option.equalsIgnoreCase("n")) {
                break;
            }
        }
        System.out.println("Perguntas:\n1- Como a cifra influencia na criptografia?\n2- Existe alguma semelhança com a cifra de Caesar?\n3- A cifra aceita qualquer caracter?");
    }
}