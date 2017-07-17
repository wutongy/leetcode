// O(n)
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int indexWordOne = -1;
        int indexWordTwo = -1;
        int result = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                indexWordOne = i;
            } else if (words[i].equals(word2)) {
                indexWordTwo = i;
            }
            if (indexWordOne != -1 && indexWordTwo != -1) {
                result = Math.min(result, Math.abs(indexWordOne - indexWordTwo));
            }
        }
        return result;
    }
}
