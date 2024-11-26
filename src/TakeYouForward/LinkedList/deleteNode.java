package TakeYouForward.LinkedList;

public class deleteNode {

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(5);
        deleteNode(head.next.next);
    }

    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    static ListNode deleteAllOccurOfX(ListNode head, int x) {
       return head;
    }
}
