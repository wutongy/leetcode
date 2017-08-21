// O(n)
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] == 0) {
                boolean flag = true;
                if (i - 1 >= 0 && flowerbed[i - 1] == 1) {
                    flag = false;
                }
                if (i + 1 < flowerbed.length && flowerbed[i + 1] == 1) {
                    flag = false;
                }
                if (flag == true) {
                    --n;
                    flowerbed[i] = 1;
                }
            }
        }
        return n == 0;
    }
}
