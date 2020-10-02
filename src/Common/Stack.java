package Common;

public class Stack {
    LinkedListNode top;
    int length;

    public Stack(LinkedListNode top, int length) {
        this.top = top;
        this.length = length;
    }

    public Stack(int data) {
        this(new LinkedListNode(data), 1);
    }

    public Stack() {
        this(null, 0);
    }

    public int size() {
        return this.length;
    }

    public boolean isEmpty() {
        return (this.top == null);
    }

    public void push(int data) {
        LinkedListNode newTop = new LinkedListNode(data);
        newTop.next = this.top;
        this.top = newTop;
        this.length ++;
    }

    public int pop(){
        if (this.size() == 0) {
            throw new RuntimeException("Stack is empty.  Cannot pop().");
        }
        int data = this.top.data;
        this.top = this.top.next;
        this.length --;
        return data;
    }

    public int peek(){
        if (this.size() == 0) {
            throw new RuntimeException("Stack is empty.  Cannot peek().");
        }
        return this.top.data;
    }

    public static void recursivePrint(LinkedListNode node, StringBuilder sb) {
        if (node.next != null) {
            recursivePrint(node.next, sb);
            sb.append(", ");
        }
        sb.append(node.data);
    }

    public String toString2() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        recursivePrint(this.top, sb);
        sb.append(']');
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        LinkedListNode pointer = this.top;
        sb.append("[");
        if (pointer != null) {
            while (pointer != null && pointer.next != null) {
                sb.append(pointer.data);
                sb.append(", ");
                pointer = pointer.next;
            }
            sb.append(pointer.data);
        }
        sb.append("]");
        return sb.toString();
    }

    public static Stack fromArray(int[] array) {
        Stack s = new Stack(array[0]);
        for (int i = 1; i < array.length; i++) {
            s.push(array[i]);
        }
        return s;
    }

    public static void main(String[] args) {
        int[] array;
        Stack stack;
        String actual, expected;

        System.out.println("Test #1");
        array = new int[] {1, 2, 3, 4};
        stack = Stack.fromArray(array);
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