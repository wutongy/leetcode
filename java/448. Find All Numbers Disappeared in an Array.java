//  O(n)
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            while ((temp != i + 1) && (nums[temp - 1] != nums[i])) {
                // int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
                temp = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
