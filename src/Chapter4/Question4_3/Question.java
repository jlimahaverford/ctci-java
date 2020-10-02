package Chapter4.Question4_3;

import Common.BinaryTree;

class Question {

    public static BinaryTree fromSortedArrayHelper(int[] array, int start, int stop) {
        if (stop < start) {
            return null;
        }
        if (stop == start) {
            return new BinaryTree(array[start]);
        }
        int middle = start + ((stop - start) / 2);
        int rootValue = array[middle];
        BinaryTree leftTree = fromSortedArrayHelper(array, start, middle-1);
        BinaryTree rightTree = fromSortedArrayHelper(array, middle+1, stop);
        return new BinaryTree(rootValue, leftTree, rightTree);
    }

    public static BinaryTree fromSortedArray(int[] array) {
        if (array.length == 0) {
            return null;
        }
        return fromSortedArrayHelper(array, 0, array.length-1);
    }

    public static void main(String[] args) {
        int[] array;
        String actual, expected;

        System.out.println("Test #1:");
        array = new int[] {1,2,3,4,5};
        actual = fromSortedArray(array).toString();
        System.out.println("  Actual:" + actual);
        System.out.println("  Expected:");


        System.out.println("Test #2:");
        array = new int[] {1,2,3,4,5,6,7,8,9,10,11,12};
        actual = fromSortedArray(array).toString();
        System.out.println("  Actual:" + actual);
        System.out.println("  Expected:");


        System.out.println("Test #3:");
        array = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        actual = fromSortedArray(array).toString();
        System.out.println("  Actual:" + actual);
        System.out.println("  Expected:");


        System.out.println("Run complete.");
    }
}