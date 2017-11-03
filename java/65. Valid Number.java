// O(n)
class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean pointSeen = false;
        boolean eSeen = false;
        boolean numberSeen = false;
        boolean numberAfterE = true;
        for (int i = 0; i < s.length(); ++i) {
            if ('0' <= s.charAt(i) && s.charAt(i) <= '9') {
                numberSeen = true;
                numberAfterE = true;
            } else if (s.charAt(i) == '.') {
                if (eSeen || pointSeen) {
                    return false;
                }
                pointSeen= true;
            } else if (s.charAt(i) == 'e') {
                if (eSeen || !numberSeen) {
                    return false;
                }
                numberAfterE = false;
                eSeen = true;
            } else if (s.charAt(i) == '-' || s.charAt(i) == '+') {
                if (i != 0 && s.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return numberSeen && numberAfterE;
    }
}


class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        int i = 0;
        boolean hasE = false, hasDigit = false, hasDot = false, hasSign = false;;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                hasDigit = true;
            } else if (s.charAt(i) == '.') {
                if (hasE || hasDot) {
                    return false;
                }
                hasDot = true;
            } else if (s.charAt(i) == 'e') {
                if (!hasDigit || hasE) {
                    return false;
                }
                hasE = true;
                hasDigit = false;
                hasSign = false;
                hasDot = false;
            } else if (s.charAt(i) == '+' || s.charAt(i) == '-') {
                if (hasDot || hasDigit || hasSign) {
                    return false;
                }
                hasSign = true;
            } else {
                return false;
            }
            ++i;
        }
        return hasDigit;
    }
}
