// O(n)
class Solution {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        char[] cs = s.toCharArray();
        int i = 0, j = cs.length - 1;
        while (i < j) {
            while (i < j && vowels.indexOf(cs[i]) == -1) {
                ++i;
            }
            while (i < j && vowels.indexOf(cs[j]) == -1) {
                --j;
            }
            if (i < j) {
                char temp = cs[i];
                cs[i] = cs[j];
                cs[j] = temp;
                ++i;
                --j;
            }
        }
        return new String(cs);
    }
}
