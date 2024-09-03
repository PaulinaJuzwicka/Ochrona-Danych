import java.util.*;

public class Main {

    // 1. Znajdowanie wszystkich liczb pierwszych mniejszych od zadanej liczby
    public static List<Integer> sieve(int n) {
        boolean[] prime = new boolean[n];
        Arrays.fill(prime, true);
        prime[0] = prime[1] = false;
        for (int p = 2; p * p < n; p++) {
            if (prime[p]) {
                for (int i = p * p; i < n; i += p) {
                    prime[i] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i < n; i++) {
            if (prime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }

    // 2. Suma wszystkich liczb pierwszych mniejszych niż n
    public static int sumOfPrimes(int n) {
        List<Integer> primes = sieve(n);
        int sum = 0;
        for (int prime : primes) {
            sum += prime;
        }
        return sum;
    }

    // 3. Wizualizacja pracy sita Eratostenesa (przykład szkieletowy, bez implementacji)
    // Możesz użyć JavaFX lub innej biblioteki do wizualizacji

    // 4. Optymalizacja sita Eratostenesa
    public static List<Integer> optimizedSieve(int n) {
        if (n < 2) return Collections.emptyList();
        boolean[] prime = new boolean[n / 2];
        Arrays.fill(prime, true);
        prime[0] = false;
        for (int i = 1; 2 * i * (i + 1) < n; i++) {
            if (prime[i]) {
                for (int j = 2 * i * (i + 1); j < n / 2; j += 2 * i + 1) {
                    prime[j] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        for (int i = 1; i < n / 2; i++) {
            if (prime[i]) {
                primes.add(2 * i + 1);
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        // Testowanie funkcji
        System.out.println(sieve(50)); // [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]
        System.out.println(sumOfPrimes(50)); // 328
        System.out.println(optimizedSieve(50)); // [2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]
    }
}
