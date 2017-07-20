// O(n)
public class Solution {
    public boolean checkRecord(String s) {
        int aCount = 0;
        int lContinue = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                aCount += 1;
                lContinue = 0;
            } else if (s.charAt(i) == 'L') {
                lContinue += 1;
            } else {
                lContinue = 0;
            }
            if (aCount > 1 || lContinue == 3) {
                return false;
            }
        }
        return true;
    }
}
