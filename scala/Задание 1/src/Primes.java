public class Primes {
    public static void main(String[] arg){
        int s = 100;
        for (int i = 2; i < s; i++){
            if (isPrimes(i) == 0) System.out.println(i +"\t");
        }
    }
    public static int isPrimes(int n){
        boolean e = true;
        for (int i = 2; i < n && e; i++)
           e = n % i >= 1;
           return e ? n : -1;
    }
}
