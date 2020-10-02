package Chapter3.Question3_5;

import Common.Stack;

import java.util.Arrays;

class Question {

    public static class MyQueue {
        Stack newStack;
        Stack oldStack;

        public MyQueue(Stack newStack, Stack oldStack) {
            this.newStack = newStack;
            this.oldStack = oldStack;
        }

        public MyQueue() {
            this(new Stack(), new Stack());
        }

        public int size() {
            System.out.println("    size()");
            return this.newStack.size() + this.oldStack.size();
        }

        public void enqueue(int data) {
            System.out.println("    enqueue(" + data + ")");
            newStack.push(data);
        }

        public int dequeue() {
            System.out.println("    dequeue()");
            if (this.size() == 0) {
                throw new RuntimeException("Queue is empty.  Cannot dequeue()");
            }

            if (this.oldStack.size() == 0) {
                this.moveNewStackToOldStack();
            }

            return oldStack.pop();
        }

        void moveNewStackToOldStack() {
            System.out.println("    moveNewStackToOldStack()");
            int n = this.newStack.size();
            for (int i=0; i<n; i++) {
                int data = this.newStack.pop();
                this.oldStack.push(data);
            }
        }
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        System.out.println("Dequeueing: " + queue.dequeue());
        queue.enqueue(6);
        queue.enqueue(7);
        System.out.println("Dequeueing: " + queue.dequeue());
        System.out.println("Dequeueing: " + queue.dequeue());
        System.out.println("Dequeueing: " + queue.dequeue());
        System.out.println("Dequeueing: " + queue.dequeue());
        System.out.println("Dequeueing: " + queue.dequeue());
        System.out.println("Dequeueing: " + queue.dequeue());
        System.out.println("Run complete.");
    }
}