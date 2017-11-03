class Solution {
    public boolean isPowerOfThree(int n) {
        int maxOfThree = (int) Math.pow(3, (int)(Math.log(Integer.MAX_VALUE) / Math.log(3)));
        return n > 0 && (maxOfThree % n == 0);
    }
}
