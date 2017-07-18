public class Solution {
    public int minCost(int[][] costs) {
        if (costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        int l = costs.length, h = costs[0].length;
        int[] prev = new int[h];
        for (int i = 0; i < h; i++) {
            prev[i] = costs[0][i];
        }
        for (int i = 1; i < l; i++) {
            int[] cur = new int[h];
            for (int j = 0; j < h; j++) {
                int minElem = Integer.MAX_VALUE;
                for (int k = 0; k < h; k++) {
                    if (k != j) {
                        minElem = Math.min(minElem, prev[k]);
                    }
                    cur[j] = costs[i][j] + minElem;
                }
            }
            prev = cur;
        }
        int result = prev[0];
        for (int i = 1; i < h; i++) {
            result = Math.min(result, prev[i]);
        }
        return result;
    }
}
