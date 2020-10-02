package Common;

public class LinkedListNode {
    public LinkedListNode next;
    public int data;

    public LinkedListNode(int data) {
        this.data = data;
    }

    public static LinkedListNode fromArray(int[] array) {
        int length = array.length;
        if (length == 0) {
            throw new RuntimeException("Array is empty.");
        }
        LinkedListNode head = new LinkedListNode(array[0]);
        LinkedListNode current = head;
        for (int i = 1; i < length; i++) {
            current.next = new LinkedListNode(array[i]);
            current = current.next;
        }
        return head;
    }

    public void append(int data) {
        LinkedListNode pointer = this;
        while (pointer.next != null) {
            pointer = pointer.next;
        }
        pointer.next = new LinkedListNode(data);
    }

    public String toString() {
        LinkedListNode pointer = this;
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(pointer.data);
        while (pointer.next != null) {
            pointer = pointer.next;
            sb.append(", ");
            sb.append(pointer.data);
        }
        sb.append("]");
        return sb.toString();
    }

//    public Node reverseReturnTail() {
//        if (this.next == null) {
//            return this;
//        }
//        Node tailOfRest = this.next.reverseReturnTail();
//        this.next = null;
//        tailOfRest.next = this;
//        return this;
//    }
//
//    public void reverse() {
//        this.reverseReturnTail();
//    }
//
//    public Node reverse() {
//        Node pointer = this;
//        Node reversed = null;
//        while (pointer != null) {
//            if (reversed == null) {
//                reversed = new Node(pointer.data);
//            } else {
//                Node temp = new Node(pointer.data);
//                temp.next = reversed;
//                reversed = temp;
//            }
//            pointer = pointer.next;
//        }
//        return reversed;
//    }

    public LinkedListNode reverse() {
        LinkedListNode p1 = null;
        LinkedListNode p2 = this;

        while (p2 != null) {
            LinkedListNode p2Next = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p2Next;
        }

        return p1;
    }

    public static void main(String[] args) {
        System.out.println("Test 1:");
        LinkedListNode node1 = new LinkedListNode(1);
        node1.append(2);
        node1.append(3);
        node1.append(4);
        String actual1 = node1.toString();
        String expected1 = "[1, 2, 3, 4]";
        System.out.println("  actual: " + actual1);
        System.out.println("  expected: " + expected1);

        System.out.println("Test 2:");
        int[] array2 = new int[]{1, 2, 3, 4, 5};
        LinkedListNode node2 = LinkedListNode.fromArray(array2);
        String actual2 = node2.toString();
        String expected2 = "[1, 2, 3, 4, 5]";
        System.out.println("  actual: " + actual2);
        System.out.println("  expected: " + expected2);

        System.out.println("Test 3:");
        int[] array3 = new int[0];
        try {
            LinkedListNode node3 = LinkedListNode.fromArray(array3);
            System.out.println(node3.toString());
        } catch (Exception e) {
            System.out.println("  " + e.getMessage());
        }

        System.out.println("Test 4:");
        int[] array4 = new int[]{1, 2, 3, 4, 5};
        LinkedListNode node4 = LinkedListNode.fromArray(array2);
        String actual4 = node4.reverse().toString();
        String expected4 = "[5, 4, 3, 2, 1]";
        System.out.println("  actual: " + actual4);
        System.out.println("  expected: " + expected4);

        System.out.println("Run Complete");
    }
}