// O(n^2)
class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int diff = 2 * numRows - 2;
        for (int i = 0; i < numRows; ++i) {
            int count = i;
            while (count < s.length()) {
                sb.append(s.charAt(count));
                if (i != 0 && i != numRows - 1) {
                    int nextIdx = count + 2 * (numRows - 1- i);
                    if (nextIdx < s.length()) {
                        sb.append(s.charAt(nextIdx));
                    }
                }
                count += diff;
            }
        }
        return sb.toString();
    }
}
