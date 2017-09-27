// insert, search, startsWith O(n)
class Trie {
    private class TrieNode {
        TrieNode[] cons;
        boolean isValid;
        TrieNode() {
            cons = new TrieNode[26];
            isValid = false;
        }
    }
    private TrieNode head;
    /** Initialize your data structure here. */
    public Trie() {
        head = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = head;
        for (int i = 0; i < word.length(); ++i) {
            if (cur.cons[word.charAt(i) - 'a'] == null) {
                cur.cons[word.charAt(i) - 'a'] = new TrieNode();
            }
            cur = cur.cons[word.charAt(i) - 'a'];
        }
        cur.isValid = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = head;
        int i = 0;
        while (i < word.length()) {
            if (cur.cons[word.charAt(i) - 'a'] == null) {
                return false;
            }
            cur = cur.cons[word.charAt(i) - 'a'];
            ++i;
        }
        return cur.isValid;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = head;
        int i = 0;
        while (i < prefix.length()) {
            if (cur.cons[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            cur = cur.cons[prefix.charAt(i) - 'a'];
            ++i;
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
