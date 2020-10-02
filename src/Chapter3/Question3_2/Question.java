package Chapter3.Question3_2;

import Common.Stack;

public class Question {
    static class MinStack {
        Stack top;
        Stack minTop;
        Stack minLengths;
        int length;

        public MinStack() {
            this.top = null;
            this.minTop = null;
            this.minLengths = null;
            this.length = 0;
        }

        public void push(int data) {
            if (this.top == null) {
                this.length++;
                this.top = new Stack(data);
                this.minTop = new Stack(data);
                this.minLengths = new Stack(1);
            } else {
                this.length++;
                this.top.push(data);
                if (data < this.minTop.peek()) {
                    this.minTop.push(data);
                    this.minLengths.push(this.length);
                }
            }
        }

        public int peek() {
            if (this.top == null) {
                throw new RuntimeException("Stack is empty.  Can not pop()");
            } else {
                return this.top.peek();
            }
        }

        public int pop() {
            if (this.top == null) {
                throw new RuntimeException("Stack is empty.  Can not pop()");
            } else {
                int temp = this.top.pop();
                System.out.println("    this.length: " + this.length);
                System.out.println("    this.minLengths.peeks(): " + this.minLengths.peek());
                if (this.length == this.minLengths.peek()) {
                    System.out.println("    Popping min stacks.");
                    this.minLengths.pop();
                    this.minTop.pop();
                }
                this.length--;
                return temp;
            }
        }

        int min() {
            if (this.top == null) {
                throw new RuntimeException("Stack is empty.  Can not get()");
            } else {
                return this.minTop.peek();
            }
        }
    }

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(6);
        stack.push(2);
        stack.push(4);
        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(1);

        System.out.println("Test #1:");
        int actual1 = stack.min();
        int expected1 = 1;
        System.out.println("  Actual: " + actual1);
        System.out.println("  Expected: " + expected1);

        System.out.println("Popping: " + stack.pop());

        System.out.println("Test #2:");
        int actual2 = stack.min();
        int expected2 = 2;
        System.out.println("  Actual: " + actual2);
        System.out.println("  Expected: " + expected2);

        System.out.println("Popping: " + stack.pop());
        System.out.println("Popping: " + stack.pop());
        System.out.println("Popping: " + stack.pop());
        System.out.println("Popping: " + stack.pop());
        System.out.println("Popping: " + stack.pop());

        System.out.println("Test #3:");
        int actual3 = stack.min();
        int expected3 = 6;
        System.out.println("  Actual: " + actual3);
        System.out.println("  Expected: " + expected3);

        System.out.println("Run Complete.");
    }

}