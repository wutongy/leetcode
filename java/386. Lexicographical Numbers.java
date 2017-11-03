// O(n)
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; ++i) {
            dfs(i, n, res);
        }
        return res;
    }

    private void dfs(int cur, int n, List<Integer> res) {
        if (cur > n) {
            return;
        }
        res.add(cur);
        cur *= 10;
        for (int i = 0; i < 10; ++i) {
            if (cur + i > n) {
                return;
            }
            dfs(cur + i, n, res);
        }
    }
}

// O(n) time O(1) space
class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        int prev = 1;
        while (res.size() < n) {
            int cur = prev * 10;
            while (cur > n) {
                cur /= 10;
                ++cur;
                while (cur % 10 == 0) {
                    cur /= 10;
                }
            }
            res.add(cur);
            prev = cur;
        }
        return res;
    }
}
