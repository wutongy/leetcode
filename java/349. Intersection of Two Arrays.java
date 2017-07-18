public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        Set<Integer> hset = new HashSet<>();
        for (int num1 : nums1) {
            hset.add(num1);
        }
        for (int num2 : nums2) {
            if (hset.contains(num2)) {
                result.add(num2);
                hset.remove(num2);
            }
        }
        int[] arr = new int[result.size()];
        for (int i= 0; i < result.size(); i++) arr[i] = result.get(i);
        return arr;
    }
}
