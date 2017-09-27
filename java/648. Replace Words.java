// O(len(dict) + len(sentence)) trie-based
class Solution {
    private class TrieNode {
        boolean isWord;
        TrieNode[] childs;
        TrieNode() {
            this.isWord = false;
            childs = new TrieNode[26];
        }
    }

    private class Trie {
        TrieNode head;

        Trie() {
            head = new TrieNode();
        }

        void add(String word) {
            TrieNode cur = head;
            for (int i = 0; i < word.length(); ++i) {
                if (cur.childs[word.charAt(i) - 'a'] == null) {
                    TrieNode newNode = new TrieNode();
                    cur.childs[word.charAt(i) - 'a'] = newNode;
                }
                cur = cur.childs[word.charAt(i) - 'a'];
            }
            cur.isWord = true;
        }

        String match(String s) {
            String res = "";
            StringBuilder sb = new StringBuilder();
            TrieNode cur = head;
            for (int i = 0; i < s.length(); ++i) {
                if (cur.childs[s.charAt(i) - 'a'] != null) {
                    sb.append(s.charAt(i));
                    cur = cur.childs[s.charAt(i) - 'a'];
                    if (cur.isWord) {
                        res = sb.toString();
                        break;
                    }
                } else {
                    break;
                }
            }
            //System.out.println("res: " + res);
            return res;
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        StringBuilder sb = new StringBuilder();
        Trie trie = new Trie();
        for (String s : dict) {
            trie.add(s);
        }
        String[] ss = sentence.split(" ");
        for (int i = 0; i < ss.length; ++i) {
            String next = trie.match(ss[i]);
            if (next.length() == 0) {
                next = ss[i];
            }
            if (sb.length() == 0) {
                sb.append(next);
            } else {
                sb.append(" ");
                sb.append(next);
            }
        }
        return sb.toString();
    }
}
