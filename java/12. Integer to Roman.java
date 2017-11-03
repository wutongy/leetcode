// O(1)
class Solution {
    public String intToRoman(int num) {
        String[] symbols = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num != 0) {
            if (num >= nums[i]) {
                for (int j = 0; j < num / nums[i]; ++j) {
                    sb.append(symbols[i]);
                }
                num %= nums[i];
            }
            ++i;
        }
        return sb.toString();
    }
}
