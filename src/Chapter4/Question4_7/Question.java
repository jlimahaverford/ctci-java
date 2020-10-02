package Chapter4.Question4_7;

import Common.BinaryTree;

class Question {

    static boolean hasPath(BinaryTree tree, BinaryTree node) {
        if ((tree == null) || (node == null)) {
            return false;
        }
        if (tree == node) {
            return true;
        }
        return hasPath(tree.leftTree, node) || hasPath(tree.rightTree, node);
    }

    static BinaryTree ancestorStep(BinaryTree tree, BinaryTree node1, BinaryTree node2) {
        if ((tree == node1) || (tree == node2)) {
            return null;
        }
        if (hasPath(tree.leftTree, node1) && hasPath(tree.leftTree, node2)) {
            return tree.leftTree;
        }
        if (hasPath(tree.rightTree, node1) && hasPath(tree.rightTree, node2)) {
            return tree.rightTree;
        }
        return null;
    }

    public static BinaryTree youngestAncestor(BinaryTree tree, BinaryTree node1, BinaryTree node2) {
        if ((tree == null) || (node1 == null) || (node2 == null)) {
            throw new RuntimeException("Error: Neither tree, node1, or node2 can be null.");
        }
        if (node1 == node2) {
            return node1;
        }
        if ((tree == node1) || (tree == node2)) {
            return tree;
        }
        if ((!hasPath(tree, node1)) || (!hasPath(tree, node2))) {
            throw new RuntimeException("Error: Both node1 and node2 must be part of tree.");
        }
        BinaryTree currentPointer;
        BinaryTree nextPointer = tree;
        do {
            currentPointer = nextPointer;
            nextPointer = ancestorStep(currentPointer, node1, node2);
        } while (nextPointer != null);
        return currentPointer;
    }

    public static void main(String[] args) {
        int actual, expected;
        BinaryTree node1, node2, ancestor;
        BinaryTree tree = BinaryTree.complete(4);

        System.out.println("Test #1:");
        node1 = tree.leftTree.leftTree.leftTree;
        node2 = tree.rightTree.rightTree.rightTree;
        ancestor = youngestAncestor(tree, node1, node2);
        actual = ancestor.rootData;
        System.out.println("  Actual: " + actual);
        expected = 0;
        System.out.println("  Expected: " + expected);

        System.out.println("Test #2:");
        node1 = tree.leftTree.leftTree.leftTree;
        node2 = tree.leftTree.rightTree.rightTree;
        ancestor = youngestAncestor(tree, node1, node2);
        actual = ancestor.rootData;
        System.out.println("  Actual: " + actual);
        expected = -4;
        System.out.println("  Expected: " + expected);

        System.out.println("Test #3:");
        node1 = tree.leftTree.leftTree.leftTree;
        node2 = tree.leftTree.leftTree.rightTree;
        ancestor = youngestAncestor(tree, node1, node2);
        actual = ancestor.rootData;
        System.out.println("  Actual: " + actual);
        expected = -6;
        System.out.println("  Expected: " + expected);

        System.out.println("Test #4:");
        node1 = tree.rightTree.rightTree.rightTree;
        node2 = tree.rightTree.leftTree.rightTree;
        ancestor = youngestAncestor(tree, node1, node2);
        actual = ancestor.rootData;
        System.out.println("  Actual: " + actual);
        expected = 4;
        System.out.println("  Expected: " + expected);

        System.out.println("Run complete.");
    }

}