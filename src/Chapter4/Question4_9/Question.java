package Chapter4.Question4_9;

import Common.BinaryTree;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question {

    public static HashMap<Integer, List<List<BinaryTree>>>  copy(
            HashMap<Integer, List<List<BinaryTree>>> map) {
        HashMap<Integer, List<List<BinaryTree>>> resultMap = new HashMap<>();
        for (Map.Entry<Integer, List<List<BinaryTree>>> entry : map.entrySet()) {
                resultMap.put(entry.getKey(), entry.getValue());
        }
        return resultMap;
    }

    public static void combineInPlace(
            HashMap<Integer, List<List<BinaryTree>>> map1,
            HashMap<Integer, List<List<BinaryTree>>> map2
    ) {
        for (Map.Entry<Integer, List<List<BinaryTree>>> entry : map2.entrySet()) {
            if (map1.containsKey(entry.getKey())) {
                map1.get(entry.getKey()).addAll(entry.getValue());
            } else {
                map1.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public static HashMap<Integer, List<List<BinaryTree>>> combine(
            HashMap<Integer, List<List<BinaryTree>>> map1,
            HashMap<Integer, List<List<BinaryTree>>> map2
    ) {
        HashMap<Integer, List<List<BinaryTree>>> resultMap = copy(map1);
        combineInPlace(resultMap, map2);
        return resultMap;
    }

    public static HashMap<Integer, List<List<BinaryTree>>> prepend(
            HashMap<Integer, List<List<BinaryTree>>> map,
            BinaryTree tree
    ) {
        HashMap<Integer, List<List<BinaryTree>>> resultMap = new HashMap<>();
        for (Map.Entry<Integer, List<List<BinaryTree>>> entry : map.entrySet()) {
            List<List<BinaryTree>> value = entry.getValue();
            for (List<BinaryTree> binaryTrees : value) {
                BinaryTree currentHead = binaryTrees.get(0);
                if (currentHead == tree.leftTree || currentHead == tree.rightTree) {
                    binaryTrees.add(0, tree);
                }
            }
            resultMap.put(entry.getKey() + tree.rootData, entry.getValue());
        }
        return resultMap;
    }

    public static HashMap<Integer, List<List<BinaryTree>>> buildSumMap(BinaryTree tree) {
//        if (tree == null) {
//            HashMap<Integer, List<List<BinaryTree>>> map = new HashMap<>();
//            List<List<BinaryTree>> paths = new LinkedList<>();
//            map.put(0, paths);
//            return map;
//        }
        if (tree.leftTree == null && tree.rightTree == null) {
            HashMap<Integer, List<List<BinaryTree>>> map = new HashMap<>();
            List<BinaryTree> path = new LinkedList<>();
            path.add(tree);
            List<List<BinaryTree>> paths = new LinkedList<>();
            paths.add(path);
            map.put(tree.rootData, paths);
            return map;
        }
        if (tree.leftTree != null && tree.rightTree != null) {
            HashMap<Integer, List<List<BinaryTree>>> leftMap = buildSumMap(tree.leftTree);
            HashMap<Integer, List<List<BinaryTree>>> rightMap = buildSumMap(tree.leftTree);
            HashMap<Integer, List<List<BinaryTree>>> leftRootMap = prepend(leftMap, tree);
            HashMap<Integer, List<List<BinaryTree>>> rightRootMap = prepend(leftMap, tree);
            return
        }

        return null;
    }

    public static void main(String[] args) {
        System.out.println("Test #1:");
        BinaryTree tree = BinaryTree.complete(6);
        System.out.println("  Tree: " + tree.toString());



        System.out.println("Run complete.");
    }
}
