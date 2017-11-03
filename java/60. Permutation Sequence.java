// O(n^2)
class Solution {
    public String getPermutation(int n, int k) {
        if (n == 0) {
            return "";
        }
        List<Integer> num = new LinkedList<>();
        for (int i = 1; i <= n; ++i) {
            num.add(i);
        }
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; ++i) {
            fact[i] = i * fact[i - 1];
        }
        --k;
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; --i) {
            int idx = k / fact[i];
            k %= fact[i];
            sb.append(num.get(idx));
            num.remove(idx);
        }
        return sb.toString();
    }
}
