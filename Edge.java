/**
 * ------------------------------------
 * Graph Edge
 *
 * @author Maverick G. Fabroa
 * Date: November 6, 2022
 * ------------------------------------
 */
public class Edge {
    private final Node n;
    private final double weight;

    public Edge(Node n, double weight) {
        this.n = n;
        this.weight = weight;
    }

    public Node getNode() {
        return n;
    }

    public double getWeight() {
        return weight;
    }
}
