import java.util.LinkedList;

/**
 * ------------------------------------
 * Graph Traversal
 *
 * @author Maverick G. Fabroa
 * Date: November 6, 2022
 * ------------ Features: -------------
 * 1. Greedy Best-First Search
 * 2. A* Search
 * ------------------------------------
 */
public class MavyGraphTraversal {
    private final LinkedList<Node> graph;

    public MavyGraphTraversal() {
        this.graph = new LinkedList<>();
    }

    /**
     * Add place to the list of places.
     *
     * @param place name of the place
     * @param h heuristic value
     * @return 0 if successful, -1 if not
     */
    public int addPlace(String place, double h) {
        return addPlace(place, null, h);
    }

    /**
     * Add place to the list of places with label.
     *
     * @param place name of the place
     * @param label label of the place
     * @param h heuristic value
     * @return 0 if successful, -1 if not
     */
    public int addPlace(String place, String label, double h) {
        // Check if place already existed in the graph
        if (isPlaceExist(place)) {
            // Just return -1 (will show message)
            return -1;
        }

        // If not exist, create new node
        Node node = new Node(place, label);
        // Set its heuristic value
        node.setH(h);
        // Add it to the graph
        graph.add(node);
        // return success
        return 0;
    }

    /**
     * Connect 2 vertices with distance (Directed)
     *
     * @param v1
     * @param v2
     * @param weight
     * @return 0 if successful, -1 if not
     */
    public int connect(int v1, int v2, double weight) {
        return connect(v1, v2, weight, false);
    }

    /**
     * Connect 2 vertices with distance (with option to make it undirected)
     *
     * @param v1
     * @param v2
     * @param weight
     * @return 0 if successful, -1 if not
     */
    public int connect(int v1, int v2, double weight, boolean isUndirected) {
        // If v1 or v2 is out of range
        if (isOutOfRange(v1) || isOutOfRange(v2)) {
            // return error code (will show message
            return -1;
        }

        // Get v1 and v2
        Node n1 = graph.get(v1);
        Node n2 = graph.get(v2);

        // If n2 is already a neighbor of n1
        if (n1.isNeighbor(n2)) {
            // discard (will show message)
            return -1;
        }

        // Set n2 as neighbor of n1
        n1.addNeighbor(n2, weight);

        // If is undirected
        if (isUndirected) {
            // If n1 is already a neighbor of n2
            if (n2.isNeighbor(n1)) {    
                // discard (will show message)
                return -1;
            }

            // Set n1 as neighbor of n2
            n2.addNeighbor(n1, weight);
        }

        // Return success
        return 0;
    }

    /**
     * Do a Greedy-Best First Search to the Graph
     *
     * @param startPlace starting place
     * @param goalPlace goal place
     */
    public void GBFS(int startPlace, int goalPlace) {
        // If startPlace or goalPlace doesn't exist in the graph
        if (isOutOfRange(startPlace) || isOutOfRange(goalPlace)) {
            // don't proceed (will show message)
            return;
        }

        // Get startPlace and goalPlace's node
        Node sp = graph.get(startPlace);
        Node gp = graph.get(goalPlace);

        // Declare open list
        LinkedList<Node> open = new LinkedList<>();

        // Add sp to open
        open.add(sp);

        // While open is not empty
        while (!open.isEmpty()) {
            // Get and remove the node w/ the lowest f(n) value from open list
            Node n = getLowestF(open);
            // Set n as visited
            n.setVisited(true);

            // If current node is the goalPlace
            if (n.getName().equalsIgnoreCase(gp.getName())) {
                // Found!
                System.out.println("------- Greedy Best-First Search -------");
                // Get path
                LinkedList<Node> path = getPath(n);
                // Display
                displayPath(path);
                displayLabelWithName(path);
                return;
            }

            // For every edge (neighbor) of n
            for (Edge e : n.getNeighbors()) {
                // Get neighbor
                Node m = e.getNode();

                // If neighbor is not visited
                if (!m.isVisited()) {
                    // Set f(m) = h(m)
                    m.setF(m.getH());
                    // Set n as parent of this neighbor
                    m.setParent(n);
                    // Add it to the open list
                    open.add(m);
                }
            }
        }

        // If not found, show message
        System.out.println("GBFS: No path to goal");
    }

    /**
     * Do an A* search to the graph
     *
     * @param startPlace starting place
     * @param goalPlace goal place
     */
    public void Astar(int startPlace, int goalPlace) {
        // If startPlace or goalPlace doesn't exist in the graph
        if (isOutOfRange(startPlace) || isOutOfRange(goalPlace)) {
            // don't proceed (will show message)
            return;
        }

        // Get startPlace and goalPlace's node
        Node sp = graph.get(startPlace);
        Node gp = graph.get(goalPlace);

        // Create empty list of open and closed nodes
        LinkedList<Node> open = new LinkedList<>();
        LinkedList<Node> closed = new LinkedList<>();

        // f(n) = g(n) = h(n)
        sp.setF(sp.getG() + sp.getH());
        // Add sp to open list
        open.add(sp);

        // While open list is not empty
        while (!open.isEmpty()) {
            // Get and remove the node w/ the lowest f(n) value from open list
            Node n = getLowestF(open);

            // If current node is the goalPlace
            if (n.getName().equalsIgnoreCase(gp.getName())) {
                // Found!
                System.out.println("--------------- A* Search ---------------");
                // Get path
                LinkedList<Node> path = getPath(n);
                // Display
                displayPath(path);
                displayLabelWithName(path);
                return;
            }

            // For every edge (neighbor) of n
            for (Edge e : n.getNeighbors()) {
                // Get neighbor
                Node m = e.getNode();
                // Get g(m) (current.g + m.weight)
                double g = m.getG() + e.getWeight();

                // If neighbor is not in closed list AND neighbor is not in open list
                if (!isPlaceExist(open, m.getName()) && !isPlaceExist(closed, m.getName())) {
                    // Set g(m)
                    m.setG(g);
                    // Calculate f(m) = g(m) + h(m)
                    m.setF(m.getG() + m.getH());
                    // Set n as parent of m
                    m.setParent(n);
                    // Add m to open
                    open.add(m);
                    // Continue to next neighbor
                    continue;
                }

                // If current g(n) is lesser than the current node's g(n)
                if (g < m.getG()) {
                    // Set n as parent of m
                    m.setParent(n);
                    // Set g (current.g + m.weight)
                    m.setG(g);
                    // Calculate f(m) = g(m) + h(m)
                    m.setF(m.getG() + m.getH());

                    // If neighbor is in closed list
                    if (isPlaceExist(closed, m.getName())) {
                        // Add it to open list
                        open.add(m);
                    }
                }
            }

            // No need to remove n from open list
            // since it will remove automatically when getting the lowest f(n)

            // Add n to the close list
            closed.add(n);
        }

        // If not found, show message
        System.out.println("A* Search: No path to goal");
    }

    /* ================= Utility ================= */

    /**
     * Get path
     *
     * @param n the node place
     * @return list of node's in path (order)
     */
    private LinkedList<Node> getPath(Node n) {
        // Create empty path
        LinkedList<Node> path = new LinkedList<>();

        // While n has a parent
        while (n.getParent() != null) {
            // Add the current node to path
            path.addFirst(n);
            // Set node to its parent
            n = n.getParent();
        }

        // Lastly, add the last parent to the path
        path.addFirst(n);
        // Return the path
        return path;
    }

    /**
     * Get the lowest f(n) value
     *
     * @param list
     * @return the node w/ the lowest f(n) value
     */
    private Node getLowestF(LinkedList<Node> list) {
        return getLowestF(list, true);
    }

    /**
     * Get the lowest f(n) value and add an option to remove it in the list
     *
     * @param list
     * @param willRemoveFromList
     * @return the node w/ the lowest f(n) value
     */
    private Node getLowestF(LinkedList<Node> list, boolean willRemoveFromList) {
        // Default lowest
        int lowest = 0;

        // For every node
        for (int i = 1; i < list.size(); i++) {
            // If current node's f(n) is lesser than the declared lowest f(n) value
            if (list.get(i).getF() < list.get(lowest).getF()) {
                // Set lowest to current node
                lowest = i;
            }
        }

        // Get the node w/ the lowest f(n) value
        Node n = list.get(lowest);

        // If will remove from list
        if (willRemoveFromList) {
            // Remove lowest f(n) value in the list
            list.remove(lowest);
        }

        // Return the node
        return n;
    }

    /**
     * Display path
     *
     * @param path list of place as nodes
     */
    private void displayPath(LinkedList<Node> path) {
        System.out.print("\n[ ");

        // For every place in path
        for (int i = 0; i < path.size(); i++) {
            // Get current place and show label
            System.out.print(path.get(i).getLabel() + (i == path.size() - 1 ? "" : " -> "));
        }

        System.out.println(" ]\n");
    }

    /**
     * Display every place's label with name
     *
     * @param path list of place as nodes
     */
    private void displayLabelWithName(LinkedList<Node> path) {
        // For every place in path
        for (Node place : path) {
            // If place has label
            if (!place.getLabel().equalsIgnoreCase(place.getName())) {
                // Show label
                System.out.println(place.getLabel() + " = " + place.getName());
            }
        }

        System.out.println("");
    }


    /**
     * Check if place exist in the graph
     *
     * @param name name of the place
     * @return true if existed, false otherwise
     */
    private boolean isPlaceExist(String name) {
       return isPlaceExist(graph, name);
    }

    /**
     * Check if place exist in the given list
     *
     * @param list list of nodes
     * @param name name of place
     * @return true if existed, false otherwise
     */
    private boolean isPlaceExist(LinkedList<Node> list, String name) {
        // For every node
        for (Node n : list) {
            // If place name is the current node
            if (n.getName().equalsIgnoreCase(name)) {
                // place exist!
                return true;
            }
        }

        // Otherwise, return false
        return false;
    }

    /**
     * Determine whether the given index is out of range
     *
     * @param index place index
     * @return true if out of range, false if not
     */
    private boolean isOutOfRange(int index) {
        return index < 0 || index >= this.graph.size();
    }
}
