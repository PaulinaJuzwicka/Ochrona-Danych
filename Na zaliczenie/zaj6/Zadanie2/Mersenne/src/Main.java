import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // Metoda sprawdzająca czy dana liczba jest liczbą pierwszą
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    // Metoda wykonująca test Lucasa-Lehmera dla danej liczby pierwszej p
    public static boolean lucasLehmerTest(int p) {
        if (!isPrime(p)) return false; // Sprawdzenie czy p jest liczbą pierwszą

        long mersenneNumber = (1L << p) - 1; // Obliczenie liczby Mersenne'a

        long s = 4; // Wartość początkowa dla testu Lucasa-Lehmera

        for (int i = 3; i <= p; i++) {
            s = (s * s - 2) % mersenneNumber;
        }

        return s == 0; // Wynik testu Lucasa-Lehmera
    }

    public static void main(String[] args) {
        ArrayList<Integer> primes = new ArrayList<>();

        // Szukanie liczb pierwszych p takich, że 2^p - 1 < 2^32
        for (int p = 2; p < 32; p++) {
            if (isPrime(p)) {
                primes.add(p);
            }
        }

        // Wyświetlanie wyników
        for (int p : primes) {
            long mersenneNumber = (1L << p) - 1;
            boolean probne = isPrime((int)mersenneNumber);
            boolean lucasLehmer = lucasLehmerTest(p);
            System.out.println("2^" + p + " - 1 = " + mersenneNumber + " Probne: " + probne + " Lucas-Lehmer: " + lucasLehmer);
        }
    }
}