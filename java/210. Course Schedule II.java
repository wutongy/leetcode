class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        int count = 0;
        int[] order = new int[numCourses];
        for (int i = 0; i < numCourses; ++i) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; ++i) {
            indegree[prerequisites[i][0]]++;
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for (int i = 0; i < numCourses; ++i) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            order[count++] = pre;
            for (int course : graph.get(pre)) {
                if (--indegree[course] == 0) {
                    queue.offer(course);
                }
            }
        }
        if (count == numCourses) {
            return order;
        }
        return new int[0];
    }
}
