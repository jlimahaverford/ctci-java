package Chapter4.Question4_6;

import Common.BinaryTree;

class Question {

    public static BinaryTree getMinTree(BinaryTree tree) {
        if (tree.leftTree == null) {
            return tree;
        } else {
            return getMinTree(tree.leftTree);
        }
    }

    public static BinaryTree findSuccessor(BinaryTree tree) {
        if (tree.rightTree != null) {
            return getMinTree(tree.rightTree);
        }
        BinaryTree pointer = tree;
        while ((pointer.parentTree != null) && (pointer.parentTree.rootData < tree.rootData)) {
            System.out.println("    pointer.rootData: " + pointer.rootData);
            pointer = pointer.parentTree;
        }
        if ((pointer.parentTree != null) && ( pointer.parentTree.rootData > tree.rootData)) {
            return pointer.parentTree;
        }
        throw new RuntimeException("No successor found");
    }

    public static void main(String[] args) {
        BinaryTree tree = BinaryTree.complete(4);
        int actual, expected;

        System.out.println(tree.toString());

        System.out.println("Test #1:");
        actual = findSuccessor(tree).rootData;
        System.out.println("  Actual: " + actual);
        expected = 1;
        System.out.println("  Expected: " + expected);

        System.out.println("Test #2:");
        actual = findSuccessor(tree.leftTree).rootData;
        System.out.println("  Actual: " + actual);
        expected = -3;
        System.out.println("  Expected: " + expected);

        System.out.println("Test #3:");
        actual = findSuccessor(tree.rightTree).rootData;
        System.out.println("  Actual: " + actual);
        expected = 5;
        System.out.println("  Expected: " + expected);

        System.out.println("Test #4:");
        actual = findSuccessor(tree.leftTree.rightTree.leftTree).rootData;
        System.out.println("  Actual: " + actual);
        expected = -2;
        System.out.println("  Expected: " + expected);

        System.out.println("Test #5:");
        actual = findSuccessor(tree.rightTree.leftTree.rightTree).rootData;
        System.out.println("  Actual: " + actual);
        expected = 4;
        System.out.println("  Expected: " + expected);

        System.out.println("Run complete.");
    }
}