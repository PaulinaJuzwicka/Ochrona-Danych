import java.util.HashMap;
import java.util.Map;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static void main(String[] args) {
        String message = "DLUGI TEKST DO ZASZYFROWANIA";
        String key = "BA9A";

        String encryptedMessage = vigenereEncrypt(message, key);
        Map<Character, Integer> frequencies = countLetterFrequencies(encryptedMessage);
        int sumOfSquares = sumOfSquaresOfFrequencies(frequencies);

        System.out.println("Zaszyfrowana wiadomość: " + encryptedMessage);
        System.out.println("Suma kwadratów częstości liter: " + sumOfSquares);
    }

    public static String vigenereEncrypt(String message, String key) {
        message = message.toUpperCase();
        key = key.toUpperCase();
        StringBuilder ciphertext = new StringBuilder();
        int keyLength = key.length();

        for (int i = 0; i < message.length(); i++) {
            char messageChar = message.charAt(i);
            if (ALPHABET.indexOf(messageChar) == -1) {
                ciphertext.append(messageChar);
                continue;
            }
            char keyChar = key.charAt(i % keyLength);
            int messageIndex = ALPHABET.indexOf(messageChar);
            int keyIndex = ALPHABET.indexOf(keyChar);
            int encryptedIndex = (messageIndex + keyIndex) % ALPHABET.length();
            ciphertext.append(ALPHABET.charAt(encryptedIndex));
        }
        return ciphertext.toString();
    }

    public static Map<Character, Integer> countLetterFrequencies(String text) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char c : ALPHABET.toCharArray()) {
            frequencies.put(c, 0);
        }

        for (char c : text.toCharArray()) {
            if (frequencies.containsKey(c)) {
                frequencies.put(c, frequencies.get(c) + 1);
            }
        }
        return frequencies;
    }

    public static int sumOfSquaresOfFrequencies(Map<Character, Integer> frequencies) {
        int sum = 0;
        for (int count : frequencies.values()) {
            sum += count * count;
        }
        return sum;
    }
}