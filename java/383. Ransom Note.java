public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> hmap = new HashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char c = ransomNote.charAt(i);
            if (!hmap.containsKey(c)) {
                hmap.put(c, 1);
            } else {
                hmap.put(c, hmap.get(c) + 1);
            }
        }
        for (int i = 0; i < magazine.length() && !hmap.isEmpty(); i++) {
            char c = magazine.charAt(i);
            if (hmap.containsKey(c)) {
                int count = hmap.get(c);
                if (count == 1) {
                    hmap.remove(c);
                } else {
                    hmap.put(c, count - 1);
                }
            }

        }
        return hmap.isEmpty();
    }
}


public boolean canConstruct(String ransomNote, String magazine) {
    Map<Character, Integer> map = new HashMap<>();
    for (char c : magazine.toCharArray()) {
        int newCount = map.getOrDefault(c, 0) + 1;
        map.put(c, newCount);
    }
    for (char c : ransomNote.toCharArray()) {
        int newCount = map.getOrDefault(c, 0) - 1;
        if (newCount < 0) {
            return false;
        }
        map.put(c, newCount);
    }
    return true;
}
