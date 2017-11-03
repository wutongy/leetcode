// DP
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        return helper(input, 0, input.length() - 1, map);
    }

    private List<Integer> helper(String s, int start, int end, HashMap<Integer, List<Integer>> map) {
        if (map.containsKey(start * s.length() + end)) {
            return map.get(start * s.length() + end);
        }
        List<Integer> res = new ArrayList<>();
        boolean notNum = false;
        int i = start;
        while (i <= end) {
            if (!Character.isDigit(s.charAt(i))) {
                notNum = true;
                List<Integer> left = helper(s, start, i - 1, map);
                List<Integer> right = helper(s, i + 1, end, map);
                for (Integer l : left) {
                    for (Integer r : right) {
                        res.add(calc(l, s.charAt(i), r));
                    }
                }
            }
            ++i;
        }
        if (!notNum) {
            res.add(Integer.valueOf(s.substring(start, end + 1)));
        }
        map.put(start * s.length() + end, res);
        return res;
    }

    private int calc(int left, Character c, int right) {
        if (c == '+') {
            return left + right;
        } else if (c == '-') {
            return left - right;
        }
        return left * right;
    }
}
