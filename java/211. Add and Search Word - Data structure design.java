// O(n) trie
class WordDictionary {
    private class TrieNode {
        TrieNode[] letters;
        boolean isValid;
        TrieNode() {
            letters = new TrieNode[26];
            isValid = false;
        }
    }
    private TrieNode head;
    /** Initialize your data structure here. */
    public WordDictionary() {
        head = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode cur = head;
        for (int i = 0; i < word.length(); ++i) {
            int n = word.charAt(i) - 'a';
            if (cur.letters[n] == null) {
                cur.letters[n] = new TrieNode();
            }
            cur = cur.letters[n];
        }
        cur.isValid = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return dfs(head, word, 0);
    }

    private boolean dfs(TrieNode cur, String word, int idx) {
        if (idx == word.length()) {
            return cur.isValid;
        }
        if (word.charAt(idx) != '.') {
            if (cur.letters[word.charAt(idx) - 'a'] == null) {
                return false;
            }
            return dfs(cur.letters[word.charAt(idx) - 'a'], word, idx + 1);
        } else {
            for (int i = 0; i < 26; ++i) {
                if (cur.letters[i] != null && dfs(cur.letters[i], word, idx + 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
