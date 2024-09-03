import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    private static String vigenereCipher(String text, String key, String alphabet) {
        StringBuilder encryptedText = new StringBuilder();
        int keyLength = key.length();
        int alphabetLength = alphabet.length();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (alphabet.indexOf(currentChar) == -1) {
                // Ignoruj znaki spoza podanego alfabetu
                encryptedText.append(currentChar);
                continue;
            }

            char keyChar = key.charAt(i % keyLength);
            int shift = alphabet.indexOf(keyChar);
            String shiftedAlphabet = alphabet.substring(shift) + alphabet.substring(0, shift);

            if (Character.isUpperCase(currentChar)) {
                encryptedText.append(shiftedAlphabet.charAt(alphabet.indexOf(Character.toUpperCase(currentChar))));
            } else if (Character.isLowerCase(currentChar)) {
                encryptedText.append(Character.toLowerCase(shiftedAlphabet.charAt(alphabet.indexOf(Character.toLowerCase(currentChar)))));
            } else {
                encryptedText.append(currentChar);
            }
        }

        return encryptedText.toString();
    }

    public static int[] countLetterFrequencies(String text, String alphabet) {
        int[] frequencies = new int[alphabet.length()];

        for (char c : text.toCharArray()) {
            int index = alphabet.indexOf(Character.toUpperCase(c));
            if (index != -1) {
                frequencies[index]++;
            }
        }

        return frequencies;
    }

    public static int sumOfSquaredFrequencies(int[] frequencies) {
        int sum = 0;
        for (int freq : frequencies) {
            sum += freq * freq;
        }
        return sum;
    }

    public static void main(String[] args) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        // Wczytanie tekstu z pliku
        String fileName = "encrypted.txt";
        StringBuilder text = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                text.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String key = "BA9A";
        String encryptedText = vigenereCipher(text.toString(), key, alphabet);
        System.out.println("Zaszyfrowany tekst: " + encryptedText);

        int[] frequencies = countLetterFrequencies(encryptedText, alphabet);
        int sumOfSquared = sumOfSquaredFrequencies(frequencies);
        System.out.println("Suma kwadratów częstości liter: " + sumOfSquared);
    }
}
