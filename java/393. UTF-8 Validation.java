// O(n)
class Solution {
    public boolean validUtf8(int[] data) {
        int i = 0;
        while (i < data.length) {
            int mask = 1 << 7;
            if ((mask & data[i]) != 0) {
                int count = 0;
                while (mask != 0 && (mask & data[i]) != 0) {
                    ++count;
                    mask >>>= 1;
                }
                if (count < 2 || count > 4 || data.length - i < count) {
                    return false;
                }
                ++i;
                while (count > 1) {
                    if ((data[i] >>> 6) != 2) {
                        return false;
                    }
                    ++i;
                    --count;
                }
            } else {
                ++i;
            }
        }
        return true;
    }
}
