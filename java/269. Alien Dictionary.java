
class Solution {
    private boolean dfs(char cur, Map<Character, Set<Character>> map, int[] visited, StringBuilder sb) {
        System.out.println(cur);
        if (visited[cur - 'a'] == 1) {
            return false;
        }
        if (visited[cur - 'a'] == 2) {
            return true;
        }
        visited[cur - 'a'] = 1;
        if (map.containsKey(cur)) {
            for (char c : map.get(cur)) {
                if (!dfs(c, map, visited, sb)) {
                    return false;
                }
            }
        }
        visited[cur - 'a'] = 2;
        sb.append(cur);
        return true;
    }
    public String alienOrder(String[] words) {
        int[] indegree = new int[26];
        Arrays.fill(indegree, -1);
        StringBuilder sb = new StringBuilder();
        Map<Character, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            boolean same = true;
            for (int j = 0; j < words[i].length(); ++j) {
                if (indegree[words[i].charAt(j) - 'a'] == -1) {
                    indegree[words[i].charAt(j) - 'a'] = 0;
                }
                if (i != 0 && same && j < words[i - 1].length() && words[i - 1].charAt(j) != words[i].charAt(j)) {
                    if (map.containsKey(words[i].charAt(j)) && map.get(words[i].charAt(j)).contains(words[i - 1].charAt(j))) {
                        return "";
                    }
                    map.putIfAbsent(words[i - 1].charAt(j), new HashSet<>());
                    map.get(words[i - 1].charAt(j)).add(words[i].charAt(j));
                    same = false;
                }
            }
        }
        for (int i = 0; i < 26; ++i) {
            if (indegree[i] == 0) {
                if(!dfs((char) ('a' + i), map, indegree, sb)) {
                    return "";
                }
            }
        }
        return sb.reverse().toString();
    }
}
