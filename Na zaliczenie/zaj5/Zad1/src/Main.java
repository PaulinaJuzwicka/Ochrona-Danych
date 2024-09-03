import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // 1. Sprawdzanie, czy liczba jest pierwsza
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    // 2. Lista liczb pierwszych w zadanym zakresie
    public static List<Integer> primesInRange(int start, int end) {
        List<Integer> primes = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    // 3. Największy wspólny dzielnik (NWD)
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 4. Trial Division z liczbą wykonanych kroków
    public static List<Object> trialDivisionWithSteps(int n) {
        List<Integer> divisors = new ArrayList<>();
        int steps = 0;
        for (int i = 1; i <= n; i++) {
            steps++;
            if (n % i == 0) {
                divisors.add(i);
            }
        }
        List<Object> result = new ArrayList<>();
        result.add(divisors);
        result.add(steps);
        return result;
    }

    // 5. Czynniki pierwsze i ich produkt
    public static boolean verifyPrimeFactors(int n) {
        List<Integer> factors = primeFactors(n);
        int product = 1;
        for (int factor : factors) {
            product *= factor;
        }
        return product == n;
    }

    private static List<Integer> primeFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        return factors;
    }

    public static void main(String[] args) {
        // Testowanie funkcji
        System.out.println(isPrime(29)); // true
        System.out.println(primesInRange(10, 50)); // [11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]
        System.out.println(gcd(56, 98)); // 14
        System.out.println(trialDivisionWithSteps(28)); // [[1, 2, 4, 7, 14, 28], 28]
        System.out.println(verifyPrimeFactors(28)); // true
    }
}
