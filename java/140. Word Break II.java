// O(n^2)
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return helper(s, 0, new HashSet<String>(wordDict), new HashMap<Integer, List<String>>());
    }

    private List<String> helper(String s, int start, HashSet<String> set, HashMap<Integer, List<String>> map) {
        if (map.containsKey(start)) {
            return map.get(start);
        }
        List<String> res = new ArrayList<>();
        if (start == s.length()) {
            return res;
        }
        for (int i = start; i < s.length(); ++i) {
            String sub = s.substring(start, i + 1);
            if (set.contains(sub)) {
                if (i == s.length() - 1) {
                    res.add(sub);
                } else {
                    List<String> subRes = helper(s, i + 1, set, map);
                    for (String ss : subRes) {
                        res.add(sub + " " + ss);
                    }
                }
            }
        }
        map.put(start, res);
        return res;
    }
}


class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> dict = new HashSet<>(wordDict);
        HashMap<Integer, List<String>> map = new HashMap<>();
        return wordBreak(s, 0, s.length() - 1, dict, map);
    }

    private List<String> wordBreak(String s, int start, int end, HashSet<String> dict, HashMap<Integer, List<String>> map) {
        if (map.containsKey(start * s.length() + end)) {
            return map.get(start * s.length() + end);
        }
        List<String> res = new ArrayList<>();
        if (start > end) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; ++i) {
            sb.append(s.charAt(i));
            String cur = sb.toString();
            if (dict.contains(cur)) {
                if (i != end) {
                    List<String> next = wordBreak(s, i + 1, end, dict, map);
                    if (next.size() != 0) {
                        for (String str : next) {
                            res.add(cur + " " + str);
                        }
                    }
                } else {
                    res.add(cur);
                }
            }
        }
        map.put(start * s.length() + end, res);
        return res;
    }
}
