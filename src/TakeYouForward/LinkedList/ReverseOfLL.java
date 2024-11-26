package TakeYouForward.LinkedList;

class ReverseOfLL {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(reverseListRecursive(head));
        System.out.println(reverseListIterative(head));
    }

    public static ListNode reverseListIterative(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;

        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next==null) {
            return head;
        }
        ListNode newHead=reverseListRecursive(head.next);
        ListNode front =head.next;
        front.next=head;
        head.next=null;
        return newHead;
    }
}