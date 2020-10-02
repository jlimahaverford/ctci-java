package Chapter3.Question3_3;

import Common.Stack;
import java.util.ArrayList;

class Question {

    public static class SetOfStacks {
        ArrayList<Stack> stacks;
        int threshold = 5;

        public SetOfStacks() {
            Stack stack = new Stack();
            this.stacks = new ArrayList<>();
            this.stacks.add(stack);
        }

        public void push(int data) {
            Stack lastStack = this.stacks.get(this.stacks.size() - 1);
            if (lastStack.size() == this.threshold) {
                lastStack = new Stack();
                this.stacks.add(lastStack);
            }
            lastStack.push(data);
        }

        public int pop() {
            int length = this.stacks.size();
            Stack lastStack = this.stacks.get(length - 1);

            if ((length == 1) && (lastStack.size() == 0)) {
                throw new RuntimeException("Stack is empty.  Cannot pop.");
            }

            int data = lastStack.pop();
            if (lastStack.size() == 0) {
                this.stacks.remove(length-1);
            }
            return data;
        }

        public int popAt(int index) {
            int length = this.stacks.size();
            if (index >= length) {
                throw new RuntimeException("Cannot pop at index " + index + ".  There are only " + length +  " stacks.");
            }
            Stack stack = this.stacks.get(index);
            int stackLength = stack.size();
            if (stackLength > 0) {
                int data = stack.pop();
                if (stackLength == 1) {
                    this.stacks.remove(index);
                }
                return data;
            } else {
                throw new RuntimeException("The stack at index " + index + " is empty.  Can not pop().");
            }
        }
    }

    public static void main(String[] args) {
        int actual, expected;
        SetOfStacks s = new SetOfStacks();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        s.push(8);
        s.push(9);
        s.push(10);
        s.push(11);

        System.out.println("Test #1:");
        actual = s.pop();
        expected = 11;
        System.out.println("  Actual: " + actual);
        System.out.println("  Expected: " + expected);

        System.out.println("Test #2:");
        actual = s.stacks.size();
        expected = 2;
        System.out.println("  Actual: " + actual);
        System.out.println("  Expected: " + expected);

        System.out.println("Test #3:");
        actual = s.pop();
        expected = 10;
        System.out.println("  Actual: " + actual);
        System.out.println("  Expected: " + expected);

        s.push(10);
        s.push(11);
        s.push(12);
        s.push(13);
        s.push(14);
        s.push(15);
        s.push(16);

        System.out.println("Test #4:");
        actual = s.popAt(1);
        expected = 10;
        System.out.println("  Actual: " + actual);
        System.out.println("  Expected: " + expected);

        System.out.println("Test #5:");
        actual = s.popAt(0);
        expected = 5;
        System.out.println("  Actual: " + actual);
        System.out.println("  Expected: " + expected);

        System.out.println("Run complete.");
    }

}