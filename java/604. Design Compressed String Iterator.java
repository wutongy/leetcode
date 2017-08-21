// O(n)
class StringIterator {
    private int start, end, count;
    private String s;
    public StringIterator(String compressedString) {
        s = compressedString;
        start = end = count = 0;
        if (s.length() > 1) {
            count = 0;
            ++end;
            nextChar();
        }
    }

    public char next() {
        if (!this.hasNext()) {
            return ' ';
        }
        --count;
        char c = s.charAt(start);
        if (count == 0) {
            start = end++;
            nextChar();
        }
        return c;
    }

    public boolean hasNext() {
        return count > 0;
    }

    private void nextChar() {
        while (end < s.length() && s.charAt(end) >= '0' && s.charAt(end) <= '9') {
            count = count * 10 + (s.charAt(end) - '0');
            ++end;
        }
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
