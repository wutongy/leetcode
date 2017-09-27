class Solution {
    public List<String> letterCombinations(String digits) {
        String[] numToChars = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        dfs(digits, 0, numToChars, res, sb);
        return res;
    }

    private void dfs(String digits, int start, String[] numToChars, List<String> res, StringBuilder sb) {
        if (start == digits.length()) {
            res.add(sb.toString());
            return;
        }
        int sbLen = sb.length();
        for (char c : numToChars[digits.charAt(start) - '0'].toCharArray()) {
            sb.append(c);
            dfs(digits, start + 1, numToChars, res, sb);
            sb.setLength(sbLen);
        }
    }
}

// iterative queue based
class Solution {
    public List<String> letterCombinations(String digits) {
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer("");
        int i = 0;
        while (i < digits.length()) {
            int size = queue.size();
            char[] cs = map[digits.charAt(i) - '0'].toCharArray();
            while (size-- > 0) {
                String cur = queue.poll();
                for (char c : cs) {
                    queue.offer(cur + c);
                }
            }
            ++i;
        }
        res.addAll(queue);
        return res;
    }
}
