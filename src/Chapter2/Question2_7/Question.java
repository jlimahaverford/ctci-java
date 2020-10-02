package Chapter2.Question2_7;

import Common.LinkedListNode;

public class Question {

    public static class Result {
        boolean is;
        LinkedListNode rest;

        public Result(boolean is, LinkedListNode rest) {
            this.is = is;
            this.rest = rest;
        }
    }

    public static Result isPalindromeHelper(LinkedListNode node, int length) {
//        System.out.println("    #");
//        System.out.println("  Node: " + node.toString());
//        System.out.println("  Length: " + length);

        if (length == 0) {
            return new Result(true, node);
        } else if (length == 1) {
            return new Result(true, node.next);
        }
        Result result = isPalindromeHelper(node.next, length - 2);

//        System.out.println("    ##");
//        System.out.println("  result.is: " + result.is);
//        if (result.rest == null) {
//            System.out.println("  result.rest: null");
//        } else {
//            System.out.println("  result.rest: " + result.rest.toString());
//        }
//        System.out.println("  node.data:" + node.data);

        if ((result.is) && (node.data == result.rest.data)) {
            return new Result(true, result.rest.next);
        }
        return new Result(false, null);
    }

    public static int length(LinkedListNode node) {
        int i = 0;
        while (node != null){
            i ++;
            node = node.next;
        }
        return i;
    }

    public static boolean isPalindrome(LinkedListNode node) {
        int l = length(node);
        Result result = isPalindromeHelper(node, l);
        return result.is;
    }

    public static void main(String[] args) {
        System.out.println("Test 1:");
        LinkedListNode node1 = LinkedListNode.fromArray(new int[] {1, 2, 3, 2, 1});
        System.out.println("  Linked List: " + node1.toString());
        boolean actual1 = isPalindrome(node1);
        System.out.println("  Actual: " + actual1);
        boolean expected1 = true;
        System.out.println("  Expected: " + expected1);

        System.out.println("Test 2:");
        LinkedListNode node2 = LinkedListNode.fromArray(new int[] {1, 2, 3, 1, 2});
        System.out.println("  Linked List: " + node2.toString());
        boolean actual2 = isPalindrome(node2);
        System.out.println("  Actual: " + actual2);
        boolean expected2 = false;
        System.out.println("  Expected: " + expected2);

        System.out.println("Test 3:");
        LinkedListNode node3 = LinkedListNode.fromArray(new int[] {1, 2, 2, 1});
        System.out.println("  Linked List: " + node3.toString());
        boolean actual3 = isPalindrome(node3);
        System.out.println("  Actual: " + actual3);
        boolean expected3 = true;
        System.out.println("  Expected: " + expected3);

        System.out.println("Run Complete.");
    }
}

// Compilation Errors
// 1) Don't forget new when calling a constructor.
// 2) Need to make in-class classes static?
// 3) true/false not True/False