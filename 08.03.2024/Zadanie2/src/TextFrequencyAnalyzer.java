import java.util.Scanner;

public class TextFrequencyAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj tekst do analizy:");
        String text = scanner.nextLine();

        // Sprawdzenie języka tekstu
        String language = detectLanguage(text);
        System.out.println("Język tekstu: " + language);

        // Obliczenie sumy kwadratów częstości występowania liter
        double sumOfLetterFrequencies = calculateLetterFrequencies(text);

        System.out.println("Suma kwadratów częstości występowania liter: " + sumOfLetterFrequencies);
    }

    public static String detectLanguage(String text) {
        // Liczniki wystąpień liter dla języka angielskiego i polskiego
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

    public static double calculateLetterFrequencies(String text) {
        int[] frequencies = new int[26]; // tablica częstości występowania liter

        // Zliczanie wystąpień liter w tekście
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char lowercase = Character.toLowerCase(c);
                frequencies[lowercase - 'a']++;
            }
        }

        // Obliczenie sumy kwadratów częstości występowania liter
        double sumOfSquares = 0;
        for (int frequency : frequencies) {
            sumOfSquares += frequency * frequency;
        }

        return sumOfSquares;
    }
}
