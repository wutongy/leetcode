// O(len(sentence) * cols)
class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int[] nextIdx = new int[sentence.length];
        int[] times = new int[sentence.length];
        for (int i = 0; i < sentence.length; ++i) {
            int curLen = 0;
            int cur = i;
            int time = 0;
            while (curLen + sentence[cur].length() <= cols) {
                curLen += sentence[cur++].length() + 1;
                if (cur == sentence.length) {
                    cur = 0;
                    ++time;
                }
            }
            nextIdx[i] = cur;
            times[i] = time;
        }
        int res = 0;
        int cur = 0;
        for (int i = 0; i < rows; ++i) {
            res += times[cur];
            cur = nextIdx[cur];
        }
        return res;
    }
}
