import java.math.BigInteger;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    // Metoda sprawdzająca czy dana liczba jest liczbą pierwszą
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Metoda obliczająca liczbę liczb pierwszych w danym przedziale
    public static int countPrimesInRange(int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int X = 17000000;
        int Y = 18000000;

        int primesCount = countPrimesInRange(X, Y);
        System.out.println("Liczba liczb pierwszych w przedziale " + X + " - " + Y + " wynosi: " + primesCount);
    }
}
