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
        // Przykład użycia powmod
        long a = 2;
        long b = 5;
        long c = 7;
        System.out.println(a + " ^ "+ b + " % " + c + " = " + powmod(a, b, c));  // Oczekiwany wynik: 4
    }
}
