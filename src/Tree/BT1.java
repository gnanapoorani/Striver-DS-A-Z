package Tree;

import java.util.HashSet;

class Node{
    int item;
   Node left;
   Node right;
    Node(int key){
        item=key;
        left=right=null;
    }
}

class BT1 {


    public static void main(String[] args)  {
        HashSet set= new HashSet();
        set.add(2);
       Node root = new Node(10);
        root.left = new Node(11);
        root.left.left = new Node(7);
        root.right = new Node(9);
        root.right.left = new Node(15);
        root.right.right = new Node(8);




    }
}