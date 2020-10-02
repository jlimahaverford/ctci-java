package Chapter4.Question4_5;

import Common.BinaryTree;

public class Question {

static class Result {
    public int min;
    public int max;
    public boolean isSorted;

    public Result(int min, int max, boolean isSorted) {
        this.min = min;
        this.max = max;
        this.isSorted = isSorted;
    }
}

    static Result computeResult(BinaryTree tree) {
        if ((tree.leftTree == null) && (tree.rightTree == null)) {
            return new Result(tree.rootData, tree.rootData, true);
        }

        int min = tree.rootData;
        if (tree.leftTree != null) {
            Result leftResult = computeResult(tree.leftTree);
            if (!leftResult.isSorted) {
                return new Result(0, 0, false);
            }
            if (leftResult.max > tree.rootData) {
                return new Result(0, 0, false);
            }
            min = leftResult.min;
        }

        int max = tree.rootData;
        if (tree.rightTree != null) {
            Result rightResult = computeResult(tree.rightTree);
            if (!rightResult.isSorted) {
                return new Result(0, 0, false);
            }
            if (rightResult.min < tree.rootData) {
                return new Result(0, 0, false);
            }
            max = rightResult.max;
        }

        return new Result(min, max, true);
    }

    static boolean isSorted(BinaryTree tree) {
        return computeResult(tree).isSorted;
    }

    public static void main(String[] args) {
        BinaryTree tree;
        boolean actual, expected;

        System.out.println("Test #1:");
        tree = new BinaryTree(0);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        actual = isSorted(tree);
        System.out.println("  Actual: " + actual);
        expected = false;
        System.out.println("  Expected: " + expected);

        System.out.println("Test #2:");
        tree = new BinaryTree(0);
        tree.insert(-2);
        tree.insert(2);
        tree.leftTree.insert(-3);
        tree.leftTree.insert(-1);
        tree.rightTree.insert(1);
        tree.rightTree.insert(3);
        actual = isSorted(tree);
        System.out.println("  Actual: " + actual);
        expected = true;
        System.out.println("  Expected: " + expected);

        System.out.println("Test #3:");
        tree = new BinaryTree(0);
        actual = isSorted(tree);
        System.out.println("  Actual: " + actual);
        expected = true;
        System.out.println("  Expected: " + expected);

        System.out.println("Run complete.");
    }
}