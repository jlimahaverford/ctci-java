package Chapter1.Question1_2;

public class Question {

    public static String reverseString(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int n = s.length();
        for (int i = n-1; i >= 0; i--) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static void reverseCharArray(char[] str) {
        int n = str.length;

        for (int i = 0; i < n/2; i++) {
            char temp = str[i];
            str[i] = str[n-1-i];
            str[n-1-i] = temp;
        }
    }

    public static void main(String[] args) {
        char x = "a".charAt(0);
        System.out.println(x);

        System.out.println("1 Actual: " + reverseString("abc"));
        System.out.println("1 Expected: " + "cba");

        System.out.println("2 Actual: " + reverseString(""));
        System.out.println("2 Expected: " + "");

        System.out.println("3 Actual: " + reverseString("123"));
        System.out.println("3 Expected: " + "321");

        System.out.println("4 Actual: " + reverseString("aaaa"));
        System.out.println("4 Expected: " + "aaaa");

        char[] str = "abcde".toCharArray();
        System.out.println("Before: " + new String(str));
        reverseCharArray(str);
        System.out.println("After: " + new String(str));

        System.out.println("Complete");
    }
}

// Compilation Errors
// 1) Missing ";"
// 2) StringBuilder/StringBuffer when want append
// 3) String.charAt(i) instead of String[i]