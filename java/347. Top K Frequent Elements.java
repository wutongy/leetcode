class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<HashSet<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            buckets.add(new HashSet<>());
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n)) {
                buckets.get(map.get(n) - 1).remove(n);
            }
            map.put(n, map.getOrDefault(n, 0) + 1);
            buckets.get(map.get(n) - 1).add(n);
        }
        List<Integer> res = new ArrayList<>();
        int i = buckets.size() - 1;
        while (i >= 0 && k > 0) {
            for (Integer e : buckets.get(i)) {
                res.add(e);
                --k;
                if (k == 0) {
                     break;
                }
            }
            --i;
        }
        return res;
    }
}

// O((n + k)logk)
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<Map.Entry<Integer, Integer>>(map.size(), new Comparator<Map.Entry<Integer, Integer>>() {
           public int compare(Map.Entry<Integer, Integer> a, Map.Entry<Integer, Integer> b) {
               return a.getValue() - b.getValue();
           }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        while (!pq.isEmpty()) {
            res.add(pq.poll().getKey());
        }
        Collections.reverse(res);
        return res;
    }
}
