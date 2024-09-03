public class Main {
    public static void main(String[] args) {
        int limit = 32; // Zakres poniżej 2^32

        for (int p = 2; p < limit; p++) {
            if (isPrime(p)) {
                long mersenneNumber = (1L << p) - 1;
                boolean trialDivision = isPrime(mersenneNumber);
                boolean lucasLehmer = lucasLehmerTest(p);

                System.out.println("2^" + p + " - 1 = " + mersenneNumber +
                        " Probne: " + trialDivision +
                        " Lucas-Lehmer: " + lucasLehmer);
            }
        }
    }

    public static boolean isPrime(long number) {
        if (number <= 1) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean lucasLehmerTest(int p) {
        if (p == 2) {
            return true;
        }
        long s = 4;
        long m = (1L << p) - 1;
        for (int i = 0; i < p - 2; i++) {
            s = (s * s - 2) % m;
        }
        return s == 0;
    }
}
