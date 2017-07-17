// O(n)
public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        char[] carr = s.toCharArray();
        for (int i = 0; i < s.length() - 1; ++i) {
            if (carr[i] == '+' && carr[i] == carr[i + 1]) {
                carr[i] = carr[i + 1] = '-';
                result.add(String.valueOf(carr));
                carr[i] = carr[i + 1] = '+';
            }
        }
        return result;
    }
}

// O(n)
public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> list = new ArrayList<String>();
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                list.add(s.substring(0, i - 1) + "--" + s.substring(i + 1, s.length()));
            }
        }
        return list;
    }
}
