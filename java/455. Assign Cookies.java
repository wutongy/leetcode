// O(nlogn)
public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int result = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = g.length - 1, j = s.length - 1;
        while (i >= 0 && j >= 0) {
            if (s[j] >= g[i]) {
                result += 1;
                j--;
            }
            i--;
        }
        return result;
    }
}
