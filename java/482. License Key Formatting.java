// O(n)
class Solution {
    public String licenseKeyFormatting(String S, int K) {
        S = S.replace("-", "");
        StringBuilder sb = new StringBuilder();
        int j = S.length() - 1, count = K;
        while (j >= 0) {
            if (count == K && sb.length() != 0) {
                sb.append("-");
            }
            --count;
            if (Character.isDigit(S.charAt(j))) {
                sb.append(S.charAt(j));
            } else if (Character.isLowerCase(S.charAt(j))) {
                sb.append(Character.toUpperCase(S.charAt(j)));
            } else {
                sb.append(S.charAt(j));
            }
            --j;
            if (count == 0) {
                count = K;
            }
        }
        return sb.reverse().toString();
    }
}
