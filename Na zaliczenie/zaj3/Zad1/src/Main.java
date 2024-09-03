//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static void main(String[] args) {
        String message1 = "CC!@#CCAA";
        String message2 = "AA?9999";
        String key = "BA9A";

        String encryptedMessage1 = vigenereEncrypt(message1, key);
        String encryptedMessage2 = vigenereEncrypt(message2, key);

        System.out.println("Zaszyfrowana wiadomość 1: " + encryptedMessage1);
        System.out.println("Zaszyfrowana wiadomość 2: " + encryptedMessage2);
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
}