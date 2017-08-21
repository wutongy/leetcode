// O(n)
public class Solution {
    public String reverseVowels(String s) {
        int left = 0, right = s.length() - 1;
        StringBuilder sbLeft = new StringBuilder();
        StringBuilder sbRight = new StringBuilder();
        while (left < right) {
            while (left < right && (!isVowel(s.charAt(left)))) {
                sbLeft.append(s.charAt(left));
                ++left;
            }
            while (left < right && (!isVowel(s.charAt(right)))) {
                sbRight.append(s.charAt(right));
                --right;
            }
            if (left < right) {
                sbLeft.append(s.charAt(right));
                sbRight.append(s.charAt(left));
                ++left;
                --right;
            }
        }
        if (left == right) {
            sbLeft.append(s.charAt(left));
        }
        return sbLeft.append(sbRight.reverse()).toString();
    }

    private boolean isVowel(Character c) {
        if (c == 'a' || c == 'e'|| c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
            return true;
        }
        return false;
    }
}
