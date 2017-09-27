/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
// O(n)
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int i = 0, retNum;
        char[] readBuf = new char[4];
        while (i != n) {
            retNum = read4(readBuf);
            int count = Math.min(retNum, n - i);
            for (int j = 0; j < count; ++j) {
                buf[i++] = readBuf[j];
            }
            if (retNum < 4) {
                break;
            }
        }
        return i;
    }
}
