public class Polindrome {
    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            String s = args[i];
            if (isPalindrome(s)) {
                // Вывод результата
                System.out.println(s + "");
            }
        }
    }

    public static boolean isPalindrome(String s) {
        boolean p = s.equals(reverseString(s));
        // Проверяем на совпадение
        return p;
    }

    public static String reverseString(String s) {
        // Создание пустой строчки
        String w = "";
        // Пробег по первоначальной строчке
        for (int i = s.length()-1; i >= 0; i--) {
            w += s.charAt(i);
        }
        return w;
    }
}
