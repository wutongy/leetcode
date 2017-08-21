// O(n^2)
public class Solution {
    public boolean validWordSquare(List<String> words) {
        int size = words.size();
        for (int j = 0, i = 1; j < size; ++j, ++i) {
            String st = words.get(j);
            int k;
            for (k = i; k < st.length(); ++k) {
                if (k < size && j < words.get(k).length()) {
                    if (st.charAt(k) != words.get(k).charAt(j)) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
            if (k < size && j < words.get(k).length()) {
                return false;
            }
        }
        return true;
    }
}
