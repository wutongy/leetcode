// Forward declaration of the knows API.
bool knows(int a, int b);

class Solution {
public:
    int findCelebrity(int n) {
        int x = 0;
        for (int i = 1; i < n; i++) {
            if (knows(x, i)) {
                x = i;
            }
        }
        for (int i = 0; i < x; i++) {
            if (knows(x, i)) {
                return -1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (!knows(i, x)) {
                return -1;
            }
        }
        return x;
    }
};