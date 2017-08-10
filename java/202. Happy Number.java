// O(n)
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> hset = new HashSet<>();
        int copy = n;
        hset.add(copy);
        while (copy != 1) {
            int accum = 0;
            while (copy > 0) {
                int digit = copy % 10;
                accum += digit * digit;
                copy /= 10;
            }
            if (hset.contains(accum)) {
                return false;
            } else {
                hset.add(accum);
            }
            copy = accum;
        }
        return true;
    }
}
