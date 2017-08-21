// O(n^2)
public class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> newList = new ArrayList<>();
            newList.add(1);
            if (result.size() != 0) {
                ArrayList<Integer> lastList = (ArrayList<Integer>)result.get(result.size() - 1);
                for (int j = 1; j < lastList.size(); j++) {
                    newList.add(lastList.get(j) + lastList.get(j - 1));
                }
                newList.add(1);
            }
            result.add(newList);
        }
        return result;
    }
}
