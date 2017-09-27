// O(n)
class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int result = 0;
        for (int i = 0; i < timeSeries.length; ++i) {
            if (i == 0 || (timeSeries[i] - timeSeries[i - 1] >= duration)) {
                result += duration;
            } else {
                result += timeSeries[i] - timeSeries[i - 1];
            }
        }
        return result;
    }
}
