package Chapter1.Question1_1;

import java.util.HashSet;

public class Question {

    public static boolean hasUniqueChars(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                System.out.println(s.charAt(i) + ", " + s.charAt(j));
                if (s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean hasUniqueChars2(String s) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            if (set.size() < i+1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("1 Actual:" + hasUniqueChars2("abc"));
        System.out.println("1 Expected:" + true);
        System.out.println("2 Actual:" + hasUniqueChars2("abca"));
        System.out.println("2 Expected:" + false);
        System.out.println("Complete.");
    }
}