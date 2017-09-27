class Solution {
    int[] dirs = {0, -1, 0, 1, 0};
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; ++i) {
            for (int j = 0; j < rooms[0].length; ++j) {
                if (rooms[i][j] == 0) {
                    for (int k = 0; k < dirs.length - 1; ++k) {
                        floodFill(rooms, 1, i + dirs[k], j + dirs[k + 1]);
                    }
                }
            }
        }
    }

    private void floodFill(int[][] rooms, int val, int i, int j) {
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || rooms[i][j] == 0 || rooms[i][j] == -1 || rooms[i][j] <= val) {
            return;
        }
        rooms[i][j] = val;
        for (int k = 0; k < dirs.length - 1; ++k) {
            floodFill(rooms, val + 1, i + dirs[k], j + dirs[k + 1]);
        }
    }
}

// BFS O(mn)
class Solution {
    private static final int[] d = {0, 1, 0, -1, 0};
    public void wallsAndGates(int[][] rooms) {
        if (rooms.length == 0) {
            return;
        }
        int m = rooms.length, n = rooms[0].length;

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (rooms[i][j] == 0) {
                    queue.offer(i * n + j);
                }
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int i = x / n, j = x % n;
            for (int k = 0; k < 4; ++k) {
                int p = i + d[k], q = j + d[k + 1];
                if (p >= 0 && p < m && q >= 0 && q < n && rooms[p][q] == Integer.MAX_VALUE) {
                    rooms[p][q] = rooms[i][j] + 1;
                    queue.offer(p * n + q);
                }
            }
        }
    }
}
