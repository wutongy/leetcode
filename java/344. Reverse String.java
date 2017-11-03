// O(n)
class Solution {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        int j = s.length() - 1;
        while (j >= 0) {
            sb.append(s.charAt(j--));
        }
        return sb.toString();
    }
}
