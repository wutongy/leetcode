// O(n)
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pid.size(); ++i) {
            map.putIfAbsent(ppid.get(i), new ArrayList<>());
            map.get(ppid.get(i)).add(pid.get(i));
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(kill);
        while (!stack.isEmpty()) {
            Integer cur = stack.pop();
            res.add(cur);
            List<Integer> childs = map.get(cur);
            if (childs != null) {
                stack.addAll(childs);
            }
        }
        return res;
    }
}
