package Chapter2.Question2_5;

import Common.LinkedListNode;

public class Question {

    public static LinkedListNode add(LinkedListNode node1, LinkedListNode node2) {
        int carryTheOne = 0;
        LinkedListNode pointer1 = node1;
        LinkedListNode pointer2 = node2;
        LinkedListNode head = null;
        LinkedListNode tail = null;

        while ((pointer1 != null) || (pointer2 != null)) {
            int data1 = (pointer1 != null) ? pointer1.data : 0;
            LinkedListNode next1 = (pointer1 != null) ? pointer1.next : pointer1;
            int data2 = (pointer2 != null) ? pointer2.data : 0;
            LinkedListNode next2 = (pointer2 != null) ? pointer2.next : pointer2;

            if ((data1 > 9) || (data2 > 9)) {
                throw new IllegalArgumentException("Digit greater than 9");
            }
            if ((data1 < 0) || (data2 < 0)) {
                throw new IllegalArgumentException("Digit less than 0");
            }
            int sum = data1 + data2 + carryTheOne;
            carryTheOne = sum / 10;
            if (head == null) {
                head = new LinkedListNode(sum % 10);
                tail = head;
            } else {
                tail.next = new LinkedListNode(sum % 10);
                tail = tail.next;
            }
            pointer1 = next1;
            pointer2 = next2;
        }

        if (carryTheOne == 1) {
            tail.next = new LinkedListNode(1);
        }

        return head;
    }

    public static void testAdd(int[] array1, int[] array2, int[] arrayExpected) {
        LinkedListNode node1 = LinkedListNode.fromArray(array1);
        LinkedListNode node2 = LinkedListNode.fromArray(array2);
        LinkedListNode expected2 = LinkedListNode.fromArray(arrayExpected);
        LinkedListNode actual2 = add(node1, node2);
        System.out.println("  Actual: " + actual2.toString());
        System.out.println("  Expected: " + expected2.toString());
    }

    public static void testAdd2(int[] array1, int[] array2, int[] arrayExpected) {
        LinkedListNode node1 = LinkedListNode.fromArray(array1);
        LinkedListNode node2 = LinkedListNode.fromArray(array2);
        LinkedListNode expected2 = LinkedListNode.fromArray(arrayExpected);
        LinkedListNode actual2 = add2(node1, node2);
        System.out.println("  Actual: " + actual2.toString());
        System.out.println("  Expected: " + expected2.toString());
    }

    static class SumResult {
        LinkedListNode node;
        int carryTheOne;

        public SumResult(LinkedListNode node, int carryTheOne) {
            this.node = node;
            this.carryTheOne = carryTheOne;
        }
    }

    public static int length(LinkedListNode node) {
        int l = 0;
        while (node != null) {
            l++;
            node = node.next;
        }
        return l;
    }

    public static LinkedListNode pad(LinkedListNode node, int n) {
        if (n == 0){
            return node;
        }
        LinkedListNode head = new LinkedListNode(0);
        LinkedListNode tail = head;
        for (int i = 0; i < n-1; i++) {
            tail.next = new LinkedListNode(0);
            tail = tail.next;
        }
        tail.next = node;
        return head;
    }

    public static SumResult add2SumResult(LinkedListNode node1, LinkedListNode node2) {
        int length1 = length(node1);
        int length2 = length(node2);
        if (length1 > length2) {
            node2 = pad(node2, length1 - length2);
        }
        if (length2 > length1) {
            node1 = pad(node1, length2 - length1);
        }

        // Add two (properly aligned) linked list whole numbers
        LinkedListNode node = new LinkedListNode(node1.data + node2.data);
        if (node1.next != null) {
            SumResult partial = add2SumResult(node1.next, node2.next);
            node.data += partial.carryTheOne;
            node.next = partial.node;
        }

        int carryTheOne = 0;
        if (node.data > 9) {
            carryTheOne ++;
            node.data = (node.data % 10);
        }
        return new SumResult(node, carryTheOne);
    }

    public static LinkedListNode add2(LinkedListNode node1, LinkedListNode node2) {
        SumResult sumResult = add2SumResult(node1, node2);
        if (sumResult.carryTheOne == 0) {
            return sumResult.node;
        } else {
            LinkedListNode head = new LinkedListNode(1);
            head.next = sumResult.node;
            return head;
        }
    }

    public static void main(String[] args) {
        System.out.println("Test 1:");
        int[] array11 = new int[] {7, 1, 6};
        int[] array21 = new int[] {5, 9, 2};
        int[] arrayExpected1 = new int[] {2, 1, 9};
        testAdd(array11, array21, arrayExpected1);

        System.out.println("Test 2:");
        int[] array12 = new int[] {7, 1, 6};
        int[] array22 = new int[] {5, 9, 2, 1};
        int[] arrayExpected2 = new int[] {2, 1, 9, 1};
        testAdd(array12, array22, arrayExpected2);

        System.out.println("Test 3:");
        int[] array13 = new int[] {1};
        int[] array23 = new int[] {9, 9, 9, 9};
        int[] arrayExpected3 = new int[] {0, 0, 0, 0, 1};
        testAdd(array13, array23, arrayExpected3);

        System.out.println("Test 4:");
        int[] array14 = new int[] {1, 2, 3};
        int[] array24 = new int[] {4, 5, 6};
        int[] arrayExpected4 = new int[] {5, 7, 9};
        testAdd2(array14, array24, arrayExpected4);

        System.out.println("Test 5:");
        int[] array15 = new int[] {1, 2, 3, 4};
        int[] array25 = new int[] {4, 5, 6};
        int[] arrayExpected5 = new int[] {1, 6, 9, 0};
        testAdd2(array15, array25, arrayExpected5);

        System.out.println("Test 6:");
        int[] array16 = new int[] {9, 9, 9};
        int[] array26 = new int[] {1};
        int[] arrayExpected6 = new int[] {1, 0, 0, 0};
        testAdd2(array16, array26, arrayExpected6);

        System.out.println("Run Complete");
    }
}
