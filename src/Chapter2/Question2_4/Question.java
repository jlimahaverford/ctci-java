package Chapter2.Question2_4;

import Common.LinkedListNode;

public class Question {

    public static void flip(LinkedListNode node1, LinkedListNode node2) {
        int temp = node1.data;
        node1.data = node2.data;
        node2.data = temp;
    }

    public static void flipNext(LinkedListNode node1, LinkedListNode node2, int k) {
        while (node1.data < k) {
            node1 = node1.next;
        }
        while (node2.data >= k) {
            node2 = node2.next;
        }
        flip(node1, node2);
    }

    public static void partition(LinkedListNode node, int k) {
        // Count number of elements in linked list < the value k
        int numLess = 0;
        LinkedListNode pointer1 = node;
        while (pointer1 != null) {
            if (pointer1.data < k) {
                numLess ++;
            }
            pointer1 = pointer1.next;
        }

        // Count number of elements in first part of list (numLess) which are >= than k
        int numMove = 0;
        LinkedListNode pointer2 = node;
        for (int i = 0; i < numLess; i++) {
            if (pointer2.data >= k) {
                numMove ++;
            }
            pointer2 = pointer2.next;
        }

        // With a pointer at the beginning and another at the beginning of the second part, swap (numMove) elements
        pointer1 = node;
        for (int i = 0; i < numMove; i++) {
            while (pointer1.data < k) {
                pointer1 = pointer1.next;
            }
            while (pointer2.data >= k) {
                pointer2 = pointer2.next;
            }
            flip(pointer1, pointer2);
        }
    }

    public static void main(String[] args) {
        System.out.println("Test 1:");
        int[] array1 = new int[]{2, 8, 1, 7, 4, 2, 9, 6};
        LinkedListNode node1 = LinkedListNode.fromArray(array1);
        System.out.println("  Linked List: " + node1.toString());
        int k1 = 3;
        System.out.println("  k: " + k1);
        partition(node1, k1);
        String actual1 = node1.toString();
        System.out.println("  Actual: " + actual1);
        String expected1 = "[2, 2, 1, 7, 4, 8, 9, 6]";
        System.out.println("  Expected: " + expected1);

        System.out.println("Test 1:");
        int[] array2 = new int[]{2, 8, 1, 7, 4, 2, 9, 6};
        LinkedListNode node2 = LinkedListNode.fromArray(array2);
        System.out.println("  Linked List: " + node2.toString());
        int k2 = 6;
        System.out.println("  k: " + k2);
        partition(node2, k2);
        String actual2 = node2.toString();
        System.out.println("  Actual: " + actual2);
        String expected2 = "[2, 4, 1, 2, 7, 8, 9, 6]";
        System.out.println("  Expected: " + expected2);

        System.out.println("Run Complete");
    }
}

// Things to remember:
// 1) missing variable declarations
// 2) missing ";"
//
// Algorithm Thoughts:
// 1) suggestion in book is two create two link lists (below/above) and merge them