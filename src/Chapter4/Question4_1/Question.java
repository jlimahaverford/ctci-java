package Chapter4.Question4_1;

import Common.BinaryTree;

class Question {

    public static class MinMax {
        int min, max;

        public MinMax(int min, int max) {
            this.min = min;
            this.max = max;
        }

        public MinMax smush(MinMax other) {
            return new MinMax(Math.min(this.min, other.min), Math.max(this.max, other.max));
        }

        public MinMax bumped() {
            return new MinMax(this.min + 1, this.max + 1);
        }
    }

    public static MinMax getMinMax(BinaryTree tree) {
        if (tree == null) {
            return new MinMax(0, 0);
        } else {
            return getMinMax(tree.leftTree).smush(getMinMax(tree.rightTree)).bumped();
        }
    }

    public static boolean isBalanced(BinaryTree tree) {
        MinMax minMax = getMinMax(tree);
        return (minMax.max - minMax.min <= 1);
    }

    public static void main(String[] args) {
        BinaryTree tree1 = new BinaryTree(0);
        tree1.insert(1);
        tree1.insert(2);
        tree1.insert(3);
        tree1.insert(4);
        tree1.insert(5);
        tree1.insert(6);
        tree1.insert(7);
        tree1.insert(8);
        tree1.insert(9);
        tree1.insert(10);
        tree1.insert(11);
        tree1.insert(12);
        tree1.insert(13);
        BinaryTree tree2 = new BinaryTree(15);
        tree2.insert(16);
        BinaryTree tree3 = new BinaryTree(17, tree1, tree2);

        boolean actual, expected;

        System.out.println("Test #1:");
        actual = isBalanced(tree1);
        System.out.println("  Actual: " + actual);
        expected = true;
        System.out.println("  Expected: " + expected);


        System.out.println("Test #2:");
        actual = isBalanced(tree2);
        System.out.println("  Actual: " + actual);
        expected = true;
        System.out.println("  Expected: " + expected);

        System.out.println("Test #3:");
        actual = isBalanced(tree3);
        System.out.println("  Actual: " + actual);
        expected = false;
        System.out.println("  Expected: " + expected);

        System.out.println("Test #4:");
        MinMax minMax = getMinMax(tree1);
        System.out.println("  Actual Min: " + minMax.min);
        System.out.println("  Expected Min: " + 3);
        System.out.println("  Actual Max: " + minMax.max);
        System.out.println("  Expected Max: " + 4);

        System.out.println("Run complete.");
    }
}

// 1-800-317-6345
// Case #: 04SEP2020-822100

// Compilation Errors
//
// 1) Don't forget "new"

// Chapter 4 Notes:
//
// 1) Binary Tree
// 2) Binary Search Tree
// 3) Balanced Tree
// 4) Unbalanced Tree
// 5) Depth First Search
// 6) Breadth First Search
// 7) Balancing Trees
// 8) Red Black Trees
// 9) AVL Trees
// 10) Tries
// 11) Graph Traversal