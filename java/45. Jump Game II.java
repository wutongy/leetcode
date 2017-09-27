// O(n)
class Solution {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int jumps = 0;
        int minIdx = -1, maxIdx = 0, curIdx = 0, nextIdx = 0;
        while (curIdx > minIdx) {
            if (curIdx + nums[curIdx] >= nums.length - 1) {
                return jumps + 1;
            }
            nextIdx = Math.max(nextIdx, curIdx + nums[curIdx]);
            --curIdx;
            if (curIdx == minIdx) {
                minIdx = maxIdx;
                maxIdx = nextIdx;
                curIdx = nextIdx;
                ++jumps;
            }
        }
        return jumps;
    }
}
