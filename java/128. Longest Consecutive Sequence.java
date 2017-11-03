// O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        for (int i : set) {
            if (!set.contains(i - 1)) {
                int j = i + 1;
                while (set.contains(j)) {
                    ++j;
                }
                max = Math.max(max, j - i);
            }
        }
        return max;
    }
}

// HashMap O(n)
class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            if (!map.containsKey(n)) {
                int left = map.getOrDefault(n - 1, 0);
                int right = map.getOrDefault(n + 1, 0);
                map.put(n, left + right + 1);
                res = Math.max(res, map.get(n));
                map.put(n - left, map.get(n));
                map.put(n + right, map.get(n));
            }
        }
        return res;
    }
}
