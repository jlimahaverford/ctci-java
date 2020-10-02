package Chapter1.Question1_4;

public class Question {

    public static void replaceSpaces(char[] str) {
        int outPointer = str.length - 1;
        int inPointer = str.length - 1;
        while (outPointer > 0) {
            while (str[inPointer] == ' ') {
                inPointer --;
            }
            while ((str[inPointer] != ' ') & (outPointer > 0)) {
                str[outPointer] = str[inPointer];
                inPointer --;
                outPointer --;
            }

            if (outPointer > 0) {
                str[outPointer] = '0';
                str[outPointer-1] = '2';
                str[outPointer-2] = '%';
                outPointer = outPointer - 3;
                inPointer --;
            }
        }
    }

    public static void main(String[] args) {

        String s = "Mr. John Smith    ";
        char[] str = s.toCharArray();
        replaceSpaces(str);

        System.out.println("1 Input: " + s);
        System.out.println("1 Output: " + new String(str));

        System.out.println("Run Complete");
    }

}

// Compilation Errors
// 1) Missing ";"
// 2) " Versus '