package Common;

public class QueueRecursive {
    int data = 0;
    QueueRecursive rest = null;

    public QueueRecursive(int data, QueueRecursive rest) {
        this.data = data;
        this.rest = rest;
    }

    public QueueRecursive(int data) {
        this.data = data;
    }

    void enqueue(int data) {
        QueueRecursive pointer = this;
        while (pointer.rest != null) {
            pointer = pointer.rest;
        }
        pointer.rest = new QueueRecursive(data);
    }

    int dequeue() {
        int temp = this.data;
        if (this.rest != null) {
            this.data = this.rest.data;
            this.rest = this.rest.rest;
        }
        return temp;
    }

    static QueueRecursive fromArray(int[] array) {
        if (array.length == 0) {
            throw new RuntimeException("Queue has no length");
        }
        QueueRecursive queue = new QueueRecursive(array[0]);
        System.out.println("Initialized queue with value: " + array[0]);
        for (int i = 1; i < array.length; i++) {
            System.out.println("Enqueueing value: " + array[i]);
            queue.enqueue(array[i]);
        }
        return queue;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        QueueRecursive pointer = this;
        while (pointer.rest != null) {
            sb.append(pointer.data);
            sb.append(", ");
            pointer = pointer.rest;
        }
        sb.append(pointer.data);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Test #1:");
        int[] array = new int[] {1, 2, 3, 4, 5};
        QueueRecursive queue = QueueRecursive.fromArray(array);
        System.out.println("  Queue: " + queue.toString());

        System.out.println("Run Complete.");
    }
}
