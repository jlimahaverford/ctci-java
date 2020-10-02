package Chapter1.Question1_3;

import java.util.HashMap;
import java.util.Map;

public class Question {

    public static int[] tallyStringArray(String str) {
        int[] tallies = new int[256];
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i);
            tallies[index]++;
        }
        return tallies;
    }

    public static HashMap<Character, Integer> tallyStringHashMap(String str) {
        HashMap<Character, Integer> tallies = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character key = str.charAt(i);
            Integer value = tallies.get(key);
            if (value == null) {
                tallies.put(key, 0);
            } else {
                tallies.put(key, value+1);
            }
        }
        return tallies;
    }

    public static boolean isPermutationArray(String str, String otherStr) {
        int[] strTally = tallyStringArray(str);
        int[] otherStrTally = tallyStringArray(otherStr);

        for (int i = 0; i < 256; i++) {
            if (strTally[i] != otherStrTally[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPermutationHashMap(String str, String otherStr) {
        HashMap<Character, Integer> strTally = tallyStringHashMap(str);
        HashMap<Character, Integer> otherStrTally = tallyStringHashMap(otherStr);

        if (strTally.size() != otherStrTally.size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : strTally.entrySet()) {
            if (entry.getValue() != otherStrTally.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        System.out.println("1 Actual: " + isPermutationHashMap("abc", "cba"));
        System.out.println("1 Expected: " + true);

        System.out.println("2 Actual: " + isPermutationHashMap("abcabc", "acbacb"));
        System.out.println("2 Expected: " + true);

        System.out.println("3 Actual: " + isPermutationHashMap("abc", "dba"));
        System.out.println("3 Expected: " + false);

        System.out.println("4 Actual: " + isPermutationHashMap("abc", "123"));
        System.out.println("4 Expected: " + false);

        System.out.println("Run Complete");
    }
}

// Compilation Errors
// 1) Missing variable declarations (especially in loops)
// 2) Missing ";"