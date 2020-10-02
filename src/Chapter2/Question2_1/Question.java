package Chapter2.Question2_1;

import Common.LinkedListNode;

import java.util.HashSet;

public class Question {

    public static void removeDuplicates(LinkedListNode node) {
        HashSet<Integer> uniqueItems = new HashSet<>();
        LinkedListNode lead = node;
        LinkedListNode trail = null;
        while (lead != null) {
            if (uniqueItems.contains(lead.data)) {
                System.out.println("    Deleting Duplicate: " + lead.data);
                trail.next = lead.next;
            } else {
                uniqueItems.add(lead.data);
                trail = lead;
            }
            lead = lead.next;
        }
    }

    public static void removeDuplicatesNoBuffer(LinkedListNode node) {
        LinkedListNode uniquePointer = node;
        while (uniquePointer != null) {
            LinkedListNode deletePointer = uniquePointer;
            while (deletePointer != null) {
                if (deletePointer.next != null && (deletePointer.next.data == uniquePointer.data)) {
                    System.out.println("    Deleting Duplicate: " + deletePointer.next.data);
                    deletePointer.next = deletePointer.next.next;
                }
                deletePointer = deletePointer.next;
            }
            uniquePointer = uniquePointer.next;
        }
    }

    public static void main(String[] args) {

        System.out.println("Test 1:");
        LinkedListNode node1 = LinkedListNode.fromArray(new int[]{1, 2, 3, 4, 5, 1, 2, 6, 7, 3, 4, 5, 8, 9});
        System.out.println("  Before Deleting Duplicates:");
        System.out.println("  " + node1.toString());
        Question.removeDuplicates(node1);
        System.out.println("  After Deleting Duplicates:");
        System.out.println("  " + node1.toString());

        System.out.println("Test 2:");
        LinkedListNode node2 = LinkedListNode.fromArray(new int[]{1, 2, 3, 4, 5, 1, 2, 6, 7, 3, 4, 5, 8, 9});
        System.out.println("  Before Deleting Duplicates:");
        System.out.println("  " + node2.toString());
        Question.removeDuplicatesNoBuffer(node2);
        System.out.println("  After Deleting Duplicates:");
        System.out.println("  " + node2.toString());

        System.out.println("Run Complete");
    }

}

// Things to remember:
// 1) import java.util.HashSet;
// 2) import Common.Node;
// 3) pointer.next.next