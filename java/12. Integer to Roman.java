// O(1)
class Solution {
    public String intToRoman(int num) {
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC","L","XL","X","IX","V","IV","I"};
        int[] vals = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num >= vals[i]) {
                for (int j = 0; j < num / vals[i]; ++j) {
                    sb.append(symbols[i]);
                }
                num %= vals[i];
            }
            ++i;
        }
        return sb.toString();
    }
}
