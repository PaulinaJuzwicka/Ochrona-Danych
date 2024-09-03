public class Main {
    // Metoda szyfrująca tekst zgodnie z szyfrem Cezara dla kombinacji a-z0-9
    public static String encryptAZ09(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                int base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) (((c - base + shift) % 36) + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Metoda odszyfrowująca tekst zgodnie z szyfrem Cezara dla kombinacji a-z0-9
    public static String decryptAZ09(String text, int shift) {
        return encryptAZ09(text, 36 - shift);
    }

    // Metoda szyfrująca tekst zgodnie z szyfrem Cezara dla kombinacji 0-9a-z
    public static String encrypt09az(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                int base = Character.isDigit(c) ? '0' : 'a';
                result.append((char) (((c - base + shift) % 36) + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Metoda odszyfrowująca tekst zgodnie z szyfrem Cezara dla kombinacji 0-9a-z
    public static String decrypt09az(String text, int shift) {
        return encrypt09az(text, 36 - shift);
    }

    // Metoda szyfrująca tekst zgodnie z szyfrem Cezara dla kombinacji a-zA-Z
    public static String encryptAZaz(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                int base = Character.isUpperCase(c) ? 'A' : 'a';
                result.append((char) (((c - base + shift) % 26) + base));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Metoda odszyfrowująca tekst zgodnie z szyfrem Cezara dla kombinacji a-zA-Z
    public static String decryptAZaz(String text, int shift) {
        return encryptAZaz(text, 26 - shift);
    }

    public static void main(String[] args) {
        String text = "ABC,XYZ\n012 789";
        int shift = 35;

        // Szyfrowanie i odszyfrowywanie dla różnych kombinacji
        String encryptedAZ09 = encryptAZ09(text, shift);
        String decryptedAZ09 = decryptAZ09(encryptedAZ09, shift);

        String encrypted09az = encrypt09az(text, shift);
        String decrypted09az = decrypt09az(encrypted09az, shift);

        String encryptedAZaz = encryptAZaz(text, shift);
        String decryptedAZaz = decryptAZaz(encryptedAZaz, shift);

        // Wyświetlenie wyników
        System.out.println("Kombinacja a-z0-9:");
        System.out.println("Tekst zaszyfrowany: " + encryptedAZ09);
        System.out.println("Tekst odszyfrowany: " + decryptedAZ09);

        System.out.println("\nKombinacja 0-9a-z:");
        System.out.println("Tekst zaszyfrowany: " + encrypted09az);
        System.out.println("Tekst odszyfrowany: " + decrypted09az);

        System.out.println("\nKombinacja a-zA-Z:");
        System.out.println("Tekst zaszyfrowany: " + encryptedAZaz);
        System.out.println("Tekst odszyfrowany: " + decryptedAZaz);
    }
}
