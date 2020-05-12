public class Palindrome {
    public static boolean Pali(String s){
        int leng = s.length() - 1;
        int midle = (leng / 2) + (leng % 2);
        for (int i = 0; i < midle; i++)
            if(s.charAt(i) != s.charAt(leng - 1)){
                return false;
            }
        return true;
    }
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (Pali(args[i])) System.out.print(args[i] + "Палиндром\n");
        else System.out.print(args[i] + "Не палиндром");
        }
    }
}