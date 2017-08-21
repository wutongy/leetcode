// O(nm)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            int j;
            for (j = 1; j < strs.length; ++j) {
                if (i >= strs[j].length() || i >= strs[j - 1].length() || strs[j].charAt(i) != strs[j - 1].charAt(i)) {
                    break;
                }
            }
            if (j < strs.length) {
                break;
            }
            sb.append(strs[0].charAt(i));
            ++i;
        }

        return sb.toString();
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String pre = strs[0];
        int i = 1;
        while (i < strs.length) {
            while (strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
            }
            ++i;
        }
        return pre;
    }
}
