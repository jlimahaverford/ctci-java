package Chapter4.Question4_4;

import Common.BinaryTree;
import java.util.LinkedList;
import java.util.List;

class Question {

    static LinkedList<List<Integer>> add(LinkedList<List<Integer>> first, LinkedList<List<Integer>> second) {
        if (first.size() < second.size()) {
            return add(second, first);
        }

        for (int i=0; i<second.size(); i++) {
            first.get(i).addAll(second.get(i));
        }
        return first;
    }

    static LinkedList<List<Integer>> getDepthLists(BinaryTree tree) {
        if (tree == null) {
            return new LinkedList<>();
        }
        LinkedList<List<Integer>> leftList = getDepthLists(tree.leftTree);
        LinkedList<List<Integer>> rightList = getDepthLists(tree.rightTree);
        LinkedList<List<Integer>> sumList = add(leftList, rightList);
        List<Integer> firstList = new LinkedList<>();
        firstList.add(tree.rootData);
        sumList.addFirst(firstList);
        return sumList;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree(0);
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.rightTree.insert(4);
        List<List<Integer>> listOfLists = getDepthLists(tree);

        String actual, expected;

        System.out.println("Test #1:");
        actual = listOfLists.get(0).toString();
        System.out.println("  Actual: " + actual);
        expected = "[0]";
        System.out.println("  Expected: " + expected);

        System.out.println("Test #2:");
        actual = listOfLists.get(1).toString();
        System.out.println("  Actual: " + actual);
        expected = "[1, 2]";
        System.out.println("  Expected: " + expected);

        System.out.println("Test #3:");
        actual = listOfLists.get(2).toString();
        System.out.println("  Actual: " + actual);
        expected = "[3, 4]";
        System.out.println("  Expected: " + expected);

        System.out.println("Run complete.");
    }
}