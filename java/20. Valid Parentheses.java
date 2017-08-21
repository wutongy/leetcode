// O(n)
class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> hmap = new HashMap<>();
        hmap.put(')', '(');
        hmap.put('}', '{');
        hmap.put(']', '[');
        ArrayList<Character> stack = new ArrayList<>();
        for (int i = 0; i < s.length(); ++i) {
            if (hmap.containsKey(s.charAt(i))) {
                if (stack.size() > 0 && hmap.get(s.charAt(i)) == stack.get(stack.size() - 1)) {
                    stack.remove(stack.size() - 1);
                } else {
                    return false;
                }
            } else {
                stack.add(s.charAt(i));
            }
        }
        return stack.size() == 0;
    }
}
