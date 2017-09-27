class Solution {
    private int[] old;
    Random ran;
    public Solution(int[] nums) {
        old = nums;
        ran = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return old;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] copy = old.clone();
        for(int i = copy.length - 1; i > 0; --i) {
            int j = ran.nextInt(i + 1);
            int temp = copy[i];
            copy[i] = copy[j];
            copy[j] = temp;
        }
        return copy;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
