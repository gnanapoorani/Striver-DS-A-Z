package TakeYouForward.BinaryTrees.Traversals;

import java.util.ArrayList;
import java.util.List;

public class PracticeSheet {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(preorderTraversal(root));
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderTraversalHelper(root, result);
        return result;
    }

    public static List<Integer> preorderTraversalHelper(TreeNode root, List<Integer> result) {

        if (root == null) {
            return result;
        }
        result.add(root.val);
        preorderTraversalHelper(root.left, result);
        preorderTraversalHelper(root.right, result);
        return result;
    }
}
