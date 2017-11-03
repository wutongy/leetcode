// O(n*min(len(strs)))
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < strs[0].length()) {
            char cur = strs[0].charAt(i);
            for (int j = 1; j < strs.length; ++j) {
                if (i >= strs[j].length() || strs[j].charAt(i) != cur) {
                    return sb.toString();
                }
            }
            sb.append(cur);
            ++i;
        }
        return sb.toString();
    }
}
