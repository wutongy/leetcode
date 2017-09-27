// binary search
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1];
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0, j = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; ++i) {
                while (j >= 0 && matrix[i][j] > mid) {
                    --j;
                }
                count += (j + 1);
            }
            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
}

// Priority Queue O(klogn)
class Solution {
    private class Tuple implements Comparable<Tuple> {
        int x, y, val;
        Tuple(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Tuple t) {
            return this.val - t.val;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();
        for (int j = 0; j < n; ++j) {
            pq.offer(new Tuple(0, j, matrix[0][j]));
        }
        for (int i = 0; i < k - 1; ++i) {
            Tuple t = pq.poll();
            if (t.x != n - 1) {
                pq.offer(new Tuple(t.x + 1, t.y, matrix[t.x + 1][t.y]));
            }
        }
        return pq.poll().val;
    }
}
