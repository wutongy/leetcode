public class Solution {
    public int distributeCandies(int[] candies) {
        int numOfCandies = candies.length;
        int halfNum = numOfCandies / 2;
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < numOfCandies && count <= halfNum; i++) {
            if (set.contains(candies[i]) == false) {
                count += 1;
                set.add(candies[i]);
            }
        }
        return Math.min(halfNum, count);
    }
}
