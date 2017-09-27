class Solution {
    private Map<String, List<Integer>> map = new HashMap<>();
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < input.length(); ++i) {
            if (input.charAt(i) == '-' || input.charAt(i) == '+' || input.charAt(i) == '*') {
                String part1 = input.substring(0, i);
                String part2 = input.substring(i + 1);
                List<Integer> part1Res, part2Res;
                if (map.containsKey(part1)) {
                    part1Res = map.get(part1);
                } else {
                    part1Res = diffWaysToCompute(part1);
                }
                if (map.containsKey(part2)) {
                    part2Res = map.get(part2);
                } else {
                    part2Res = diffWaysToCompute(part2);
                }
                for (Integer p1 : part1Res) {
                    for (Integer p2 : part2Res) {
                        Integer c = 0;
                        if (input.charAt(i) == '+') {
                            c = p1 + p2;
                        } else if (input.charAt(i) == '-') {
                            c = p1 - p2;
                        } else {
                            c = p1 * p2;
                        }
                        res.add(c);
                    }
                }
            }
        }
        if (res.size() == 0) {
            res.add(Integer.valueOf(input));
        }
        map.put(input, res);
        return res;
    }
}
