// O(n)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        String dna = "ACGT";
        int[] num = new int[]{0, 1, 2, 3};
        if (s.length() < 11) {
            return res;
        }
        int mask = (1 << 18) - 1, cur = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            cur = (cur << 2) | num[dna.indexOf(s.charAt(i))];
            if (i >= 9) {
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                cur &= mask;
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                int n = entry.getKey();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 10; ++i) {
                    sb.append(dna.charAt(n & 3));
                    n >>>= 2;
                }
                res.add(sb.reverse().toString());
            }
        }
        return res;
    }
}
