package pset4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {

    private Set<Integer> nodes; // set of nodes in the graph
    private Map<Integer, List<Integer>> edges;

    // map between a node and a list of nodes that are connected to it by outgoing edges
    // class invariant: fields "nodes" and "edges" are non-null;
    // "this" graph has no node that is not in "nodes"

    public Graph() {
        nodes = new HashSet<Integer>();
        edges = new HashMap<Integer, List<Integer>>();
    }

    public String toString() {
        return "nodes: " + nodes + "\n" + "edges: " + edges;
    }

    public void addNode(int n) {
        // postcondition: adds the node "n" to this graph
        nodes.add(n);
    }

    public void addEdge(int from, int to) {
        // postcondition: adds a directed edge "from" -> "to" to this graph

        // your code goes here
        // ...

        // ensure the "from" and "to" nodes are in the set, so we don't break the invariant
        this.addNode(from);
        this.addNode(to);

        // Add the edge to the map.Note we allow to add parallel edges, since
        // it was not specified if the class represents a single graph or multigraph.
        // check if the "from" node is on the map already
        if (!edges.containsKey(from)) {
            // if it is not, add it
            List<Integer> adjNodes = new ArrayList<>();
            adjNodes.add(to);
            edges.put(from, adjNodes);
        } else {
            // if it is, add the "to" node to its list
            edges.get(from).add(to);
        }
    }

    public boolean unreachable(Set<Integer> sources, Set<Integer> targets) {
        if (sources == null || targets == null) throw new IllegalArgumentException();
        // postcondition: returns true if
        //     (1) "sources" is a subset of "nodes",
        //     (2) "targets" is a subset of "nodes", and
        //     (3) for each node "m" in set "targets", there is no node "n" in set
        //         "sources" such that there is a directed path that starts at "n"
        //         and ends at "m" in "this";
        // and false otherwise

        // your code goes here
        // ...

        // Check that "sources" is a subset of "nodes" (1)
        if (!isSubset(sources, nodes)) {
            return false;
        }

        // Check that "targets" is a subset of "nodes" (2)
        if (!isSubset(targets, nodes)) {
            return false;
        }

        // Check (3):
        // Check that the nodes adjacent to each of the sources are not contained
        // in the targets set
        List<Integer> adjNodes;
        // Iterate over all the sources
        for (Integer source : sources) {
            // Get the adjacent nodes to each source
            adjNodes = edges.get(source);
            // Iterate over all the targets
            for (Integer target : targets) {
                // Check if the target is adjacent to the source
                if (adjNodes != null && adjNodes.contains(target)) {
                    return false;    // A target is reachable from a source
                }
            }
        }

        // No check failed, thus the targets are not reachable from the sources
        return true;
    }

    private boolean isSubset(Set<Integer> subset, Set<Integer> superset) {
        // postcondition: returns true if "subset" is a subset of "superset".

        // Empty sets are subsets of every set. Add check to ensure this.
        if (subset.isEmpty()) {
            return true;
        }
        return superset.containsAll(subset);
    }

}
