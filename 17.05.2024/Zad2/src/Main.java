public class Main {

    // Szybkie potęgowanie metodą rozkładu na dwójkowy
    public static long fastModuloPower(long base, long exponent, long modulus) {
        if (modulus == 1) return 0;
        long result = 1;
        base = base % modulus;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (result * base) % modulus;
            }
            exponent >>= 1;
            base = (base * base) % modulus;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(fastModuloPower(123, 456, 789)); // 699
        System.out.println(fastModuloPower(19, 1, 23));     // 19
        System.out.println(fastModuloPower(256, 40, 100));  // 76
        System.out.println(fastModuloPower(4321, 5678, 9876)); // 8941
    }
}
