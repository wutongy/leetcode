public class OpenDoor {
  public static void main(String[] args) {
    char[][] board =
                {{'0', '2', '1', '1', '1'},
                {'0', '1', '0', '0', '1'},
                {'0', '0', '0', '0', '1'},
                {'0', '0', 'A', '0', '1'},
                {'1', '1', 'a', '1', '1'},
                {'1', 'b', '0', '0', 'B'},
                {'1', '1', '0', '0', '1'},
                {'0', '1', '0', '0', '3'}};
    List<Node> res = find(board);
    System.out.println(parsePath(res));
  }
  public static List<Node> find(char[][] board) {
    List<Node> res = new ArrayList<>();
    boolean[][] visited = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; ++i) {
      for (int j = 0; j < board[0].length; ++j) {
        if (board[i][j] == '2') {
          List<Node> path = new ArrayList<>();
          dfs(board, visited, path, res, i, j, new HashSet<Character>());
        }
      }
    }
    return res;
  }

  public static void dfs(char[][] board, boolean[][] visited, List<Node> path, List<Node> res, int x, int y, HashSet<Character> keys) {
    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || visited[x][y] || board[x][y] == '0') {
      return;
    }
    char c = board[x][y];
    if (c == '3') {
      res.clear();
      res.addAll(path);
      res.add(new Node(x, y));
      return;
    }
    if (res.size() != 0 && path.size() + 2 >= res.size()) {
      return;
    }
    if (c >= 'A' && c <= 'Z') {
      if (!keys.contains(c)) {
        return;
      }
    }

    if (c >= 'a' && c <= 'z') {
      if (!keys.contains(Character.toUpperCase(c)) {
        keys.add(Character.toUpperCase(c));
        visited = new boolean[board.length][board[0].length];
      }
    }

    visited[x][y] = true;
    path.add(new Node(x, y));
    dfs(board, visited, path, res, x, y + 1, keys);
    dfs(board, visited, path, res, x + 1, y, keys);
    dfs(board, visited, path, res, x, y - 1, keys);
    dfs(board, visited, path, res, x - 1, y, keys);
    visited[x][y] = false;
    path.remove(path.size() - 1);
  }

  public static String parsePath(List<Node> res) {
    StringBuilder sb = new StringBuilder();
    for (Node node : res) {
      if (sb.length() != 0) {
        sb.append("->");
      }
      sb.append("(").append(node.x).append(",").append(node.y).append(")");
    }
    return sb.toString();
  }
  static class Node {
    int x;
    int y;
    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
