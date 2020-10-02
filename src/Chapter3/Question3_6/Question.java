package Chapter3.Question3_6;

//import java.util.Stack;


import java.lang.Integer;;
import Common.Stack;
import java.util.LinkedList;

class Question {

    public static void scratch() {
        LinkedList<Integer> l = new LinkedList<>();
        l.add(1);
        l.add(2);
        LinkedList<Integer> m = new LinkedList<>();
        m.add(0);
        m.addAll(l);
        l = m;
        System.out.println("  List:" + l.toString());
    }

    public static void moveAll(Stack fromStack, Stack toStack, int ignore) {
        while (!fromStack.isEmpty()) {
            if (fromStack.peek() == ignore) {
                fromStack.pop();
            } else {
                toStack.push(fromStack.pop());
            }
        }
    }

    public static void pushConstant(Stack stack, int constant, int times) {
        while (times > 0) {
            stack.push(constant);
            times --;
        }
    }

    public static int sortOnce(Stack stack, Stack otherStack, int previousMin) {
        System.out.println("      sortOnce() previousMin: " + previousMin);

        int min = Integer.MAX_VALUE;
        int count = 0;

        while ((!stack.isEmpty()) && (stack.peek() > previousMin)) {

            if (stack.peek() < min) {
                min = stack.peek();
                count = 1;
            } else if (stack.peek() == min) {
                count ++;
            }
            otherStack.push(stack.pop());
        }

        System.out.println("      Found (min, count): (" + min + ", " + count + ")");
        pushConstant(stack, min, count);
        moveAll(otherStack, stack, min);

        return min;
    }

    public static void sort(Stack stack) {

        int min = Integer.MIN_VALUE;
        Stack otherStack = new Stack();

        do {
            min = sortOnce(stack, otherStack, min);
        } while ( min < Integer.MAX_VALUE );
    }

    public static void main(String[] args) {
        Stack stack;

        System.out.println("Test #1:");
        stack = Stack.fromArray(new int[] {1, 5, 7, 2, 9, 7, 1, 1, 6, 0, 3, 4, 0, 2, 0, 5});
        System.out.println("  Original Stack: " + stack);
        sort(stack);
        System.out.println("  Sorted Stack: " + stack);

        System.out.println("Test #2:");
        stack = Stack.fromArray(new int[] {1, 2, 3, 4, 5, 4, 3, 2, 1});
        System.out.println("  Original Stack: " + stack);
        sort(stack);
        System.out.println("  Sorted Stack: " + stack);

        scratch();

        System.out.println("Run complete.");
    }
}

// THOUGHTS
//
// COMPILATION ERRORS:
// 1) Don't forget "static" and don't use "this" when calling static methods.
// 2) "&&" short-circuits, but "&" doesn't