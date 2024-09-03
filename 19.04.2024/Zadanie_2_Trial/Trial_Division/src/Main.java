import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int start = 10; // Przykładowy początek zakresu
        int end = 50; // Przykładowy koniec zakresu
        List<Integer> primes = findPrimesInRange(start, end);
        System.out.println("Liczby pierwsze w zakresie od " + start + " do " + end + ": " + primes);
    }

    // Funkcja znajdująca wszystkie liczby pierwsze w danym zakresie
    public static List<Integer> findPrimesInRange(int start, int end) {
        List<Integer> primes = new ArrayList<>();

        // Iteracja przez zakres od start do end
        for (int number = start; number <= end; number++) {
            if (isPrime(number)) {
                primes.add(number);
            }
        }

        return primes;
    }

    // Funkcja sprawdzająca czy liczba jest liczbą pierwszą
    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}