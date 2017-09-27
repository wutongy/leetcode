// O(n) time, O(n) space
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = wall.size();
        for (int i = 0; i < wall.size(); ++i) {
            Integer j = 0;
            for (int k = 0; k < wall.get(i).size() - 1; ++k) {
                j += wall.get(i).get(k);
                map.put(j, map.getOrDefault(j, 0) + 1);
                res = Math.min(res, wall.size() - map.get(j));
            }
        }
        return res;
    }
}
