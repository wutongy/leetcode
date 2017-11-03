// O(n)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int count = words.length;
        int len = words[0].length();
        int i = 0;
        while (i < len && i + len * count <= s.length()) {
            int j = i, start = i;
            while (j + len <= s.length() && start + len * count <= s.length()) {
                String cur = s.substring(j, j + len);
                if (map.containsKey(cur)) {
                    if (map.get(cur) > 0) {
                        map.put(cur, map.get(cur) - 1);
                        --count;
                    } else {
                        while (start < j) {
                            String prev = s.substring(start, start + len);
                            if (prev.equals(cur)) {
                                start += len;
                                break;
                            } else {
                                map.put(prev, map.get(prev) + 1);
                                ++count;
                            }
                            start += len;
                        }
                    }
                    if (count == 0) {
                        res.add(start);
                    }
                    j += len;
                } else {
                    while (start < j) {
                        String prev = s.substring(start, start + len);
                        map.put(prev, map.get(prev) + 1);
                        ++count;
                        start += len;
                    }
                    j += len;
                    start = j;
                }
            }
            while (start < j) {
                String prev = s.substring(start, start + len);
                map.put(prev, map.get(prev) + 1);
                start += len;
            }
            ++i;
            count = words.length;
        }
        return res;
    }
}
