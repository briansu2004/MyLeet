public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public String toString(TreeNode t) {
        if (t == null) {
            return "NULL";
        }

        StringBuilder sb = new StringBuilder();

        sb.append("val: " + val + ";");
        if (t.left != null) {
            sb.append(" (left: " + toString(t.left) + ");");
        }
        if (t.right != null) {
            sb.append(" (right: " + toString(t.right) + ");");
        }

        return sb.toString();
    }
}