package Chapter2.Question2_3;

import Common.LinkedListNode;

public class Question {

    public static void deleteNode(LinkedListNode node) {
        if (node.next == null) {
            System.out.println("    Can't delete last node.");
            return;
        }

        System.out.println("    Deleting node: " + node.data);
        node.data = node.next.data;
        node.next = node.next.next;
    }

    public static void main(String[] args) {

        System.out.println("Test 1:");
        int[] array1 = new int[]{1, 2, 3, 4};
        LinkedListNode node1 = LinkedListNode.fromArray(array1);
        System.out.println("  Linked List: " + node1.toString());
        deleteNode(node1.next.next);
        String actual1 = node1.toString();
        String expected1 = "[1, 2, 4]";
        System.out.println("  Actual: " + actual1);
        System.out.println("  Expected: " + expected1);

        System.out.println("Test 2:");
        int[] array2 = new int[]{4, 5, 6, 7};
        LinkedListNode node2 = LinkedListNode.fromArray(array2);
        System.out.println("  Linked List: " + node2.toString());
        deleteNode(node2.next.next.next);
        String actual2 = node2.toString();
        String expected2 = "[4, 5, 6, 7]";
        System.out.println("  Actual: " + actual2);
        System.out.println("  Expected: " + expected2);

        System.out.println("Run Complete");
    }
}

// Things to remember:
// 1) missing variable declarations
// 2) missing "new"
// 3) missing ";"