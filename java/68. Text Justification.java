// O(n)
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        int i = 0, j = 0, width = 0;
        while (j <= words.length) {
            if (j == i) {
                width = words[j].length();
                ++j;
            } else if (j < words.length && width + words[j].length() + (j - i) <= maxWidth) {
                width += words[j].length();
                ++j;
            } else {
                int space = (j == words.length || j - i - 1 == 0) ? 1 : (maxWidth - width) / (j - i - 1);
                int remain = (j == words.length) ? 0 : (maxWidth - width) - (j - i - 1) * space;
                // System.out.println(j + " " + space + " " + remain);
                StringBuilder sb = new StringBuilder();
                while (i < j) {
                    if (sb.length() != 0) {
                        int numSpace = space + ((remain-- > 0) ? 1 : 0);
                        for (int k = 0; k < numSpace; ++k) {
                            sb.append(" ");
                        }
                    }
                    sb.append(words[i]);
                    ++i;
                }
                int len = maxWidth - sb.length();
                for (int k = 0; k < len; ++k) {
                    sb.append(" ");
                }
                res.add(sb.toString());
                if (j == words.length) {
                    break;
                }
            }
        }

        return res;
    }
}
