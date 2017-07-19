// O(n)
public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int num : nums1) {
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int num: nums2) {
            if (hmap.containsKey(num)) {
                result.add(num);
                if (hmap.get(num) == 1) {
                    hmap.remove(num);
                } else {
                    hmap.put(num, hmap.get(num) - 1);
                }
            }
        }
       int[] r = new int[result.size()];
       for(int i = 0; i < result.size(); i++)
       {
           r[i] = result.get(i);
       }
       return r;
    }
}
