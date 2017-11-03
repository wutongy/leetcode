class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int res = (C - A) * (D - B) + (G - E) * (H - F);
        int overlap = 0, left = Math.max(B, F), right = Math.min(D, H), upper = Math.min(C, G), down = Math.max(A, E);
        if (left < right && down < upper) {
            overlap = (right - left) * (upper - down);
        }
        return res - overlap;
    }
}
