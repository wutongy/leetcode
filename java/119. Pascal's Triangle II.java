class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i) {
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            if (i != 0) {
                for (int j = 1; j < res.size(); ++j) {
                    cur.add(res.get(j - 1) + res.get(j));
                }
                cur.add(1);
            }
            res = cur;
        }
        return res;
    }
}
