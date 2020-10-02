package Common;

import java.lang.StringBuilder;
import java.util.Queue;
import java.util.LinkedList;

public class BinaryTree {
    public int rootData;
    public BinaryTree parentTree;
    public BinaryTree leftTree;
    public BinaryTree rightTree;
    int size;

    public BinaryTree(int rootData, BinaryTree leftTree, BinaryTree rightTree, int size, BinaryTree parentTree) {
        this.rootData = rootData;
        this.leftTree = leftTree;
        this.rightTree = rightTree;
        this.size = size;
        this.parentTree = parentTree;
    }

    public BinaryTree(int rootData, BinaryTree leftTree, BinaryTree rightTree, int size) {
        this(rootData, leftTree, rightTree, size, null);
    }

    public BinaryTree(int rootData, BinaryTree leftTree, BinaryTree rightTree) {
        this(rootData, leftTree, rightTree, (1
                + ((leftTree == null) ? 0 : leftTree.size)
                + ((rightTree == null) ? 0 : rightTree.size)
        ));
    }

    public static BinaryTree complete(int depth, int center, int diff) {
        //              0
        //        -4          4
        //     -6    -2    2     6
        //   -7 -5 -3 -1  1  3  5  7
        if (depth == 0) {
            return null;
        }
        return new BinaryTree(
                center,
                complete(depth-1, center-diff, diff / 2),
                complete(depth-1, center+diff, diff / 2)
        );
    }

    public static BinaryTree complete(int depth) {
        return complete(depth, 0, (int) Math.pow(2, depth-2));
    }

    public BinaryTree(int data) {
        this(data, null, null);
    }

    public BinaryTree produceChild(int data) {
        return new BinaryTree(data, null, null, 1, this);
    }

    public void insert(int data) {
        if (this.leftTree == null) {
            this.leftTree = this.produceChild(data);
        } else if (this.rightTree == null) {
            this.rightTree = this.produceChild(data);
        } else if (this.leftTree.size <= this.rightTree.size) {
            this.leftTree.insert(data);
        } else {
            this.rightTree.insert(data);
        }
        this.size += 1;
    }

    public BinaryTree copy() {
        BinaryTree leftCopy = this.leftTree == null ? null : this.leftTree.copy();
        BinaryTree rightCopy = this.rightTree == null ? null : this.rightTree.copy();
        return new BinaryTree(this.rootData, leftCopy, rightCopy);
    }

    void appendToStringBuilder(StringBuilder sb) {
        if (this.leftTree != null) {
            this.leftTree.appendToStringBuilder(sb);
        }
        sb.append(this.rootData);
        sb.append(", ");
        if (this.rightTree != null) {
            this.rightTree.appendToStringBuilder(sb);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BinaryTree [");
        this.appendToStringBuilder(sb);
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }


    public String bfsPrint() {
        Queue<BinaryTree> queue = new LinkedList<>();
        queue.add(this);
        StringBuilder sb = new StringBuilder();
        sb.append("BinaryTree [");
        while(!queue.isEmpty()) {
            BinaryTree node = queue.remove();
            sb.append(node.rootData);
            sb.append(", ");
            if (node.leftTree != null) queue.add(node.leftTree);
            if (node.rightTree != null) queue.add(node.rightTree);
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        BinaryTree binaryTree, binaryTree2;

        System.out.println("  Test #1:");
        binaryTree = new BinaryTree(0);
        binaryTree.insert(1);
        binaryTree.insert(2);
        binaryTree.insert(3);
        binaryTree.insert(4);
        binaryTree.insert(5);
        binaryTree.insert(6);
        System.out.println("Binary Tree: " + binaryTree.toString());

        System.out.println("  Test #2:");
        binaryTree = complete(4);
        System.out.println("Binary Tree: " + binaryTree.toString());

        System.out.println("  Test #3:");
        binaryTree = complete(3, -4, 2);
        System.out.println("Binary Tree: " + binaryTree.toString());

        System.out.println("  Test #3:");
        binaryTree2 = binaryTree.copy();
        binaryTree2.rootData = 8;
        System.out.println("Binary Tree: " + binaryTree2.toString());

        System.out.println("  Test #4:");
        binaryTree = complete(4);
        System.out.println("Binary Tree: " + binaryTree.bfsPrint());

        System.out.println("Run complete.");
    }
}