// O(m + n) time, O(n) space
public class Solution {
    public String[] findRestaurant(String[] list1, String[] slist2) {
        List<String> result = new ArrayList<>();
        int leastIndexSum = Integer.MAX_VALUE;
        Map<String, Integer> hmap = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            hmap.put(list1[i], i);
        }
        for (int i = 0; i < list2.length; i++) {
            if (hmap.containsKey(list2[i])) {
                int indexSum = hmap.get(list2[i]) + i;
                if (indexSum < leastIndexSum) {
                    leastIndexSum = indexSum;
                    result.clear();
                    result.add(list2[i]);
                } else if (indexSum == leastIndexSum) {
                    result.add(list2[i]);
                }
            }
        }
        return result.toArray(new String[0]);
    }
}
