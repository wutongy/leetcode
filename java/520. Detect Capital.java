// O(n)
public class Solution {
    public boolean detectCapitalUse(String word) {
        // return word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+");
        return word.equals(word.toUpperCase()) || word.substring(1).equals(word.substring(1).toLowerCase());
    }
}
