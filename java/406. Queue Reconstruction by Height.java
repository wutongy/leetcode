// O(n^2)
class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) {
                    return a[1] - b[1];
                }
                return b[0] - a[0];
            }
        });
        for (int i = 1; i < people.length; ++i) {
            int j = i;
            while (people[j][1] != j) {
                int[] temp = people[j - 1];
                people[j - 1] = people[j];
                people[j] = temp;
                --j;
            }
        }
        return people;
    }
}
