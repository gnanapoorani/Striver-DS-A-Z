
class TreeNode {
    TreeNode left;
    TreeNode right;
    int data;

    TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }

    TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = null;
    }
}

class Solution1 {

    public static void main(String[] args) {
        TreeNode root= new TreeNode(1);
        root.left=new TreeNode(3);
        root.right=new TreeNode(56);
        root.left.left=new TreeNode(34);
        root.left.right=new TreeNode(23);
        root.right.left=new TreeNode(34);
        root.right.right=new TreeNode(232);
        System.out.println("Height of the tree "+height(root));
    }

    static int max = 0;

    static int height(TreeNode root) {

        if (root == null) {
            return -1;
        }
        int left = 0;
        int right = 0;
        if (root.left != null) {
            left =height(root.left);
        }
        if (root.right != null) {
            right = height(root.right);
        }
        max = 1+ Math.max(left, right);
        return max;
    }
}
