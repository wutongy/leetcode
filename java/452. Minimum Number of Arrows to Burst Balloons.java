// O(nlogn)
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        int res = 0;
        for (int i = 0; i < points.length;) {
            ++res;
            int j = i + 1;
            while (j < points.length && points[i][1] >= points[j][0]) {
                ++j;
            }
            i = j;
        }
        return res;
    }
}
