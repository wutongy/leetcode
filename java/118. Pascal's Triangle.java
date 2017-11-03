// O(n^2)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; ++i) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            if (i != 1) {
                List<Integer> last = res.get(res.size() - 1);
                for (int j = 1; j < last.size(); ++j) {
                    cur.add(last.get(j) + last.get(j - 1));
                }
                cur.add(1);
            }
            res.add(cur);
        }
        return res;
    }
}

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows < 1) {
            return res;
        }
        res.add(new ArrayList<>());
        res.get(res.size() - 1).add(1);
        for (int i = 2; i <= numRows; ++i) {
            List<Integer> cur = new ArrayList<>();
            cur.addAll(res.get(res.size() - 1));
            cur.add(1);
            for (int j = cur.size() - 2; j >= 1; --j) {
                cur.set(j, cur.get(j) + cur.get(j - 1));
            }
            res.add(cur);
        }
        return res;
    }
}
