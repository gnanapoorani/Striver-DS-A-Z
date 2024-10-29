package GeeksForGeeks;

class MergeLinkedListInOrder {
    /* Structure of the node*/
 static class Node
{
	int data;
	Node next;

	Node(int d)
	{
		data = d;
		next = null;
	}
}
    public static void main(String[] args) {
        Node node1= new Node(5);// 5->10->15->40
        node1.next= new Node(10);
        node1.next.next= new Node(15);
        node1.next.next.next= new Node(40);

        Node node2= new Node(2);// 2->3->20
        node2.next= new Node(3);
        node2.next.next= new Node(20);
        mergeResult(node1,node2);
    }

   static Node mergeResult(Node node1, Node node2)
    {
        Node pointer1=node1;
        Node pointer2=node2;
        Node node3 = null;
        Node temp=null;
        while(pointer1!=null && pointer2!=null){
            if(pointer1.data<=pointer2.data){
                temp=new Node(pointer1.data);
                pointer1=pointer1.next;
            }else{
                temp=new Node(pointer2.data);
                pointer2=pointer2.next;
            }
            if(node3==null){
                node3=temp;
            }else{
                temp.next=node3;
                node3=temp;
            }
        }
        while(pointer1!=null){
            temp=new Node(pointer1.data);
            temp.next=node3;
            node3=temp;
            pointer1=pointer1.next;
        }
        while(pointer2!=null){
            temp=new Node(pointer2.data);
            temp.next=node3;
            node3=temp;
            pointer2=pointer2.next;
        }
return node3;
    }
}