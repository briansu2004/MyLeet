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

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("val: " + val + "; left: ");
        if (left != null) {
            sb.append(left.toString());
        }
        sb.append("; right: ");
        if (right != null) {
            sb.append(right.toString());
        }

        return sb.toString();
    }
}