import java.util.Scanner;

public class Primes {
    public static boolean IsPrimes (int p) {
        boolean simple = true;
        for (int i = 2; i < p && simple; i++) {
            simple = p % i >= 1;
        }
        return simple;
    }

    public static void main (String[] args) {
        int x = 100;
        for (int i = 2; i <= x; i++) {
            //Вывод простых чисел
            if (IsPrimes(i)) {
                System.out.println(i);
            }
        }
    }
}
