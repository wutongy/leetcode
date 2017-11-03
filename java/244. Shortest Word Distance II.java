// O(n) for both
class WordDistance {
    private HashMap<String, List<Integer>> map = new HashMap<>();
    public WordDistance(String[] words) {
        for (int i = 0; i < words.length; ++i) {
            map.putIfAbsent(words[i], new ArrayList<>());
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        int res = Integer.MAX_VALUE;
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) < l2.get(j)) {
                res = Math.min(res, l2.get(j) - l1.get(i++));
            } else {
                res = Math.min(res, l1.get(i) - l2.get(j++));
            }
        }
        return res;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
