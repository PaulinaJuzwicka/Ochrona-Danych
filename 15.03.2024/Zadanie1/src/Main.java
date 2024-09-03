//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static String vigenereCipher(String text, String key, String alphabet) {
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

    public static void main(String[] args) {
        String text1 = "CC!@#CCAA";
        String text2 = "AA?9999";
        String key = "BA9A";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

        String encryptedText1 = vigenereCipher(text1, key, alphabet);
        String encryptedText2 = vigenereCipher(text2, key, alphabet);

        System.out.println("Zaszyfrowany tekst 1: " + encryptedText1);
        System.out.println("Zaszyfrowany tekst 2: " + encryptedText2);
    }
}