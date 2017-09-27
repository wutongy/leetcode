class Solution {
    private boolean isConnected;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> wlist = new HashSet<>(wordList);
        if (!wlist.contains(endWord)) {
            return res;
        }
        isConnected = false;
        Set<String> fwd = new HashSet<>();
        fwd.add(beginWord);
        Set<String> bwd = new HashSet<>();
        bwd.add(endWord);
        Map<String, List<String>> map = new HashMap<>();
        BFS(fwd, bwd, wlist, false, map);
        if (!isConnected) {
            return res;
        }
        List<String> tmp = new ArrayList<>();
        tmp.add(beginWord);
        DFS(res, tmp, beginWord, endWord, map);
        return res;
    }

    public void BFS(Set<String> forward, Set<String> backward, Set<String> dict, boolean swap, Map<String, List<String>> map) {
        dict.removeAll(forward);
        dict.removeAll(backward);
        Set<String> next = new HashSet<>();
        for (String word : forward) {
            char[] wordArray = word.toCharArray();
            for (int i = 0; i < wordArray.length; ++i) {
                char old = wordArray[i];
                for (char c = 'a'; c <= 'z'; ++c) {
                    wordArray[i] = c;
                    String str = String.valueOf(wordArray);
                    String key = !swap ? word : str;
                    String val = !swap ? str : word;
                    if (!map.containsKey(key)) {
                        map.put(key, new ArrayList<>());
                    }
                    if (backward.contains(str)) {
                        map.get(key).add(val);
                        isConnected = true;
                    }
                    if (!isConnected && dict.contains(str)) {
                        map.get(key).add(val);
                        next.add(str);
                    }
                }
                wordArray[i] = old;
            }
        }
        if (!isConnected && next.size() > 0) {
            forward = next;
            if (next.size() >= backward.size()) {
                forward = backward;
                backward = next;
                swap = !swap;
            }
            BFS(forward, backward, dict, swap, map);
        }
    }

    public void DFS(List<List<String>> res, List<String> tmp, String start, String end, Map<String, List<String>> map) {
        if (start.equals(end)) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        if (!map.containsKey(start)) {
            return;
        }
        for (String s : map.get(start)) {
            tmp.add(s);
            DFS(res, tmp, s, end, map);
            tmp.remove(tmp.size() - 1);
        }
    }
}
