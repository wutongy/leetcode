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
    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }
    public int maxPoints(Point[] points) {
        if (points.length <= 2) {
            return points.length;
        }
        int result = 0;
        for (int i = 0; i < points.length; ++i) {
            Map<String, Integer> map = new HashMap<>();
            int samex = 1;
            int samey = 1;
            int samep = 0;
            for (int j = 0; j < points.length; ++j) {
                if (j != i) {
                    if ((points[j].x == points[i].x) && (points[j].y == points[i].y)) {
                        samep++;
                    }
                    if (points[j].x == points[i].x) {
                        samex++;
                        continue;
                    }
                    if (points[j].y == points[i].y) {
                        samey++;
                        continue;
                    }
                    int numerator = points[j].y - points[i].y;
                    int denominator = points[j].x - points[i].x;
                    int gcd = gcd(numerator, denominator);
                    String hashStr = (numerator / gcd) + " " + (denominator / gcd);
                    map.put(hashStr, map.getOrDefault(hashStr, 1) + 1);
                    result = Math.max(result, map.get(hashStr) + samep);
                }
            }
            result = Math.max(result, Math.max(samex, samey));
        }
        return result;
    }
}
