// O(n)
class Solution {
    public List<String> fullJustify(String[] words, int L) {
        List<String> lines = new ArrayList<>();
        int index = 0;
        while (index < words.length) {
            int count = words[index].length();
            int last = index + 1;
            while (last < words.length && (words[last].length() + count + 1 <= L)) {
                count += 1 + words[last].length();
                ++last;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(words[index]);
            int diff = last - index - 1;
            if (last == words.length || diff == 0) {
                for (int i = index + 1; i < last; ++i) {
                    sb.append(" ");
                    sb.append(words[i]);
                }
                for (int i = sb.length(); i < L; ++i) {
                    sb.append(" ");
                }
            } else {
                int spaces = (L - count) / diff;
                int r = (L - count) % diff;
                for (int i = index + 1; i < last; ++i) {
                    for (int k = spaces; k > 0; k--) {
                        sb.append(" ");
                    }
                    if (r > 0) {
                        sb.append(" ");
                        --r;
                    }
                    sb.append(" ");
                    sb.append(words[i]);
                }
            }
            lines.add(sb.toString());
            index = last;
        }
        return lines;
    }
}
