/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    private static final String DELIMITER = "/";
    private static final String NULL_NODE = "NULL";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return NULL_NODE + DELIMITER;
        }
        return Integer.toString(root.val) + DELIMITER + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(DELIMITER)));
        return buildTree(nodes);
    }

    private TreeNode buildTree(LinkedList<String> nodes) {
        String node = nodes.remove();
        if (node.equals(NULL_NODE)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(node));
        root.left = buildTree(nodes);
        root.right = buildTree(nodes);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.StringTokenizer;
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("# ");
        } else {
            sb.append(root.val + " ");
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.length() == 0) {
            return null;
        }
        StringTokenizer st = new StringTokenizer(data, " ");
        return deserialize(st);
    }

    private TreeNode deserialize(StringTokenizer st) {
        if (!st.hasMoreTokens()) {
            return null;
        }
        String s = st.nextToken();
        if (s.equals("#")) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = deserialize(st);
        root.right = deserialize(st);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] ss = data.split(",");
        return helper(ss, new int[]{0});
    }

    private TreeNode helper(String[] ss, int[] idx) {
        if (idx[0] >= ss.length) {
            return null;
        }
        int cur = idx[0];
        ++idx[0];
        if (ss[cur].equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(ss[cur]));
        node.left = helper(ss, idx);
        node.right = helper(ss, idx);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
