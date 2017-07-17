// O(n)
public class Solution {
    public int firstUniqChar(String s) {
        int[] bucket = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int diff = s.charAt(i) - 'a';
            if (bucket[diff] == 0) {
                bucket[diff] = i + 1;
            } else {
                bucket[diff] = -1;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            int diff = s.charAt(i) - 'a';
            if (bucket[diff] > 0) {
                return bucket[diff] - 1;
            }
        }
        return -1;
    }
}
