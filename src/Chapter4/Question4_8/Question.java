package Chapter4.Question4_8;

import Common.BinaryTree;

class Question {

    public static boolean isEqual(BinaryTree tree1, BinaryTree tree2) {
        // determines if tree1 and tree2 are identical

        if (tree1 == null) {
            return (tree2 == null);
        }
        if (tree2 == null) {
            return false;
        }
        if (tree1.rootData == tree2.rootData) {
            return isEqual(tree1.leftTree, tree2.leftTree) && isEqual(tree1.rightTree, tree2.rightTree);
        }
        return false;
    }

    public static boolean isSubtree(BinaryTree tree1, BinaryTree tree2) {
        // determines whether tree1 is a subtree of tree2
        if (tree2 == null) {
            return tree1 == null;
        }
        if (isEqual(tree1, tree2)) {
            return true;
        } else {
            return isSubtree(tree1, tree2.leftTree) || isSubtree(tree1, tree2.rightTree);
        }
    }

    public static void main(String[] args) {
        boolean actual, expected, success;
        BinaryTree tree1, tree2, tree3;

        tree1 = BinaryTree.complete(4);
        tree2 = tree1.rightTree.copy();
        tree3 = tree2.copy();
        tree3.rightTree.rightTree.rootData = 100;

        tree3 = new BinaryTree(4);
        tree3.insert(2);
        tree3.insert(6);
        tree3.leftTree.insert(1);
        tree3.leftTree.insert(3);
        tree3.rightTree.insert(5);
        tree3.rightTree.insert(8);

        System.out.println("Test #1");
        actual = isEqual(tree1, tree1);
        System.out.println("  Actual: " + actual);
        expected = true;
        System.out.println("  Expected: " + expected);
        success = actual == expected;
        System.out.println("  Success: " + success);


        System.out.println("Test #2");
        actual = isEqual(tree2, tree3);
        System.out.println("  Actual: " + actual);
        expected = false;
        System.out.println("  Expected: " + expected);
        success = actual == expected;
        System.out.println("  Success: " + success);

        System.out.println("Test #3");
        actual = isSubtree(tree2, tree1);
        System.out.println("  Actual: " + actual);
        expected = true;
        System.out.println("  Expected: " + expected);
        success = actual == expected;
        System.out.println("  Success: " + success);

        System.out.println("Test #4");
        actual = isSubtree(tree3, tree1);
        System.out.println("  Actual: " + actual);
        expected = false;
        System.out.println("  Expected: " + expected);
        success = actual == expected;
        System.out.println("  Success: " + success);

        System.out.println("Run complete.");
    }
}