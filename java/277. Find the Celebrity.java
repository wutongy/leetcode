/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

// O(n)
public class Solution extends Relation {
    public int findCelebrity(int n) {
        int target = 0;
        for (int i = 1; i < n; ++i) {
            if (knows(target, i)) {
                target = i;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (i != target && (!knows(i, target) || knows(target, i))) {
                return -1;
            }
        }
        return target;
    }
}
