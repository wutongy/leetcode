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


class Solution {
    public String shortestPalindrome(String s) {
        int len = s.length();
        if (len < 2) {
            return s;
        }
        int longest = 1;
        for (int begin = 0; begin <= len / 2;) {
            int start = begin, end = begin;
            while (end + 1 < len && s.charAt(end + 1) == s.charAt(end)) {
                ++end;
            }
            begin = end + 1;
            while (end < len - 1 && start > 0 && s.charAt(end + 1) == s.charAt(start - 1)) {
                ++end;
                --start;
            }
            if (start == 0 && longest < end - start + 1) {
                longest = end - start + 1;
            }
        }
        return (new StringBuilder(s.substring(longest))).reverse().toString() + s;
    }
}
