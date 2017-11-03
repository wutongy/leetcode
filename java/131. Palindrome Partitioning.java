class Solution {
    private HashMap<Integer, Boolean> map;
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        map = new HashMap<>();
        dfs(s, 0, new ArrayList<String>(), res);
        return res;
    }

    private void dfs(String s, int start, ArrayList<String> path, List<List<String>> res) {
        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); ++i) {
            if (i == start || (s.charAt(start) == s.charAt(i) && isPalindrome(s, start + 1, i - 1))) {
                path.add(s.substring(start, i + 1));
                dfs(s, i + 1, path, res);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        if (i >= j) {
            return true;
        }
        int idx = i * s.length() + j;
        if (map.containsKey(idx)) {
            return map.get(idx);
        }
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                map.put(idx, false);
                return false;
            }
            ++i;
            --j;
        }
        map.put(idx, true);
        return true;
    }
}
