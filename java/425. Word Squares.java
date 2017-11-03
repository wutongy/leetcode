// O(26^(n * n))
class Solution {

    class Node {
        Node[] child = new Node[26];
        String val = null;
    }

    private Node root = new Node();

    private void addToTrie(String s, Node root) {
        int i = 0;
        while (i < s.length()) {
            if (root.child[s.charAt(i) - 'a'] == null) {
                root.child[s.charAt(i) - 'a'] = new Node();
            }
            root = root.child[s.charAt(i) - 'a'];
            ++i;
        }
        root.val = s;
    }

    private void findAllSquares(int row, int col, Node[] rows, List<List<String>> res) {
        if (row == rows.length) {
            List<String> temp = new ArrayList<>(rows.length);
            for (int i = 0; i < rows.length; ++i) {
                temp.add(rows[i].val);
            }
            res.add(temp);
        } else if (col < rows.length) {
            Node currow = rows[row];
            Node curcol = rows[col];
            for (int i = 0; i < 26; ++i) {
                if (currow.child[i] != null && curcol.child[i] != null) {
                    rows[row] = currow.child[i];
                    rows[col] = curcol.child[i];
                    findAllSquares(row, col + 1, rows, res);
                }
            }
            rows[row] = currow;
            rows[col] = curcol;
        } else {
            findAllSquares(row + 1, row + 1, rows, res);
        }
    }

    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> res = new ArrayList<>();
        if (words == null || words.length == 0 || words[0].length() == 0) {
            return res;
        }
        for (String s : words) {
            addToTrie(s, root);
        }
        Node[] rows = new Node[words[0].length()];
        Arrays.fill(rows, root);
        findAllSquares(0, 0, rows, res);
        return res;
    }
}
