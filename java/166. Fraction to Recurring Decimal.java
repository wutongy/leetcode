
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if ((numerator < 0) ^ (denominator < 0)) {
            sb.append("-");
        }
        long num = Math.abs((long)numerator);
        long den= Math.abs((long)denominator);
        sb.append(num / den);
        long remain = num % den;
        if (remain == 0) {
            return sb.toString();
        }
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        while (remain != 0) {
            if (map.containsKey(remain)) {
                sb.insert(map.get(remain), "(");
                sb.append(")");
                break;
            } else {
                map.put(remain, sb.length());
                sb.append((remain * 10 ) / den);
                remain = (remain * 10 ) % den;
            }
        }
        return sb.toString();
    }
}
