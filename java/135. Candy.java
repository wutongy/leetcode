// O(n)
class Solution {
    public int candy(int[] ratings) {
        int[] res = new int[ratings.length];
        int i = 0, j = 0;
        while (j <= ratings.length) {
            if (j == 0) {
                res[j] = 1;
            } else if (j == ratings.length || ratings[j] >= ratings[j - 1]) {
                if (res[j - 1] <= 0) {
                    res[j - 1] = 1;
                    int k = j - 2;
                    while (k > i) {
                        res[k] = res[k + 1] + 1;
                        --k;
                    }
                    res[i] = Math.max(res[i], res[i + 1] + 1);
                }
                if (j < ratings.length) {
                    res[j] = (ratings[j] == ratings[j - 1] ? 0 : res[j - 1]) + 1;
                }
                i = j;
            } else if (ratings[j] < ratings[j - 1]) {
                res[j] = Math.min(1, res[j - 1] - 1);
            }
            ++j;
        }
        int sum = 0;
        for (int n : res) {
            sum += n;
        }
        return sum;
    }
}


class Solution {
    public int candy(int[] ratings) {
        int candy = 0, dStart = -1, i = 0, cur = 1;
        boolean descend = false;
        while (i <= ratings.length) {
            if (i == 0) {
                candy += 1;
            } else if (i < ratings.length && ratings[i] < ratings[i - 1]) {
                if (!descend) {
                    candy -= cur;
                    dStart = i - 1;
                    descend = true;
                }
            } else if (i == ratings.length || ratings[i] >= ratings[i - 1]) {
                if (descend) {
                    descend = false;
                    candy += (1 + (i - dStart)) * (i - dStart) / 2;
                    if (cur > i - dStart) {
                        candy += (cur - (i - dStart));
                    }
                    cur = 1;
                }
                if (i < ratings.length) {
                    if (ratings[i] == ratings[i - 1]) {
                        candy += 1;
                        cur = 1;
                    } else if (ratings[i] > ratings[i - 1]) {
                        ++cur;
                        candy += cur;
                    }
                }
            }
            ++i;
        }
        return candy;
    }
}
