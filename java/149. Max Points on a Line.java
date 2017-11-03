/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
// O(n^2)
class Solution {
    public int maxPoints(Point[] points) {
        int res = 0;
        for (int i = 0; i < points.length; ++i) {
            HashMap<String, Integer> map = new HashMap<>();
            int sameP = 0, maxCount = 0;
            for (int j = i + 1; j < points.length; ++j) {
                int diffX = points[i].x - points[j].x;
                int diffY = points[i].y - points[j].y;
                if (diffX == 0 && diffY == 0) {
                    ++sameP;
                    continue;
                }
                int gcd = gcd(diffX, diffY);
                String key = (diffY / gcd) + "_" + (diffX / gcd);
                map.put(key, map.getOrDefault(key, 0) + 1);
                maxCount = Math.max(maxCount, map.get(key));
            }
            res = Math.max(res, maxCount + sameP + 1);
        }
        return res;
    }

    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
}
