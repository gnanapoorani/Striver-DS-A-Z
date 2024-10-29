package Tree;

class BinarySearchTree {
    static class node {
        int key;
        node left, right;

    }

    // Function to create a new BST node
    static node newNode(int item) {
        node temp = new node();
        temp.key = item;
        temp.left = temp.right = null;
        return temp;
    }

    public static void main(String[] args) {
        node root = new node();
// inserting value 50
        root = insert(root, 50);
        // inserting value 30
        insert(root, 30);
        // inserting value 20
        insert(root, 20);
        // inserting value 40
        insert(root, 40);
        // inserting value 70
        insert(root, 70);
        // inserting value 60
        insert(root, 60);
        // inserting value 80
        insert(root, 80);
        // print the BST
        System.out.println("\nInorder");
        inorder(root);
        System.out.println("\nPreorder");
        preOrder(root);
        System.out.println("\nPostorder");
        postOrder(root);
        System.out.println("\nLevelorder");
        printLevelOrder(root);
    }

    static void inorder(node root) { //20 30 40 50 60 70 80
        if (root != null) {
            inorder(root.left);
            System.out.print(" " + root.key);
            inorder(root.right);
        }
    }

    /* Let us create following BST
                50
             /     \
            30      70
           /  \    /  \
         20   40  60   80
     */
    // Function to do preorder traversal of BST
    static void preOrder(node root) //50 30 20 40 70 60 80
    {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // Function to do postorder traversal of BST
    static void postOrder(node root)  // 20 40 30 60 80 70 50
    {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(" " + root.key);
        }
    }

    // Returns height of the BST
    static int height(node node)
    {
        if (node == null)
            return 0;
        else {

            // Compute the depth of each subtree
            int lDepth = height(node.left);
            int rDepth = height(node.right);

            // Use the larger one
            if (lDepth > rDepth)
                return (lDepth + 1);
            else
                return (rDepth + 1);
        }
    }

    // Print nodes at a given level
    static void printGivenLevel(node root, int level)
    {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(" " + root.key);
        else if (level > 1) {

            // Recursive Call
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }

    // Function to line by line print
    // level order traversal a tree
    //50
    //  30  70
    //  20  40  60  80
    static void printLevelOrder(node root)
    {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++) {
            printGivenLevel(root, i);
            System.out.println();
        }
    }

    // Function to print leaf nodes
    // from left to right
    static void printLeafNodes(node root)//20 40 60 80
    {
        // If node is null, return
        if (root == null)
            return;

        // If node is leaf node,
        // print its data
        if (root.left == null && root.right == null) {
            System.out.print(" " + root.key);
            return;
        }

        // If left child exists,
        // check for leaf recursively
        if (root.left != null)
            printLeafNodes(root.left);

        // If right child exists,
        // check for leaf recursively
        if (root.right != null)
            printLeafNodes(root.right);
    }

    // Function to print all non-leaf
    // nodes in a tree
    static void printNonLeafNode(node root)
    {
        // Base Cases
        if (root == null
                || (root.left == null && root.right == null))
            return;

        // If current node is non-leaf,
        if (root.left != null || root.right != null) {
            System.out.print(" " + root.key);
        }

        // If root is Not NULL and its one
        // of its child is also not NULL
        printNonLeafNode(root.left);
        printNonLeafNode(root.right);
    }
    // Function to insert a new node with
    // given key in BST
    static node insert(node node, int key) {
        // If the tree is empty, return a new node
        if (node == null)
            return newNode(key);

        // Otherwise, recur down the tree
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        }
        // Return the node
        return node;
    }

}