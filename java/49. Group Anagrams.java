// O(n)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] cs = s.toCharArray();
            Arrays.sort(cs);
            String key = new String(cs);
            if (!map.containsKey(key)) {
                res.add(new ArrayList<>());
                map.put(key, res.get(res.size() - 1));
            }
            map.get(key).add(s);
        }
        return res;
    }
}
