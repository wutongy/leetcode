// O(n * len(word)log(len(word)))
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String ss = String.valueOf(cs);
            map.putIfAbsent(ss, new ArrayList<>());
            map.get(ss).add(s);
        }
        List<List<String>> res = new ArrayList<>();
        res.addAll(map.values());
        return res;
    }
}
