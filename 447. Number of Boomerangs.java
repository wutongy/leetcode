// O(n^2)
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> hmap = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (j != i) {
                    int xdiff = points[i][0] - points[j][0];
                    int ydiff = points[i][1] - points[j][1];
                    int diff = xdiff * xdiff + ydiff * ydiff;
                    int count = hmap.getOrDefault(diff, 0);
                    result += count * 2;
                    hmap.put(diff, count + 1);
                }
            }
        }
        return result;
    }
}
