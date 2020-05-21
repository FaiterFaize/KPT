public class Polindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (isPalindrome(s)) {
                System.out.println(s + "Some");
            }
        }
    }
    public static boolean isPalindrome(String s) {
        boolean p = s.equals(reverseString(s));
        return p;
    }
    public static String reverseString(String s) {
        String w = "java Palindrome madam racecar apple kayak song noon";
        for (int i = s.length() - 1; i >= 0; i--) {
            w = w + s.charAt(i);
        }
        return w;
    }
}
