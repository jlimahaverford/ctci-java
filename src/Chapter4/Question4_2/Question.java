package Chapter4.Question4_2;

import Common.DirectedGraph;
import Common.GraphNode;

import java.util.HashSet;

class Question {

    public static boolean hasPath(DirectedGraph<String> graph, GraphNode<String> startNode, GraphNode<String> finishNode, HashSet<GraphNode<String>> visitedSet) {
        if (visitedSet.contains(startNode)) {
            return false;
        }
        if (startNode == finishNode) {
            System.out.println("    " + startNode.getData());
            return true;
        }
        visitedSet.add(startNode);
        HashSet<GraphNode<String>> neighbors = graph.getNeighbors(startNode);
        for (GraphNode<String> neighbor : neighbors) {
            if (hasPath(graph, neighbor, finishNode, visitedSet)) {
                System.out.println("    " + startNode.getData());
                return true;
            }
        }
        return false;
    }

    public static boolean hasPath2(DirectedGraph<String> graph, GraphNode<String> startNode, GraphNode<String> finishNode) {
        HashSet<GraphNode<String>> visitedSet = new HashSet<>();
        return hasPath(graph, startNode, finishNode, visitedSet);
    }

    public static void main(String[] args) {
        GraphNode<String> jon = new GraphNode<>("Jon");
        GraphNode<String> mike = new GraphNode<>("Mike");
        GraphNode<String> sandy = new GraphNode<>("Sandy");
        GraphNode<String> joao = new GraphNode<>("Joao");
        GraphNode<String> jim = new GraphNode<>("Jim");
        GraphNode<String> irene = new GraphNode<>("Irene");
        GraphNode<String> denora = new GraphNode<>("Denora");
        GraphNode<String> antonio = new GraphNode<>("Antonio");
        DirectedGraph<String> graph = new DirectedGraph<>();
        graph.addVertex(antonio);
        graph.addVertex(denora);
        graph.addVertex(jim);
        graph.addVertex(irene);
        graph.addVertex(sandy);
        graph.addVertex(joao);
        graph.addVertex(mike);
        graph.addVertex(jon);
        graph.addEdge(antonio, joao);
        graph.addEdge(denora, joao);
        graph.addEdge(jim, sandy);
        graph.addEdge(irene, sandy);
        graph.addEdge(joao, mike);
        graph.addEdge(sandy, mike);
        graph.addEdge(joao, jon);
        graph.addEdge(sandy, jon);
        graph.addEdge(jon, denora);  // I'm my grandmother's father ?!?

        boolean actual, expected;

        System.out.println("Test #1:");
        actual = hasPath2(graph, sandy, jon);
        System.out.println("  Actual: " + actual);
        expected = true;
        System.out.println("  Expected: " + expected);

        System.out.println("Test #2:");
        actual = hasPath2(graph, mike, jon);
        System.out.println("  Actual: " + actual);
        expected = false;
        System.out.println("  Expected: " + expected);

        System.out.println("Test #3:");
        actual = hasPath2(graph, denora, jon);
        System.out.println("  Actual: " + actual);
        expected = true;
        System.out.println("  Expected: " + expected);

        System.out.println("Test #4:");
        actual = hasPath2(graph, jon, mike);
        System.out.println("  Actual: " + actual);
        expected = true;
        System.out.println("  Expected: " + expected);

        int[] array = new int[] {1};

        System.out.println("Run complete.");
    }
}