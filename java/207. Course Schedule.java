// O(v+e)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[][] edges = new boolean[numCourses][numCourses];
        for (int i = 0; i < prerequisites.length; ++i) {
            edges[prerequisites[i][1]][prerequisites[i][0]] = true;
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            if (visited[i] == 0) {
                if (!dfs(i, edges, visited)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int i, boolean[][] edges, int[] visited) {
        if (visited[i] == 2) {
            return true;
        }
        if (visited[i] == 1) {
            return false;
        }
        visited[i] = 1;
        for (int j = 0; j < edges.length; ++j) {
            if (j != i && edges[i][j]) {
                if(!dfs(j, edges, visited)) {
                    return false;
                }
            }
        }
        visited[i] = 2;
        return true;
    }
}
