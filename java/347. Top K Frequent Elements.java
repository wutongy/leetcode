// O(n)
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }
        List<Integer> res = new ArrayList<>();
        int i = bucket.length - 1;
        while (i >= 0 && k > 0) {
            if (bucket[i] != null) {
                for (int j = 0; j < bucket[i].size() && k > 0; ++j, --k) {
                    res.add(bucket[i].get(j));
                }
            }
            --i;
        }
        return res;
    }
}
