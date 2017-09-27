class Solution {
    private boolean match(String s, int i, int j) {
        while (i >= 0 && s.charAt(i) == s.charAt(j)) {
            --i;
            ++j;
        }
        return i < 0;
    }
    public String shortestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        } else if ((s.length() % 2 == 0 && match(s, s.length() / 2 - 1, s.length() / 2)) || (s.length() % 2 == 1 && match(s, s.length() / 2 - 1, s.length() / 2 + 1))) {
            return s;
        }
        for (int i = s.length() / 2; i > 0; --i) {
            if (i + 1 < s.length() && s.charAt(i - 1) == s.charAt(i + 1)) {
                if (match(s, i - 2, i + 2)) {
                    StringBuilder sb = new StringBuilder(s.substring(i + 1));
                    sb = (new StringBuilder()).append(sb.reverse()).append(s.substring(i));
                    return sb.toString();
                }
            }
            if (s.charAt(i - 1) == s.charAt(i)) {
                if (match(s, i - 2, i + 1)) {
                    StringBuilder sb = new StringBuilder((new StringBuilder(s.substring(i))).reverse());
                    sb.append(s.substring(i));
                    return sb.toString();
                }
            }
        }
        StringBuilder sb = new StringBuilder(s.substring(1));
        sb = (new StringBuilder()).append(sb.reverse()).append(s);
        return sb.toString();
    }
}


// O(n^2)
class Solution {
    public String shortestPalindrome(String s) {
        if (s.length() < 2) {
            return s;
        }
        int i = 0, end = s.length() - 1, j = end; char chs[] = s.toCharArray();
        while(i < j) {
             if (chs[i] == chs[j]) {
                 i++; j--;
             } else {
                 i = 0; end--; j = end;
             }
        }
        return new StringBuilder(s.substring(end+1)).reverse().toString() + s;
    }
}
