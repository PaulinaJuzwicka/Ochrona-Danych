import java.util.Scanner;

public class CaesarCipherBreakerWithLanguageDetection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj zaszyfrowany tekst:");
        String encryptedText = scanner.nextLine();

        // Automatyczne wykrywanie języka tekstu
        String language = detectLanguage(encryptedText);
        System.out.println("Język tekstu: " + language);

        System.out.println("Odszyfrowany tekst:");
        for (int key = 1; key < 26; key++) {
            String decryptedText = decrypt(encryptedText, key);
            System.out.println("Klucz " + key + ": " + decryptedText);
        }
    }

    public static String detectLanguage(String text) {
        int englishCount = 0;
        int polishCount = 0;

        // Zliczanie wystąpień liter w tekście
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                if ("aeiouyAEIOUY".indexOf(c) != -1) {
                    englishCount++;
                } else if ("ąćęłńóśźżĄĆĘŁŃÓŚŹŻ".indexOf(c) != -1) {
                    polishCount++;
                }
            }
        }

        // Porównanie ilości wystąpień liter w celu określenia języka tekstu
        if (englishCount > polishCount) {
            return "angielski";
        } else {
            return "polski";
        }
    }

    public static String decrypt(String encryptedText, int key) {
        StringBuilder decryptedText = new StringBuilder();

        for (int i = 0; i < encryptedText.length(); i++) {
            char currentChar = encryptedText.charAt(i);

            if (Character.isLetter(currentChar)) {
                if (Character.isUpperCase(currentChar)) {
                    char decryptedChar = (char) ((currentChar - 'A' + (26 - key)) % 26 + 'A');
                    decryptedText.append(decryptedChar);
                } else if (Character.isLowerCase(currentChar)) {
                    char decryptedChar = (char) ((currentChar - 'a' + (26 - key)) % 26 + 'a');
                    decryptedText.append(decryptedChar);
                }
            } else {
                decryptedText.append(currentChar);
            }
        }

        return decryptedText.toString();
    }
}
