package Chapter3.Question3_1;

import java.util.Arrays;

public class Question {
    static class TriStack {
        int[] array;
        int[] lengths;

        TriStack() {
            this.array = new int[15];
            this.lengths = new int[3];
        }

        void push(int data, int ind) {
            int index = (3 * this.lengths[ind]) + ind;
            if (index >= this.array.length) {
                this.array = Arrays.copyOf(this.array, this.array.length * 2);
            }
            this.array[index] = data;
            this.lengths[ind] ++;
        }

        int pop(int ind) {
            if (this.lengths[ind] == 0) {
                throw new RuntimeException("Cannot pop from empty stack.");
            }
            int index = (3 * (this.lengths[ind] - 1)) + ind;
            int value = this.array[index];
            this.array[index] = 0;
            this.lengths[ind] --;

            int maxLength = 0;
            for (int len : this.lengths) {
                maxLength = Math.max(maxLength, len);
            }
            if (maxLength <= (this.array.length / 6)) {
                this.array = Arrays.copyOf(this.array, this.array.length / 2);
            }
            return value;
        }
    }

    public static void main(String[] args) {
        TriStack triStack;
        String actual, expected;

        System.out.println("Test #1");
        triStack = new TriStack();
        triStack.push(1, 0);
        triStack.push(2, 0);
        triStack.push(3, 0);
        triStack.push(4, 1);
        triStack.push(5, 1);
        triStack.push(6, 1);
        triStack.push(7, 2);
        triStack.push(8, 2);
        triStack.push(9, 2);

        actual = Arrays.toString(triStack.array);
        System.out.println("  Actual: " + actual);
        expected = "[1, 4, 7, 2, 5, 8, 3, 6, 9, 0, 0, 0, 0, 0, 0]";
        System.out.println("  Expected: " + expected);


        System.out.println("Test #2");
        triStack = new TriStack();
        triStack.push(1, 0);
        triStack.push(2, 0);
        triStack.push(3, 0);
        triStack.push(4, 0);
        triStack.push(5, 0);
        triStack.push(6, 0);

        actual = Arrays.toString(triStack.array);
        System.out.println("  Actual: " + actual);
        expected = "[1, 0, 0, 2, 0, 0, 3, 0, 0, 4, 0, 0, 5, 0, 0, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]";
        System.out.println("  Expected: " + expected);


        System.out.println("Test #3");
        triStack = new TriStack();
        triStack.push(1, 0);
        triStack.push(2, 0);
        triStack.push(3, 0);
        triStack.push(4, 0);
        triStack.push(5, 0);
        triStack.push(6, 0);
        triStack.pop(0);
        triStack.pop(0);

        actual = Arrays.toString(triStack.array);
        System.out.println("  Actual: " + actual);
        expected = "[1, 0, 0, 2, 0, 0, 3, 0, 0, 4, 0, 0, 0, 0, 0]";
        System.out.println("  Expected: " + expected);
    }
}

// Errors
//
// 1) Inner class must be static.
// 2) java.util.Arrays.toString()