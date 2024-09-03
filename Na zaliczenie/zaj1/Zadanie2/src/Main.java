import java.util.HashMap;
import java.util.Map;

public class Main {
    // Metoda szyfrująca tekst tylko dla dużych liter alfabetu angielskiego (A-Z)
    public static String encryptUpperCase(String text, int shift) {
        StringBuilder result = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) {
                result.append((char) (((c - 'A' + shift) % 26) + 'A'));
            } else {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Metoda odszyfrowująca tekst tylko dla dużych liter alfabetu angielskiego (A-Z)
    public static String decryptUpperCase(String text, int shift) {
        return encryptUpperCase(text, 26 - shift);
    }

    // Metoda obliczająca częstość występowania poszczególnych liter w tekście
    public static Map<Character, Integer> calculateFrequency(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char uppercaseChar = Character.toUpperCase(c);
                frequencyMap.put(uppercaseChar, frequencyMap.getOrDefault(uppercaseChar, 0) + 1);
            }
        }
        return frequencyMap;
    }

    public static void main(String[] args) {
        // Zaszyfrowanie tekstu z przykładu A
        String textA = "ABC,abc\n012 789\nXYZ.xyz";
        int shiftA = 25;
        String encryptedTextA = encryptUpperCase(textA, shiftA);
        System.out.println("Zaszyfrowany tekst A: " + encryptedTextA);

        // Odszyfrowanie tekstu z przykładu B
        String textB = "BCD, YZO\n123 89A";
        int shiftB = 35;
        String decryptedTextB = decryptUpperCase(textB, shiftB);
        System.out.println("Odszyfrowany tekst B: " + decryptedTextB);

        // Tekst z przykładu C - zaszyfrowany
        String textC = "Your encrypted text here..."; // Wprowadź swój zaszyfrowany tekst
        int shiftC = 10; // Przesunięcie zaszyfrowanego tekstu z przykładu C
        // Wyświetlenie częstości występowania liter w zaszyfrowanym tekście
        Map<Character, Integer> frequencyMapC = calculateFrequency(textC);
        System.out.println("Częstość występowania liter w zaszyfrowanym tekście:");
        for (Map.Entry<Character, Integer> entry : frequencyMapC.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Tekst wzorcowy - niezaszyfrowany
        String referenceText = "Your reference text here..."; // Wprowadź swój niezaszyfrowany tekst wzorcowy
        // Wyświetlenie częstości występowania liter w niezaszyfrowanym tekście wzorcowym
        Map<Character, Integer> frequencyMapReference = calculateFrequency(referenceText);
        System.out.println("\nCzęstość występowania liter w niezaszyfrowanym tekście wzorcowym:");
        for (Map.Entry<Character, Integer> entry : frequencyMapReference.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
