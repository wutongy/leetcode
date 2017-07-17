// O(n)
public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (target == sum) {
                return new int[]{i + 1, j + 1};
            } else if (target > sum) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{};
    }
}
