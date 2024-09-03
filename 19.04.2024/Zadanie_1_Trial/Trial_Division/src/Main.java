//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int number = 17; // Przykładowa liczba do sprawdzenia
        boolean isPrime = isPrime(number);
        System.out.println(number + " jest liczbą pierwszą: " + isPrime);
    }

    // Funkcja sprawdzająca czy liczba jest liczbą pierwszą
    public static boolean isPrime(int number) {
        // Liczby mniejsze lub równe 1 nie są liczbami pierwszymi
        if (number <= 1) {
            return false;
        }
        // Liczba 2 jest liczbą pierwszą
        if (number == 2) {
            return true;
        }
        // Sprawdzanie czy liczba jest podzielna przez liczby od 2 do pierwiastka kwadratowego z tej liczby
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false; // Jeśli liczba jest podzielna przez jakąkolwiek inną liczbę niż 1 i sama przez siebie, nie jest pierwsza
            }
        }
        return true; // Jeśli nie znaleziono dzielników, liczba jest pierwsza
    }
}