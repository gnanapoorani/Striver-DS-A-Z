package TakeYouForward.BinarySearchTrees.Concepts;


import java.util.*;

public class SearchInBinarySearchTree {
    public static class TreeNode {
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
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(searchBST(root, 2));
        System.out.println("Min value" + minValue(root));
        System.out.println("maxValuem" + maxValue(root));
        System.out.println("Floor value " + Floor(root, 6));
        System.out.println("Ceil Value " + Ceil(root, 6));
        System.out.println("insertIntoBST" + insertIntoBST(root, 6));
        System.out.println("deleteNode" + deleteNode(root, 6));
        System.out.println("kthSmallest" + kthSmallest(root, 3));
        System.out.println("isValidBST" + isValidBST(root));
//        System.out.println("bstFromPreorder" + bstFromPreorder(new int[]{8, 5, 1, 7, 10, 12}));
        System.out.println("predecessorSuccessor" + predecessorSuccessor(root, 7));
        List<TreeNode> trees = new ArrayList<>();
        trees.add(root);
        TreeNode root1 = new TreeNode(8);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(10);
        trees.add(root1);
        System.out.println("canMerge" + canMerge(trees));
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(11);
        root2.right = new TreeNode(13);
        root2.left.left = new TreeNode(9);
        root2.left.right = new TreeNode(15);
        System.out.println("Largest BST size" + largestBst(root2));

    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }

    public static int minValue(TreeNode root) {

        if (root.left != null) {
            return minValue(root.left);
        } else {
            return root.val;
        }
    }

    public static int maxValue(TreeNode root) {
        if (root.right != null) {
            return maxValue(root.right);
        } else {
            return root.val;
        }
    }

    public static int Floor(TreeNode root, int input) {
        int answer = -1;
        if (root == null) {
            return answer;
        }
        if (root.val == input) {
            return root.val;
        }
        if (input < root.val) {
            Floor(root.left, input);
        } else {
            answer = root.val;
            Floor(root.right, input);
        }
        return answer;
    }

    public static int Ceil(TreeNode root, int input) {
        int answer = -1;
        if (root == null) {
            return answer;
        }
        if (root.val == input) {
            return root.val;
        }
        if (root.val > input) {
            answer = root.val;
            Ceil(root.left, input);
        } else { //root.val <input
            Ceil(root.right, input);
        }
        return answer;
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(5);
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode minNode = findMin(root.left);
                minNode.right = root.right;
                return root.left;
            }
        }
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    public static TreeNode findMin(TreeNode root) {

        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    private static int count = 0;
    private static int number = 0;

    public static int kthSmallest(TreeNode root, int k) {
        count = k;
        kthSmallestHelper(root);
        return number;
    }

    public static void kthSmallestHelper(TreeNode root) {
        if (root.left != null) {
            kthSmallestHelper(root.left);
        }
        count--;
        if (count == 0) {
            number = root.val;
            return;
        }
        if (root.right != null) {
            kthSmallestHelper(root.right);
        }
    }

    public static boolean isValidBST(TreeNode root) {
        int minValue = Integer.MIN_VALUE;
        int maxValue = Integer.MAX_VALUE;
        return isValidBSTHelper(root, minValue, maxValue);
    }

    public static boolean isValidBSTHelper(TreeNode root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }
        if (root.val > minValue && root.val < maxValue) {
            return isValidBSTHelper(root.left, minValue, root.val) && isValidBSTHelper(root.right, root.val, maxValue);
        } else {
            return false;
        }
    }

    public static TreeNode bstFromPreorder(int[] preorder) {//8,5,1,7,10,12
        TreeNode node = bstFromPreorderHelper(preorder, 1, Integer.MAX_VALUE);
        return node;
    }

    public static TreeNode bstFromPreorderHelper(int[] preorder, int i, int bound) {
        if (preorder[i] > bound || i > preorder.length - 1) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[i]);
        node.left = bstFromPreorderHelper(preorder, i + 1, node.val);
        node.right = bstFromPreorderHelper(preorder, i + 1, bound);
        return node;
    }


    public static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return null;
        }

        if (root.val == key) {

            if (root.left != null) {
                TreeNode temp = root.left;
                while (temp.right != null) {
                    temp = temp.right;
                }
                result.add(temp.val);
            }
            if (root.right != null) {
                // go to the left most element in the right subtree, it will
                // the successor.
                TreeNode t = root.right;
                while (t.left != null) {
                    t = t.left;
                }
                result.add(t.val);
            }
            return result;
        }
        if (root.val < key) {
            predecessorSuccessor(root.left, key);
        } else if (root.val > key) {
            predecessorSuccessor(root.right, key);
        }

        return result;
    }

    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> map = new HashSet<>();
        return findTargetHelper(map, root, k);
    }

    public boolean findTargetHelper(HashSet<Integer> map, TreeNode root, int k) {

        if (root == null) {
            return true;
        }

        if (map.contains(k - root.val)) {
            return true;
        }
        map.add(root.val);
        return findTargetHelper(map, root.left, k) || findTargetHelper(map, root.right, k);
    }

    public static TreeNode canMerge(List<TreeNode> trees) {
        //Collect the leaves
        Set<Integer> leaves = new HashSet();
        Map<Integer, TreeNode> map = new HashMap<>();
        for (TreeNode tree : trees) {
            map.put(tree.val, tree);
            if (tree.left != null) {
                leaves.add(tree.left.val);
            }
            if (tree.right != null) {
                leaves.add(tree.right.val);
            }
        }

        //Decide the root of the resulting tree
        TreeNode result = null;
        for (TreeNode tree : trees) {
            if (!leaves.contains(tree.val)) {
                result = tree;
                break;
            }
        }
        if (result == null) {
            return null;
        }

        return traverse(result, map, Integer.MIN_VALUE, Integer.MAX_VALUE) && map.size() == 1 ? result : null;
    }

    private static boolean traverse(TreeNode root, Map<Integer, TreeNode> map, int min, int max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;

        if (root.left == null && root.right == null) {
            if (map.containsKey(root.val) && root != map.get(root.val)) {
                TreeNode next = map.get(root.val);
                root.left = next.left;
                root.right = next.right;
                map.remove(root.val);
            }
        }
        return traverse(root.left, map, min, root.val) && traverse(root.right, map, root.val, max);
    }

    class BSTIterator {

        Stack<TreeNode> stack;
        private TreeNode visit;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            visit = root;
        }

        public int next() {
            int answer = 0;
            while (visit != null) {
                stack.add(visit);
                visit = visit.left;
            }
            visit = stack.pop();
            answer = visit.val;
            visit = visit.right;
            return answer;
        }

        public boolean hasNext() {
            if (visit != null && !stack.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
    }

    static TreeNode prev = null, first = null, second = null;

    public static void recoverTree(TreeNode root) {
        recoverTreeHelper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;

    }

    public static void recoverTreeHelper(TreeNode root) {

        if (root == null) {
            return;
        }
        recoverTreeHelper(root.left);
        if (prev != null && root.val < prev.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        prev = root;
        recoverTreeHelper(root.right);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return root;
        }
    }

    static int largestBst(TreeNode root) {
        int minValue = Integer.MIN_VALUE;
        int maxValue = Integer.MAX_VALUE;
        return largestBstSumHelper(root, minValue, maxValue, 0);

    }

    static int max = 0;

    public static void largestBstHelper(TreeNode root, int minValue, int maxValue, int count) {
        if (root == null) {
            return;
        }
        max = Math.max(max, count + 1);
        if (root.val > minValue && root.val < maxValue) {
            largestBstHelper(root.left, minValue, root.val, count + 1);
            largestBstHelper(root.right, root.val, maxValue, count + 1);
        } else {
            count = 1;
            int maxValueNew = Integer.MAX_VALUE;
            largestBstHelper(root.left, minValue, root.val, count + 1);
            largestBstHelper(root.right, root.val, maxValueNew, count + 1);
        }
    }

    public static int largestBstSumHelper(TreeNode root, int minValue, int maxValue, int sum) {
        int leftSum;
        int finalSum;
        if (root == null) {
            return sum;
        }
        if (root.val > minValue && root.val < maxValue) {
            leftSum = largestBstSumHelper(root.left, minValue, root.val, sum + root.val);
            finalSum = largestBstSumHelper(root.right, root.val, maxValue, leftSum);
        }else{
            int maxValueNew = Integer.MAX_VALUE;
            leftSum = largestBstSumHelper(root.left, minValue, root.val,  root.val);
            finalSum = largestBstSumHelper(root.right, root.val, maxValueNew, leftSum);
        }
        return finalSum;
    }

}