// O(1)
public class Solution {
    public String toHex(int num) {
        // if (num == 0) {
        //     return "0";
        // }
        StringBuilder sb = new StringBuilder();
        int mask = 15;
        int andNum = mask & num;
        do {
            if (andNum < 10) {
                sb.append(andNum);
            } else {
                Character c = 'a';
                switch (andNum) {
                    case 10: c = 'a'; break;
                    case 11: c = 'b'; break;
                    case 12: c = 'c'; break;
                    case 13: c = 'd'; break;
                    case 14: c = 'e'; break;
                    case 15: c = 'f'; break;
                }
                sb.append(c);
            }
            num >>>= 4;
            andNum = mask & num;
        } while (num > 0);
        return sb.reverse().toString();
    }
}
