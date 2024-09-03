public class Main {

    // Iteracyjne mnożenie
    public static long iterativeModuloPower(long base, long exponent, long modulus) {
        long result = 1;
        base = base % modulus;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % modulus;
            }
            exponent = exponent >> 1;
            base = (base * base) % modulus;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(iterativeModuloPower(123, 456, 789)); // 699
        System.out.println(iterativeModuloPower(19, 1, 23));     // 19
        System.out.println(iterativeModuloPower(256, 40, 100));  // 76
        System.out.println(iterativeModuloPower(4321, 5678, 9876)); // 8941
    }
}
