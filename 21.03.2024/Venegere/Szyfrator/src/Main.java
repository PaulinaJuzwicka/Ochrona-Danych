import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static String encrypt(String plaintext, String key) {
        StringBuilder ciphertext = new StringBuilder();
        int keyLength = key.length();
        int plaintextLength = plaintext.length();

        for (int i = 0; i < plaintextLength; i++) {
            char currentChar = plaintext.charAt(i);
            char currentKeyChar = key.charAt(i % keyLength);

            if (Character.isUpperCase(currentChar)) {
                int shiftedChar = ((currentChar - 'A') + (currentKeyChar - 'A')) % 26 + 'A';
                ciphertext.append((char) shiftedChar);
            } else if (Character.isLowerCase(currentChar)) {
                int shiftedChar = ((currentChar - 'a') + (currentKeyChar - 'A')) % 26 + 'a';
                ciphertext.append((char) shiftedChar);
            } else {
                ciphertext.append(currentChar);
            }
        }

        return ciphertext.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj nazwę pliku z tekstem do zaszyfrowania: ");
        String plaintextFile = scanner.nextLine();

        System.out.print("Podaj klucz szyfrowania: ");
        String key = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(plaintextFile))) {
            StringBuilder plaintextBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                plaintextBuilder.append(line);
                plaintextBuilder.append("\n");
            }
            String plaintext = plaintextBuilder.toString().trim();

            String ciphertext = encrypt(plaintext, key);
            System.out.println("Ciphertext: " + ciphertext);
        } catch (IOException e) {
            System.err.println("Error reading plaintext file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}