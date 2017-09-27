/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
// O(v + e)
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
        return helper(node, map);
    }

    private UndirectedGraphNode helper(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map) {
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(newNode.label, newNode);
        for (UndirectedGraphNode ugn : node.neighbors) {
            if (!map.containsKey(ugn.label)) {
                newNode.neighbors.add(helper(ugn, map));
            } else {
                newNode.neighbors.add(map.get(ugn.label));
            }
        }
        return newNode;
    }
}
