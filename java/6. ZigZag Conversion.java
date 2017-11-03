// O(n)
class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int diff = 2 * numRows - 2;
        for (int i = 0; i < numRows; ++i) {
            int nextDist = (numRows - i - 1) * 2;
            int j = i;
            while (j < s.length()) {
                sb.append(s.charAt(j));
                if (nextDist > 0 && diff != nextDist && j + nextDist < s.length()) {
                    sb.append(s.charAt(j + nextDist));
                }
                j += diff;
            }
        }
        return sb.toString();
    }
}
