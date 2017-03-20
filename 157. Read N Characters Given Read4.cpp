// Forward declaration of the read4 API.
int read4(char *buf);

class Solution {
public:
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    int read(char *buf, int n) {
        char local[4];
        int read = 0, cur = 0, i = 0;
        while ((read = read4((char*)&local))) {
            read = cur + read <= n ? cur + read : n;
            for (i = 0; cur < read; ++cur, ++i) {
                buf[cur] = local[i];
            }
        }
        return cur;
    }
};