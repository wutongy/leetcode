DFS:

/**
 * Definition for undirected graph.
 * struct UndirectedGraphNode {
 *     int label;
 *     vector<UndirectedGraphNode *> neighbors;
 *     UndirectedGraphNode(int x) : label(x) {};
 * };
 */
class Solution {
private:
    unordered_map<UndirectedGraphNode*, UndirectedGraphNode*> hmap;

public:
    UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
        if (!node) return NULL;
        if (hmap.find(node) == hmap.end()) {
            hmap[node] = new UndirectedGraphNode(node->label);
            for (auto &ngbr : node->neighbors) {
                hmap[node]->neighbors.push_back(cloneGraph(ngbr));
            }
        }
        return hmap[node];
    }
};

BFS:

/**
 * Definition for undirected graph.
 * struct UndirectedGraphNode {
 *     int label;
 *     vector<UndirectedGraphNode *> neighbors;
 *     UndirectedGraphNode(int x) : label(x) {};
 * };
 */
class Solution {
private:
    unordered_map<UndirectedGraphNode*, UndirectedGraphNode*> hmap;
    
public:
    UndirectedGraphNode *cloneGraph(UndirectedGraphNode *node) {
        if (!node) return NULL;
        queue<UndirectedGraphNode*> q;
        UndirectedGraphNode* root = new UndirectedGraphNode(node->label);
        q.push(node);
        hmap[node] = root;
        while (!q.empty()) {
            UndirectedGraphNode* cur = q.front();
            q.pop();
            for (UndirectedGraphNode* &ngbr : cur->neighbors) {
                if (hmap.find(ngbr) == hmap.end()) {
                    hmap[ngbr] = new UndirectedGraphNode(ngbr->label);
                    q.push(ngbr);
                }
                hmap[cur]->neighbors.push_back(hmap[ngbr]);
            }
        }
        return root;
    }
};
