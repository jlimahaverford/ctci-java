package Chapter1.Question1_5;

public class Question {

    public static String compress(String str) {
        int n = str.length();
        int cursor = 0;
        StringBuilder stringBuilder = new StringBuilder();

        while (cursor < n) {
            System.out.println("Outside:" + cursor);
            char value = str.charAt(cursor);
            int count = 0;

            while ((cursor < n) && (str.charAt(cursor) == value)) {
                System.out.println("Inside:" + cursor);
                cursor ++;
                count ++;
            }

            stringBuilder.append(value);
            stringBuilder.append(count);
        }

        String outStr = stringBuilder.toString();
        System.out.println("outStr:" + outStr);
        if (outStr.length() < n) {
            return outStr;
        } else {
            return str;
        }
    }

    public static void main(String[] args) {
        System.out.println("1 Actual: " + compress("aaaabbccccd"));
        System.out.println("1 Expected: " + "a4b2c4d1");

        System.out.println("Run Complete");
    }
}

// Compilation Errors
// 1) Not Declaring Variables
// 2) String.length() has parentheses!
// 3) Use String.valueOf()
//
// Algorithm Thoughts
// 1) Could have counted length (thought of but did not implement)
// 2) Could have used char[] instead of StringBuffer (harder but less reliance on Java classes)