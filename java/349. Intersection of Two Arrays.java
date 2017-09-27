// O(n)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int n1 : nums1) {
            set.add(n1);
        }
        List<Integer> res = new ArrayList<>();
        for (int n2 : nums2) {
            if (set.contains(n2)) {
                res.add(n2);
                set.remove(n2);
            }
        }
        int[] result = new int[res.size()];
        int i = 0;
        for (Integer num : res) {
            result[i++] = num;
        }
        return result;
    }
}
