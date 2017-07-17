// O(nlogn)
public class Solution {
    public String[] findRelativeRanks(int[] nums) {
        Map<Integer, Integer> hmap = new HashMap<>();
        List<String> result = new ArrayList<>();
        int[] clone = Arrays.copyOf(nums, nums.length);
        Arrays.sort(clone);
        for (int i = 0; i < clone.length; i++) {
            hmap.put(clone[i], clone.length - i);
        }
        for (int num : nums) {
            int rank = hmap.get(num);
            if (rank <= 3) {
                result.add(rank == 1 ? "Gold Medal" : rank == 2 ? "Silver Medal" : "Bronze Medal");
            } else {
                result.add(String.valueOf(rank));
            }
        }
        return result.toArray(new String[0]);
    }
}
