// O(1)
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) {
            return 1;
        }
        if (n > 10) {
            n = 10;
        }
        int res = 10, uniqueDigits = 9, availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits *= availableNumber;
            res += uniqueDigits;
            --availableNumber;
        }
        return res;
    }
}
