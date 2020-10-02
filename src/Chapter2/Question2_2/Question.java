package Chapter2.Question2_2;

import Common.LinkedListNode;

public class Question {

    public static int kthFromLast(LinkedListNode node, int k) {
        LinkedListNode leadPointer = node;
        LinkedListNode trailPointer = node;
        if (k <= 0) {
            throw new RuntimeException("k must be positive");
        }
        int i = 0;

        while (leadPointer != null) {
            if (i < k) {
                i++;
            } else {
                trailPointer = trailPointer.next;
            }
            leadPointer = leadPointer.next;
        }
        if (i < k) {
            throw new RuntimeException("k must be less than or equal to the length of the list.");
        } else {
            return trailPointer.data;
        }
    }

    public static void main(String[] args) {

        System.out.println("Test 1:");
        int[] array1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        LinkedListNode node1 = LinkedListNode.fromArray(array1);
        System.out.println("  Linked List: " + node1.toString());
        int k1 = 3;
        System.out.println("  k: " + k1);
        int actual1 = kthFromLast(node1, k1);
        System.out.println("  Actual: " + actual1);
        int expected1 = 7;
        System.out.println("  Expected: " + expected1);

        System.out.println("Test 2:");
        int[] array2 = new int[]{1, 2, 3, 4, 5};
        LinkedListNode node2 = LinkedListNode.fromArray(array2);
        System.out.println("  Linked List: " + node2.toString());
        int k2 = 1;
        System.out.println("  k: " + k2);
        int actual2 = kthFromLast(node2, k2);
        System.out.println("  Actual: " + actual2);
        int expected2 = 5;
        System.out.println("  Expected: " + expected2);

        System.out.println("Test 3:");
        int[] array3 = new int[]{1, 2, 3};
        LinkedListNode node3 = LinkedListNode.fromArray(array3);
        System.out.println("  Linked List: " + node3.toString());
        int k3 = 4;
        System.out.println("  k: " + k3);
        try {
            int data = kthFromLast(node3, k3);
            System.out.println("  data: " + data);
        } catch (RuntimeException e) {
            System.out.println("  Error: " + e.getMessage());
        }

        System.out.println("Test 4:");
        int[] array4 = new int[]{1, 2, 3};
        LinkedListNode node4 = LinkedListNode.fromArray(array4);
        System.out.println("  Linked List: " + node4.toString());
        int k4 = 3;
        System.out.println("  k: " + k4);
        int actual4 = kthFromLast(node4, k4);
        System.out.println("  Actual: " + actual4);
        int expected4 = 1;
        System.out.println("  Expected: " + expected4);

        System.out.println("Test 5:");
        int[] array5 = new int[]{1, 2, 3};
        LinkedListNode node5 = LinkedListNode.fromArray(array5);
        System.out.println("  Linked List: " + node5.toString());
        int k5 = 0;
        System.out.println("  k: " + k5);
        try {
            int data = kthFromLast(node5, k5);
            System.out.println("  data: " + data);
        } catch (RuntimeException e) {
            System.out.println("  Error: " + e.getMessage());
        }

        System.out.println("Run Complete");
    }
}
