import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int X = 10; // Przykładowa wartość X
        int Y = 50; // Przykładowa wartość Y

        List<Integer> primes = findPrimesInRange(X, Y);
        System.out.println("Liczby pierwsze w przedziale od " + X + " do " + Y + ": " + primes);
        System.out.println("Ilość liczb pierwszych: " + primes.size());
    }

    public static List<Integer> findPrimesInRange(int X, int Y) {
        List<Integer> primes = new ArrayList<>();
        for (int i = X; i <= Y; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        return primes;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
