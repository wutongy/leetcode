// O(n)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0, cur = 0;
        int idx = 0;
        for (int i = 0; i < gas.length; ++i) {
            cur += gas[i] - cost[i];
            if (cur < 0) {
                cur = 0;
                idx = i + 1;
            }
            tank += gas[i] - cost[i];
        }
        return tank < 0 ? -1 : idx;
    }
}
