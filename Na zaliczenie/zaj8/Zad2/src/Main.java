import java.util.Scanner;

public class Main {

    // Funkcja do obliczania a^b % c przy użyciu szybkiego potęgowania modularnego
    public static long powmod(long a, long b, long c) {
        long result = 1;
        a = a % c;  // Zmniejszamy a jeśli jest większe niż c

        while (b > 0) {
            // Jeśli b jest nieparzyste, mnożymy wynik przez a i b zmniejszamy o 1
            if ((b & 1) == 1) {
                result = (result * a) % c;
            }
            // Teraz b musi być parzyste, więc dzielimy b przez 2
            b = b >> 1;
            a = (a * a) % c;  // Kwadratujemy a i bierzemy resztę z dzielenia przez c
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pobieranie danych wejściowych od użytkownika
        System.out.print("Podaj wartość p (liczba pierwsza): ");
        long p = scanner.nextLong();

        System.out.print("Podaj wartość g (generator): ");
        long g = scanner.nextLong();

        System.out.print("Podaj wartość a (prywatna wartość Alice): ");
        long a = scanner.nextLong();

        // Obliczanie A = g^a % p
        long A = powmod(g, a, p);
        System.out.println("Wartość A (g^a % p) wynosi: " + A);

        // Pobieranie wartości B od użytkownika
        System.out.print("Podaj wartość B (otrzymana od Boba): ");
        long B = scanner.nextLong();

        // Obliczanie wspólnego klucza k = B^a % p
        long k = powmod(B, a, p);
        System.out.println("Wspólny klucz k (B^a % p) wynosi: " + k);

        scanner.close();
    }
}
