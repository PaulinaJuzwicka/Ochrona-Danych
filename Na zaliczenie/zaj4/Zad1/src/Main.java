import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    // Method to read file content
    public static String readFile(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path))).toUpperCase().replaceAll("[^A-Z]", "");
    }

    // Method to encrypt text using Vigenere cipher
    public static String encryptVigenere(String text, String key) {
        StringBuilder encrypted = new StringBuilder();
        key = key.toUpperCase();
        int keyIndex = 0;

        for (char c : text.toCharArray()) {
            int encryptedChar = (c - 'A' + key.charAt(keyIndex) - 'A') % 26 + 'A';
            encrypted.append((char) encryptedChar);
            keyIndex = (keyIndex + 1) % key.length();
        }
        return encrypted.toString();
    }

    // Method to calculate index of coincidence
    public static double indexOfCoincidence(String text) {
        int[] frequency = new int[26];
        for (char c : text.toCharArray()) {
            frequency[c - 'A']++;
        }
        int N = text.length();
        double ic = 0.0;
        for (int count : frequency) {
            ic += (double) count * (count - 1);
        }
        return ic / (N * (N - 1));
    }

    // Method to calculate average index of coincidence for divided groups
    public static double averageICForGroups(String text, int M) {
        double totalIC = 0.0;
        for (int i = 0; i < M; i++) {
            StringBuilder group = new StringBuilder();
            for (int j = i; j < text.length(); j += M) {
                group.append(text.charAt(j));
            }
            totalIC += indexOfCoincidence(group.toString());
        }
        return totalIC / M;
    }

    public static void main(String[] args) {
        try {
            // Prepare the texts
            String sampleText = readFile("path_to_sample_text_file.txt"); // replace with actual path
            String textToEncrypt = readFile("path_to_text_to_encrypt_file.txt"); // replace with actual path
            String key = "YOURKEY"; // replace with actual key

            // Encrypt the text
            String encryptedText = encryptVigenere(textToEncrypt, key);

            // Calculate and display index of coincidence for sample text
            double sampleIC = indexOfCoincidence(sampleText);
            System.out.println("wzorcowy, indeks = " + sampleIC);

            // Calculate and display index of coincidence for encrypted text with varying M
            for (int M = 2; M <= 20; M++) {
                double avgIC = averageICForGroups(encryptedText, M);
                System.out.println("zaszyfrowany, M=" + M + ", indeks = " + avgIC);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}