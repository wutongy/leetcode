// O(n)
public class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> hmap = new HashMap<>();
        int flag = 0;
        for (Character c : s.toCharArray()) {
            if (!hmap.containsKey(c)) {
                hmap.put(c, 1);
                flag += 1;
            } else {
                int accum = hmap.get(c);
                hmap.put(c, accum + 1);
                if (accum % 2 == 0) {
                    flag += 1;
                } else {
                    flag -= 1;
                }
            }
        }
        if (flag == 0 || flag == 1) {
            return true;
        }
        return false;
    }
}

// O(n)
public class Solution {
    public boolean canPermutePalindrome(String s) {
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            } else {
                set.remove(s.charAt(i));
            }
        }
        return set.size() == 0 || set.size() == 1;
    }
}
