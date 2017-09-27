// O(n + k) time
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        for (int i = 0; i < updates.length; ++i) {
            result[updates[i][0]] += updates[i][2];
            if (updates[i][1] + 1 < result.length) {
                result[updates[i][1] + 1] -= updates[i][2];
            }
        }
        int accum = 0;
        for (int i = 0; i < result.length; ++i) {
            result[i] += accum;
            accum = result[i];
        }
        return result;
    }
}
