// O(n)
class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            //System.out.println(i + ", " + j);
            if (abbr.charAt(j) >= 'a' && abbr.charAt(j) <= 'z') {
                if (abbr.charAt(j) != word.charAt(i)) {
                    return false;
                }
                ++i;
                ++j;
            } else if (abbr.charAt(j) == '0') {
                return false;
            } else {
                int k = j;
                while (k < abbr.length() && abbr.charAt(k) >= '0' && abbr.charAt(k) <= '9') {
                    ++k;
                }
                int skipped = parse(abbr.substring(j, k));
                i += skipped;
                j = k;
            }
        }
        return i == word.length() && j == abbr.length();
    }
    private int parse(String s) {
        int num = 0;
        for (int i = 0; i < s.length(); ++i) {
            num =  num * 10 + (s.charAt(i) - '0');
        }
        return num;
    }
}
