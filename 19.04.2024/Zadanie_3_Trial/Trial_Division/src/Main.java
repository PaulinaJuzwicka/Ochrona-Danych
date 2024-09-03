//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int num1 = 48; // Pierwsza liczba
        int num2 = 60; // Druga liczba

        int gcd = findGCD(num1, num2);
        System.out.println("Największy wspólny dzielnik dla " + num1 + " i " + num2 + " wynosi: " + gcd);
    }

    // Funkcja znajdująca największy wspólny dzielnik (NWD) za pomocą metody Trial Division
    public static int findGCD(int num1, int num2) {
        // Sprawdzamy, czy któreś z liczb nie jest zerem
        if (num1 == 0) {
            return num2;
        }
        if (num2 == 0) {
            return num1;
        }

        // Iteracyjnie znajdujemy największy wspólny dzielnik
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }

        return num1; // num1 zawiera teraz NWD
    }
}