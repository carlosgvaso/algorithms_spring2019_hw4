package pset4;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class GraphTester {
    // tests for method "addEdge" in class "Graph"
    @Test public void tae0() {
        Graph g = new Graph();
        g.addEdge(0, 1);
        assertEquals(g.toString(), "nodes=[0, 1]; edges={0=[1]}");
    }

    // your tests for method "addEdge" in class "Graph" go here

    // you must provide at least 4 test methods;
    // each test method must have at least 1 invocation of addEdge;
    // each test method must have at least 1 test assertion;
    // your test methods must provide full statement coverage of your
    // implementation of addEdge and any helper methods
    // no test method directly invokes any method that is not
    // declared in the Graph class as given in this homework

    /**
     * 1. Test we can add an edge between 2 nodes already in the graph, and the
     * existing nodes are not added again.
     */
    @Test public void tae1() {
        Graph g = new Graph();
        g.addNode(0);
        g.addNode(1);
        g.addEdge(0, 1);
        //System.out.println(g.toString());
        assertEquals(g.toString(), "nodes=[0, 1]; edges={0=[1]}");
    }

    /**
     * 2. Test we can add an edge between 2 nodes that are not in the graph,
     * and the new nodes are added.
     */
    @Test public void tae2() {
        Graph g = new Graph();
        g.addEdge(0, 1);
        //System.out.println(g.toString());
        assertEquals(g.toString(), "nodes=[0, 1]; edges={0=[1]}");
    }

    /**
     * 	3. Test we can add multiple edges from one node to multiple others, from
     * multiple nodes to one node, and from multiple nodes to multiple nodes.
     */
    @Test public void tae3() {
        Graph g1 = new Graph();
        g1.addNode(0);
        g1.addNode(1);
        g1.addNode(2);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        //System.out.println(g1.toString());
        assertEquals(g1.toString(), "nodes=[0, 1, 2]; edges={0=[1, 2]}");

        Graph g2 = new Graph();
        g2.addNode(0);
        g2.addNode(1);
        g2.addNode(2);
        g2.addEdge(1, 0);
        g2.addEdge(2, 0);
        //System.out.println(g2.toString());
        assertEquals(g2.toString(), "nodes=[0, 1, 2]; edges={1=[0], 2=[0]}");

        Graph g3 = new Graph();
        g3.addNode(0);
        g3.addNode(1);
        g3.addNode(2);
        g3.addEdge(0, 1);
        g3.addEdge(1, 2);
        g3.addEdge(2, 0);
        //System.out.println(g2.toString());
        assertEquals(g3.toString(), "nodes=[0, 1, 2]; edges={0=[1], 1=[2], 2=[0]}");
    }

    /**
     * 4. Test that we can have parallel edges between the nodes.
     */
    @Test public void tae4() {
        Graph g = new Graph();
        g.addNode(0);
        g.addNode(1);
        g.addEdge(0, 1);
        g.addEdge(0, 1);
        //System.out.println(g.toString());
        assertEquals(g.toString(), "nodes=[0, 1]; edges={0=[1, 1]}");
    }

    /**
     * 5. Test that we can have self-loop edges (0->0).
     */
    @Test public void tae5() {
        Graph g = new Graph();
        g.addNode(0);
        g.addEdge(0, 0);
        //System.out.println(g.toString());
        assertEquals(g.toString(), "nodes=[0]; edges={0=[0]}");
    }

    /**
     * 6. Test that we can have edges in both directions (0->1 1->0).
     */
    @Test public void tae6() {
        Graph g = new Graph();
        g.addNode(0);
        g.addNode(1);
        g.addEdge(0, 1);
        g.addEdge(1, 0);
        //System.out.println(g.toString());
        assertEquals(g.toString(), "nodes=[0, 1]; edges={0=[1], 1=[0]}");
    }


    // tests for method "unreachable" in class "Graph"
    @Test public void tr0() {
        Graph g = new Graph();
        g.addNode(0);
        Set<Integer> nodes = new HashSet<Integer>();
        nodes.add(0);
        assertTrue(g.unreachable(new HashSet<Integer>(), nodes));
    }

    // your tests for method "unreachable" in class "Graph" go here

    // you must provide at least 6 test methods;
    // each test method must have at least 1 invocation of unreachable;
    // each test method must have at least 1 test assertion;
    // at least 2 test methods must have at least 1 invocation of addEdge;
    // your test methods must provide full statement coverage of your
    // implementation of unreachable and any helper methods
    // no test method directly invokes any method that is not
    // declared in the Graph class as given in this homework

    /**
     * 1. Test that unreachable returns true for sources = {0, 1} and targets = {2},
     * where the graph is: 0->1 2. Conditions (1), (2) and (3) are meet.
     */
    @Test public void tr1() {
        Graph g = new Graph();
        g.addNode(0);
        g.addNode(1);
        g.addNode(2);
        g.addEdge(0, 1);
        //System.out.println(g.toString());
        Set<Integer> sources = new HashSet<Integer>();
        sources.add(0);
        sources.add(1);
        Set<Integer> targets = new HashSet<Integer>();
        targets.add(2);
        assertTrue(g.unreachable(sources, targets));
    }

    /**
     * 2. Test that unreachable returns false for sources = {1, 2} and targets = {0},
     * where the graph is: 0->1. Conditions (2) and (3) are meet, but condition (1)
     * is not meet.
     */
    @Test public void tr2() {
        Graph g = new Graph();
        g.addNode(0);
        g.addNode(1);
        g.addEdge(0, 1);
        //System.out.println(g.toString());
        Set<Integer> sources = new HashSet<Integer>();
        sources.add(1);
        sources.add(2);
        Set<Integer> targets = new HashSet<Integer>();
        targets.add(0);
        assertFalse(g.unreachable(sources, targets));
    }

    /**
     * 3. Test that unreachable returns false for sources = {1} and targets = {0, 2},
     * where the graph is: 0->1. Conditions (1) and (3) are meet, but condition (2)
     * is not meet.
     */
    @Test public void tr3() {
        Graph g = new Graph();
        g.addNode(0);
        g.addNode(1);
        g.addEdge(0, 1);
        //System.out.println(g.toString());
        Set<Integer> sources = new HashSet<Integer>();
        sources.add(1);
        Set<Integer> targets = new HashSet<Integer>();
        targets.add(0);
        targets.add(2);
        assertFalse(g.unreachable(sources, targets));
    }

    /**
     * 4. Test that unreachable returns false for sources = {0} and targets = {1},
     * where the graph is: 0->1. Conditions (1) and (2) are meet, but condition (3)
     * is not meet.
     */
    @Test public void tr4() {
        Graph g = new Graph();
        g.addNode(0);
        g.addNode(1);
        g.addEdge(0, 1);
        //System.out.println(g.toString());
        Set<Integer> sources = new HashSet<Integer>();
        sources.add(0);
        Set<Integer> targets = new HashSet<Integer>();
        targets.add(1);
        assertFalse(g.unreachable(sources, targets));
    }

    /**
     * 5. Test that unreachable returns false for sources = {0, 2} and targets = {1, 3},
     * where the graph is: 0->1. Conditions (1), (2) and (3) are not meet.
     */
    @Test public void tr5() {
        Graph g = new Graph();
        g.addNode(0);
        g.addNode(1);
        g.addEdge(0, 1);
        //System.out.println(g.toString());
        Set<Integer> sources = new HashSet<Integer>();
        sources.add(0);
        sources.add(2);
        Set<Integer> targets = new HashSet<Integer>();
        targets.add(1);
        targets.add(3);
        assertFalse(g.unreachable(sources, targets));
    }

    /**
     * 6. Test IllegalargumentException is raised if the sources and targets are null.
     */
    @Test(expected = IllegalArgumentException.class) public void tr6() {
        Graph g = new Graph();
        g.addNode(0);
        g.addNode(1);
        g.addEdge(0, 1);
        //System.out.println(g.toString());
        Set<Integer> sources = null;
        Set<Integer> targets = null;
        assertNull(sources);
        assertNull(targets);
        g.unreachable(sources, targets);
    }

    /**
     * 7. Test IllegalargumentException is raised if the sources is null.
     */
    @Test(expected = IllegalArgumentException.class) public void tr7() {
        Graph g = new Graph();
        g.addNode(0);
        g.addNode(1);
        g.addEdge(0, 1);
        //System.out.println(g.toString());
        Set<Integer> sources = null;
        Set<Integer> targets = new HashSet<Integer>();
        targets.add(1);
        assertNull(sources);
        assertNotNull(targets);
        g.unreachable(sources, targets);
    }

    /**
     * 8. Test IllegalargumentException is raised if the targets is null.
     */
    @Test(expected = IllegalArgumentException.class) public void tr8() {
        Graph g = new Graph();
        g.addNode(0);
        g.addNode(1);
        g.addEdge(0, 1);
        //System.out.println(g.toString());
        Set<Integer> sources = new HashSet<Integer>();
        sources.add(0);
        Set<Integer> targets = null;
        assertNotNull(sources);
        assertNull(targets);
        g.unreachable(sources, targets);
    }

    /**
     * 9. Test that unreachable returns true for sources = {0} and targets = {0},
     * where the graph is: 0->1. Here, there is no self-loop, so node 0 should not
     * be reachable from itself.
     */
    @Test public void tr9() {
        Graph g = new Graph();
        g.addNode(0);
        g.addNode(1);
        g.addEdge(0, 1);
        //System.out.println(g.toString());
        Set<Integer> sources = new HashSet<Integer>();
        sources.add(0);
        Set<Integer> targets = new HashSet<Integer>();
        targets.add(0);
        assertTrue(g.unreachable(sources, targets));
    }

    /**
     * 10. Test that unreachable returns false for sources = {0} and targets = {0},
     * where the graph is: 0->0. Here, there is a self-loop, so node 0 should
     * be reachable from itself.
     */
    @Test public void tr10() {
        Graph g = new Graph();
        g.addNode(0);
        g.addEdge(0, 0);
        //System.out.println(g.toString());
        Set<Integer> sources = new HashSet<Integer>();
        sources.add(0);
        Set<Integer> targets = new HashSet<Integer>();
        targets.add(0);
        assertFalse(g.unreachable(sources, targets));
    }

    /**
     * 11. Test that unreachable returns true for sources and targets as empty sets,
     * where the graph is: 0->1. The empty sets are subsets of every set, so conditions
     * (1) and (2) should be meet. Moreover, condition (3) is also meet trivially.
     */
    @Test public void tr11() {
        Graph g = new Graph();
        g.addNode(0);
        g.addNode(1);
        g.addEdge(0, 1);
        //System.out.println(g.toString());
        Set<Integer> sources1 = new HashSet<Integer>();
        Set<Integer> targets1 = new HashSet<Integer>();
        assertTrue(g.unreachable(sources1, targets1));

        Set<Integer> sources2 = new HashSet<Integer>();
        Set<Integer> targets2 = new HashSet<Integer>();
        targets2.add(0);
        assertTrue(g.unreachable(sources2, targets2));

        Set<Integer> sources3 = new HashSet<Integer>();
        sources3.add(0);
        Set<Integer> targets3 = new HashSet<Integer>();
        assertTrue(g.unreachable(sources3, targets3));
    }

}
