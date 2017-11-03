/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
// O(n)
public class Solution {
    private int res;
    public int depthSum(List<NestedInteger> nestedList) {
        res = 0;
        helper(nestedList);
        return res;
    }
    private int helper(List<NestedInteger> nestedList) {
        int sum = 0;
        for (NestedInteger ni : nestedList) {
            if (ni.isInteger()) {
                sum += ni.getInteger();
            } else {
                sum += helper(ni.getList());
            }
        }
        res += sum;
        return sum;
    }
}
