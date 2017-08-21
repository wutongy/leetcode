// O(sqrt(n))
class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num == 1) {
            return false;
        }
        int result = 1;
        int i = 2;
        for (; i * i < num; i++) {
            if (num % i == 0) {
                result += i;
                result += (num / i);
            }
        }
        if (i * i == num) {
            result += i;
        }
        return result == num;
    }
}
