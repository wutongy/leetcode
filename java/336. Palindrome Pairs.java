// O(m*(n^2))
class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; ++i) {
            map.put(words[i], i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < words.length; ++i) {
            for (int j = 0; j <= words[i].length(); ++j) {
                String s1 = words[i].substring(0, j), s2 = words[i].substring(j);
                if (isPalindrome(s1)) {
                    String t = new StringBuilder(s2).reverse().toString();
                    if (map.getOrDefault(t, i) != i) {
                        res.add(Arrays.asList(map.get(t), i));
                    }
                }
                if (!s2.isEmpty() && isPalindrome(s2)) {
                    String t = new StringBuilder(s1).reverse().toString();
                    if (map.getOrDefault(t, i) != i) {
                        res.add(Arrays.asList(i, map.get(t)));
                    }
                }
            }
        }
        return res;
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j && s.charAt(i) == s.charAt(j)) {
            ++i;
            --j;
        }
        return i >= j;
    }
}
