// O(1)
class Solution {
    public int addDigits(int num) {
        return (num <= 9) ? num : ((num % 9 == 0) ? 9 : num % 9);
    }
}
