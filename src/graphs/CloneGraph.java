package graphs;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * https://www.interviewbit.com/problems/clone-graph/
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */
public class CloneGraph {
    public HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode oldNode) {
        if (oldNode == null) {
            return null;
        }
        if (map.containsKey(oldNode))
            return map.get(oldNode);

        UndirectedGraphNode newNode = new UndirectedGraphNode(oldNode.label);
        map.put(oldNode, newNode);
        ArrayList<UndirectedGraphNode> newNeighbors = new ArrayList<>();

        for (UndirectedGraphNode oldChild : oldNode.neighbors) {
            newNeighbors.add(cloneGraph(oldChild));
        }

        newNode.neighbors = newNeighbors;

        return newNode;
    }

    public static class UndirectedGraphNode {
        int label;
        ArrayList<UndirectedGraphNode> neighbors;

        UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
}
