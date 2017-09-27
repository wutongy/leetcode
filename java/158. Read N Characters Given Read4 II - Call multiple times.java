/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */
// O(n)
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    private char[] prevBuf = new char[4];
    int prevSize = 0;
    int prevIndex = 0;
    public int read(char[] buf, int n) {
        int counter = 0;
        while (counter < n) {
            while (counter < n && prevIndex < prevSize) {
                buf[counter++] = prevBuf[prevIndex++];
            }
            if (counter == n) {
                break;
            }
            prevSize = read4(prevBuf);
            prevIndex = 0;
            if (prevSize == 0) {
                break;
            }
        }
        return counter;
    }
}
