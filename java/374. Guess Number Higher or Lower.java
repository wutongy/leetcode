/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

// O(logn)
public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int i = 1, j = n;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            int cur = guess(mid);
            if (cur == 0) {
                return mid;
            } else if (cur == 1) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return i;
    }
}
