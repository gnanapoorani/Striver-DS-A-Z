package TakeYouForward.BinaryTrees.Traversals;



import java.util.*;


public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode next;
    public List<TreeNode> children;

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

    TreeNode(int val, TreeNode left, TreeNode right, TreeNode next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    public TreeNode(int _val, List<TreeNode> _children) {
        val = _val;
        children = _children;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println("serialize : " + serialize(root));
        System.out.println("deserialize : " + deserialize("3,9,,,20,15,,,7,,"));
        System.out.println("preorderTraversal : " + preorderTraversal(root));
        System.out.println("IterativePreorderTraversal : " + IterativePreorderTraversal(root));
        System.out.println("inorderTraversal : " + inorderTraversal(root));
        System.out.println("postorderTraversal : " + postorderTraversal(root));
        System.out.println("IterativeLevelOrder : " + IterativeLevelOrder(root));
        System.out.println("IterativeLevelOrderBottomUp : " + IterativeLevelOrderBottomUp(root));
        System.out.println("levelOrder : " + levelOrder(root));
        System.out.println("levelOrderBottom : " + levelOrderBottom(root));
        System.out.println("zigzagLevelOrder : " + zigzagLevelOrder(root));
        System.out.println("IterativeZigzagLevelOrder : " + IterativeZigzagLevelOrder(root));
        System.out.println("IterativeAverageOfLevels : " + IterativeAverageOfLevels(root));
        System.out.println("recursiveAverageOfLevels : " + averageOfLevels(root));
        System.out.println("rightSideView : " + rightSideView(root));
        System.out.println("rightSideViewIterative : " + rightSideViewIterative(root));
        System.out.println("largestValues : " + largestValues(root));
        System.out.println("largestValuesIterative : " + largestValuesIterative(root));
        System.out.println("connectRightPointer : " + connect(root));
//        System.out.println("levelOrderNArray : " + levelOrderNArray(root));
        System.out.println("maxDepth : " + maxDepth(root));
        System.out.println("isBalanced : " + isBalanced(root));
        System.out.println("diameterOfBinaryTree : " + diameterOfBinaryTree(root));
        System.out.println("isSameTree : " + isSameTree(root, root));
        System.out.println("isSymmetric : " + isSymmetric(root));
        System.out.println("verticalTraversal : " + verticalTraversal(root));
        System.out.println("GetPathFromNode : " + getPathFromRoot(root, 7));
        System.out.println("lowestCommonAncestor : " + lowestCommonAncestor(root, root, root));
//        System.out.println("widthOfBinaryTree : " + widthOfBinaryTree(root));
        System.out.println("changeTree : ");
        changeTree(root);
        System.out.println("distancek : " + distanceK(root, root, 2));




    }

    public static List<Integer> preorderTraversal(TreeNode root) { //root left right
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.add(root.val);

        result.addAll(preorderTraversal(root.left));
        result.addAll(preorderTraversal(root.right));
        return result;
    }

    public static List<Integer> IterativePreorderTraversal(TreeNode root) { //root left right
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                result.add(node.val);
                stack.push(node.right);
                stack.push(node.left);
            }
        }
        return result;
    }

    public static List<Integer> inorderTraversal(TreeNode root) {//left root right
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        result.addAll(inorderTraversal(root.left));
        result.add(root.val);
        result.addAll(inorderTraversal(root.right));
        return result;
    }

    public static List<Integer> postorderTraversal(TreeNode root) {//left right root
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }

    public static List<List<Integer>> IterativeLevelOrder(TreeNode root) {
        List<List<Integer>> al = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return al;
        }
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> subResult = new ArrayList<>();
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                TreeNode temp = queue.poll();
                subResult.add(temp.val);
            }
            al.add(subResult);
        }
        return al;
    }

    public static List<List<Integer>> IterativeLevelOrderBottomUp(TreeNode root) {
        List<List<Integer>> al = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return al;
        }
        queue.add(root);

        while (!queue.isEmpty()) {
            al.add(0, new ArrayList<>());
            int noOfNodeInLevel = queue.size();
            for (int i = 0; i < noOfNodeInLevel; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                TreeNode temp = queue.poll();
                al.get(0).add(temp.val);
            }
        }
        return al;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> al = new ArrayList<>();
        helper(root, 0, al);
//        Collections.reverse(al); // Good solution for level order bottom up
        return al;
    }

    public static void helper(TreeNode root, int level, List<List<Integer>> resultList) {
        if (root == null) {
            return;
        }
        if (resultList.size() == level) {
            resultList.add(new ArrayList<>());
        }
        resultList.get(level).add(root.val);
        helper(root.left, level + 1, resultList);
        helper(root.right, level + 1, resultList);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> al = new ArrayList<>();
        helperLevelOrder(root, 0, al);
        return al;
    }

    public static void helperLevelOrder(TreeNode root, int level, List<List<Integer>> resultList) {
        if (root == null) {
            return;
        }
        if (resultList.size() <= level) {
            resultList.add(0, new ArrayList<>());
        }

        helperLevelOrder(root.left, level + 1, resultList);
        helperLevelOrder(root.right, level + 1, resultList);
        resultList.get(resultList.size() - level - 1).add(root.val);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> al = new ArrayList<>();
        helperZigZag(root, 0, al);
        return al;
    }

    public static void helperZigZag(TreeNode root, int level, List<List<Integer>> resultList) {
        List<Integer> dd = new LinkedList<>();
        if (root == null) {
            return;
        }
        if (resultList.size() == level) {
            resultList.add(new ArrayList<>());
        }
        if (level % 2 == 0) { //even level
            resultList.get(level).add(root.val);
        } else {
            resultList.get(level).add(0, root.val);
        }

        helperZigZag(root.left, level + 1, resultList);
        helperZigZag(root.right, level + 1, resultList);

    }

    public static List<List<Integer>> IterativeZigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 1;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (level % 2 == 0) {
                    levelList.add(0, current.val);
                } else {
                    levelList.add(current.val);
                }
                if (current.left != null) {
                    queue.add(current.left);
                }
                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            level++;
            result.add(levelList);
        }
        return result;
    }

    public static List<Double> IterativeAverageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.add(root);

        while (!queue.isEmpty()) {
            Double sum = 0.0;
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                TreeNode temp = queue.poll();
                sum += temp.val;
            }
            result.add(sum / level);
        }
        return result;
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> sum = new ArrayList<>();
        List<Double> count = new ArrayList<>();
        recursiveAverageOfLevels(root, sum, count, 0);
        for (int i = 0; i < sum.size(); i++) {
            sum.set(i, sum.get(i) / count.get(i));
        }
        return sum;
    }

    public static void recursiveAverageOfLevels(TreeNode root, List<Double> sum, List<Double> count, int level) {
        if (root == null) {
            return;
        }

        if (sum.size() == level) {
            sum.add(0.0);
            count.add(0.0);
        }
        double previousValue = sum.get(level);
        sum.set(level, previousValue + root.val);
        count.set(level, count.get(level) + 1);

        recursiveAverageOfLevels(root.left, sum, count, level + 1);
        recursiveAverageOfLevels(root.right, sum, count, level + 1);
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightSideViewHelperOtherWay(root, 0, result);
        return result;
    }

    public static void rightSideViewHelper(TreeNode root, int level, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (result.size() == level) {
            result.add(0);
        }
        result.set(level, root.val);
        rightSideViewHelper(root.left, level + 1, result);
        rightSideViewHelper(root.right, level + 1, result);
    }

    public static void rightSideViewHelperOtherWay(TreeNode root, int level, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (result.size() == level) {
            result.add(root.val);
        }

        rightSideViewHelperOtherWay(root.right, level + 1, result);
        rightSideViewHelperOtherWay(root.left, level + 1, result);

    }

    public static List<Integer> rightSideViewIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.add(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            for (int i = 0; i < level; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                TreeNode temp = queue.poll();
                if (i == level - 1) {
                    result.add(temp.val);
                }
            }
        }
        return result;
    }

    public static List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        largestValuesHelper(root, 0, result);
        return result;
    }

    public static void largestValuesHelper(TreeNode root, int level, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (result.size() == level) {
            result.add(root.val);
        }
        int prev = result.get(level);
        if (root.val > prev) {
            result.set(level, root.val);
        }
        largestValuesHelper(root.left, level + 1, result);
        largestValuesHelper(root.right, level + 1, result);
    }

    public static List<Integer> largestValuesIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return result;
        }
        queue.add(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            int rowMax = Integer.MIN_VALUE;
            for (int i = 0; i < level; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                TreeNode temp = queue.poll();
                if (temp.val > rowMax) {
                    rowMax = temp.val;
                }
            }
            result.add(rowMax);
        }
        return result;
    }


    public static TreeNode connect(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }

        connect(root.left);
        connect(root.right);
        return root;
    }

    public static List<List<Integer>> levelOrderNArray(TreeNode root) {
        List<List<Integer>> al = new ArrayList<>();
        helperNArray(root, 0, al);
        return al;
    }

    public static void helperNArray(TreeNode root, int level, List<List<Integer>> resultList) {
        if (root == null) {
            return;
        }
        if (resultList.size() == level) {
            resultList.add(new ArrayList<>());
        }
        resultList.get(level).add(root.val);
        List<TreeNode> children = root.children;
        int childrenSize = root.children.size();
        for (int i = 0; i < childrenSize; i++) {
            helperNArray(children.get(i), level + 1, resultList);
        }
    }

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    /**
     * Balanced Binary Tree
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftHeight = maxDepth(root.left);
        int rightHeight = maxDepth(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    static int diameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        diameterOfBinaryTreeHelper(root);
        return diameter;
    }

    public static int diameterOfBinaryTreeHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = diameterOfBinaryTreeHelper(root.left);
        int rightHeight = diameterOfBinaryTreeHelper(root.right);
        diameter = Math.max(diameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        // Base case: if both trees are null, they are identical
        if (p == null && q == null) {
            return true;
        }
        // If only one tree is null or the values are different, they are not identical
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        // Recursively check if the left and right subtrees are identical
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    public static boolean isSymmetric(TreeNode root) {
        return isSymmetricHelper(root.left, root.right);
    }

    public static boolean isSymmetricHelper(TreeNode left, TreeNode right) {

        // Base case: if both trees are null, they are identical
        if (left == null && right == null) {
            return true;
        }
        // If only one tree is null or the values are different, they are not identical
        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }

    //Function to return a list of nodes visible from the top view
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(TreeNode root) {
        // add your code
        return null;

    }

    public static List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, TreeMap<Integer, PriorityQueue>> mapList = new TreeMap<>();
        verticalTraversalHelper(root, 0, 0, mapList);
        List<List<Integer>> result = new ArrayList<>();
        for (Map.Entry<Integer, TreeMap<Integer, PriorityQueue>> entry : mapList.entrySet()) {
            List<Integer> col = new ArrayList<>();
            for (PriorityQueue set : entry.getValue().values()) {
                // Insert node values
                // into the column list
                col.addAll(set);
            }
            // Add the column list
            // to the final result
            result.add(col);
        }
        return result;
    }

    public static void verticalTraversalHelper(TreeNode root, int row, int column, Map<Integer, TreeMap<Integer, PriorityQueue>> mapList) {
        if (root == null) {
            return;
        }
        /**
         * PutIfAbsent or computeIfabsent are all good form of code
         */
//        map.putIfAbsent(index, new TreeMap<>());
//        map.get(index).putIfAbsent(level, new PriorityQueue<>());
//        map.get(index).get(level).add(root.val);

        if (!mapList.containsKey(column)) {
            mapList.put(column, new TreeMap<>());
        }
        if (!mapList.get(column).containsKey(row)) {
            mapList.get(column).put(row, new PriorityQueue<>());
        }
        mapList.get(column).get(row).offer(root.val);

        verticalTraversalHelper(root.left, row + 1, column - 1, mapList);
        verticalTraversalHelper(root.right, row + 1, column + 1, mapList);
    }

    public static List<Integer> getPathFromRoot(TreeNode A, int B) {

        List<Integer> result = new ArrayList<>();

        getPathHelper(A, result, B);
        Collections.reverse(result);
        return result;

    }

    public static boolean getPathHelper(TreeNode root, List<Integer> arr, int x) {

        if (root == null) {
            return false;
        }
        if (root.val == x) {
            arr.add(root.val);
            return true;
        }
        boolean leftPath = getPathHelper(root.left, arr, x);
        boolean rightPath = false;
        if (!leftPath) {
            rightPath = getPathHelper(root.right, arr, x);
        }
        if (leftPath || rightPath) {
            arr.add(root.val);
            return true;
        }
        return false;
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        return left == null ? right : right == null ? left : root;
/**
 * So clever, the last line can be explained by
 */
//        if(left == null && right == null) return null;
//        if(left != null && right != null) return root;
//        return left == null ? right : left;
    }



//    public static int widthOfBinaryTree(TreeNode root) {
//
//        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
//        queue.add(root);
//        int max=0;
//        while(!q.isEmpty()){
//            int size=queue.size();`
//            for(int j=0;j<size;j++){
//                TreeNode topElement=queue.peek();
//
//            }
//            max=Math.max(queue.size(),max);
//        }
//    }

    public static void changeTree(TreeNode root) {

        if (root == null) {
            return;
        }
        int child = 0;
        if (root.left != null) {
            child += root.left.val;
        }
        if (root.right != null) {
            child += root.right.val;
        }

        if (root.val > child) {
            if (root.left != null) {
                root.left.val = root.val;
            } else if (root.right != null) {
                root.right.val = root.val;
            }
        } else {
            root.val = child;
        }
        changeTree(root.left);
        changeTree(root.right);
        int tot = 0;
        if (root.left != null) {
            tot += root.left.val;
        }
        if (root.right != null) {
            tot += root.right.val;
        }

        // If either left or right child
        // exists, update the current node's
        // value with the total sum.
        if (root.left != null || root.right != null) {
            root.val = tot;
        }
    }

    static Map<Integer, Set<TreeNode>> parentMap = new HashMap<>();

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildParentMap(root, null);
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(target.val);
        visited.add(target.val);
        while (!queue.isEmpty() && k>0) {
            int size=queue.size();
            for (int i = 0; i < size; i++) {
                Set<TreeNode> adjacentNodes = parentMap.get(queue.peek());
                queue.poll();
                for (TreeNode adjacentElement : adjacentNodes) {
                    if (!visited.contains(adjacentElement.val)) {
                        visited.add(adjacentElement.val);
                        queue.offer(adjacentElement.val);
                    }
                }
            }
            k--;
        }

        return new ArrayList<>(queue);
    }

    public static void buildParentMap(TreeNode root, TreeNode parent) {

        if (root == null) {
            return;
        }
        parentMap.put(root.val, new HashSet<>());
        if (root.left != null) {
            parentMap.get(root.val).add(root.left);
        }
        if (root.right != null) {
            parentMap.get(root.val).add(root.right);
        }
        if (parent != null) {
            parentMap.get(root.val).add(parent);
        }
        buildParentMap(root.left, root);
        buildParentMap(root.right, root);
    }

    TreeNode prev=null;
    public void flatten(TreeNode root) {

        if(root==null){
            return;
        }
        flatten(root.left);
        flatten(root.right);

        root.left=null;
        root.right=prev;
        prev=root;

    }
    public static String serialize(TreeNode root) {
        if (root == null) return "";
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    public static TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",",-1)));
        return helper(queue);
    }

    private static TreeNode helper(Queue<String> queue) {
        String s = queue.poll();
        if (s.isEmpty()) return null;
        TreeNode root = new TreeNode(Integer.valueOf(s));
        root.left = helper(queue);
        root.right = helper(queue);
        return root;
    }

}
