package Common;

public class StackRecursive {
    int data;
    StackRecursive rest;

    StackRecursive(int data, StackRecursive rest) {
        this.data = data;
        this.rest = rest;
    }

    StackRecursive(int data) {
        this.data = data;
        this.rest = null;
    }

    int pop(){
        if (this.rest == null) {
            throw new RuntimeException("");
        }
        int temp = this.data;
        this.data = this.rest.data;
        this.rest = this.rest.rest;
        return temp;
    }

    void push(int data) {
        this.rest = new StackRecursive(this.data, this.rest);
        this.data = data;
    }

    public static void recursivePrint(StackRecursive stack, StringBuilder sb) {
        if (stack.rest != null) {
            recursivePrint(stack.rest, sb);
            sb.append(", ");
        }
        sb.append(stack.data);
    }

    public String toString2() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        recursivePrint(this, sb);
        sb.append(']');
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StackRecursive pointer = this;
        sb.append("[");
        while (pointer.rest !=null) {
            sb.append(pointer.data);
            sb.append(", ");
            pointer = pointer.rest;
        }
        sb.append(pointer.data);
        sb.append("]");
        return sb.toString();
    }

    public static StackRecursive fromArray(int[] array) {
        StackRecursive s = new StackRecursive(array[0]);
        for (int i = 1; i < array.length; i++) {
            s.push(array[i]);
        }
        return s;
    }

    public static void main(String[] args) {
        int[] array;
        StackRecursive stack;
        String actual, expected;

        System.out.println("Test #1");
        array = new int[] {1, 2, 3, 4};
        stack = StackRecursive.fromArray(array);
        actual = stack.toString2();
        System.out.println("  Actual: " + actual);
        expected = "[1, 2, 3, 4]";
        System.out.println("  Expected: "+ expected);

        System.out.println("Run Complete.");

        System.out.println("Test #2");
        stack.pop();
        actual = stack.toString2();
        System.out.println("  Actual: " + actual);
        expected = "[1, 2, 3]";
        System.out.println("  Expected: "+ expected);

        System.out.println("Test #3");
        stack.push(4);
        stack.push(5);
        actual = stack.toString2();
        System.out.println("  Actual: " + actual);
        expected = "[1, 2, 3, 4, 5]";
        System.out.println("  Expected: "+ expected);
    }
}

// CompilationErrors
// 1) Exception vs. RuntimeException?