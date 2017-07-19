public class Solution {
    public String convertToBase7(int num) {
        int flag = 0;
        if (num < 0) {
            flag = 1;
            num *= -1;
        }
        StringBuilder sb = new StringBuilder();
        while (num > 6) {
            sb.append(num % 7);
            num /= 7;
        }
        return (flag == 1 ? "-" : "") +  sb.append(num).reverse().toString();

    }
}
