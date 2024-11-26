package TakeYouForward.LinkedList;


class MiddleOfLL {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Find the middle node
        ListNode middleNode = middleNode(head);

        System.out.println(middleNode);
    }

    public static ListNode middleNode(ListNode head) {
        ListNode fast =head;
        ListNode slow = head;
        while(fast.next!=null && fast!=null){
            fast=fast.next.next;
            slow= slow.next;
        }
        return slow;
    }
}