package Common;

public class Queue {
    LinkedListNode first, last;

    public Queue(LinkedListNode first, LinkedListNode last) {
        this.first = first;
        this.last = last;
    }

    public Queue(LinkedListNode first) {
        this(first, first);
    }

    public Queue(int data) {
        this(new LinkedListNode(data));
    }

    public Queue() {
        this(null, null);
    }

    void enqueue(int data) {
        if (this.first == null) {
            this.first = new LinkedListNode(data);
            this.last = this.first;
        } else {
            this.last.next = new LinkedListNode(data);
            this.last = this.last.next;
        }
    }

    int dequeue() {
        if (this.first == null) {
            throw new RuntimeException("Queue is empty");
        }
        int temp = this.first.data;
        this.first = this.first.next;
        return temp;
    }

    static Queue fromArray(int[] array) {
        Queue queue = new Queue();
        for (int data : array) {
            queue.enqueue(data);
        }
        return queue;
    }

    public String toString() {
        return this.first.toString();
    }

    public static void main(String[] args) {
        int[] array;
        Queue queue;
        String actual, expected;

        System.out.println("Test #1:");
        array = new int[]{1, 2, 3, 4, 5};
        queue = Queue.fromArray(array);
        actual = queue.toString();
        expected = "[1, 2, 3, 4, 5]";
        System.out.println("  Actual: " + actual);
        System.out.println("  Expected: " + expected);

        System.out.println("Test #2:");
        queue.dequeue();
        queue.dequeue();
        actual = queue.toString();
        expected = "[3, 4, 5]";
        System.out.println("  Actual: " + actual);
        System.out.println("  Expected: " + expected);

        System.out.println("Run Complete.");
    }
}
