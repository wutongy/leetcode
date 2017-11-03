// O(n)
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < nums.length) {
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[j - 1] + 1) {
                ++j;
            }
            sb.append(nums[i]);
            if (j != i + 1) {
                sb.append("->");
                sb.append(nums[j - 1]);
            }
            res.add(sb.toString());
            i = j;
            sb.setLength(0);
        }
        return res;
    }
}
