/**
 * ------------------------------------
 * Graph Driver
 *
 * @author Maverick G. Fabroa
 * Date: November 6, 2022
 * ------------ Features: -------------
 * 1. Greedy Best-First Search
 * 2. A* Search
 * ------------------------------------
 */
public class MavyGraphDriver {
    public static void main(String[] args) {
        // Example from https://www.javatpoint.com/ai-informed-search-algorithms
        String[] nodes = new String[] {
            "A", "B", "C", "D", "E", "F", "H", "I", "S", "G"
        };

        double[] heuristicValues = new double[] {
            12, 4, 7, 3, 8, 2, 4, 9, 13, 0
        };

        // Iniitalize our graph
        MavyGraphTraversal graph = new MavyGraphTraversal();

        // Add all nodes to the graph with h(n)
        for (int i = 0; i < nodes.length; i++) {
            graph.addPlace(nodes[i], heuristicValues[i]);
        }

        graph.connect(8, 0, 3); // S -> A
        graph.connect(8, 1, 2); // S -> B
        graph.connect(0, 2, 4); // A -> C
        graph.connect(0, 3, 1); // A -> D
        graph.connect(1, 4, 3); // B -> E
        graph.connect(1, 5, 1); // B -> F
        graph.connect(4, 6, 5); // E -> H
        graph.connect(5, 7, 2); // F -> I
        graph.connect(5, 9, 3); // F -> G

        // Do Greedy Best First Search
        graph.GBFS(8, 9);
        // Do A* Search
        graph.Astar(8, 9);
    }
}