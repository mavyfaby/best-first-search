import java.util.LinkedList;

/**
 * ------------------------------------
 * Graph Node
 *
 * @author Maverick G. Fabroa
 * Date: November 6, 2022
 * ------------------------------------
 */
public class Node {
    private final String name;
    private String label;
    private Node parent;
    private boolean visited;
    private final LinkedList<Edge> neighbors;

    private double f;
    private double g;
    private double h;

    public Node(String name, String label) {
        this(name);
        this.label = label;
    }

    public Node(String name) {
        this.f = 0.0;
        this.g = 0.0;
        this.h = 0.0;
        this.name = name;
        this.label = null;
        this.visited = false;
        this.neighbors = new LinkedList<>();
    }

    /**
     * Add neighbor to this node
     *
     * @param n
     * @param weight
     * @return 0 if success, -1 if not
     */
    public int addNeighbor(Node n, double weight) {
        // If node already existed in the list of neighbors
        if (isNeighbor(n)) {
            // return error (will show message)
            return -1;
        }

        // Create an edge
        Edge edge = new Edge(n, weight);
        // Add it to the neighbors
        neighbors.add(edge);
        // return success
        return 0;
    }

    public String getName() {
        return name;
    }

    public double getF() {
        return f;
    }

    public double getG() {
        return g;
    }

    public double getH() {
        return h;
    }

    public void setF(double f) {
        this.f = f;
    }

    public void setG(double g) {
        this.g = g;
    }

    public void setH(double h) {
        this.h = h;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    /**
     * Get node's neighbors
     * @return list of places as nodes
     */
    public LinkedList<Edge> getNeighbors() {
        return neighbors;
    }

    /**
     * Get place label
     * @return name if no label, otherwise return label
     */
    public String getLabel() {
        // If no label, return name
        if (label == null) {
            return name;
        }

        // Otherwise, return label
        return label;
    }

    /* ================= Utility ================= */

    /**
     * Check if the node already exist in the list of neighbors
     *
     * @param n the node place
     * @return true if existed, false if not
     */
    public boolean isNeighbor(Node n) {
        // For every neighbor
        for (Edge edge : neighbors) {
            // If current neighbor's name is same as the passed node's name
            if (edge.getNode().getName().equalsIgnoreCase(n.getName())) {
                // return found!
                return true;
            }
        }

        // Otherwise, return false
        return false;
    }
}
