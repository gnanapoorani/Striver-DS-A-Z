package TakeYouForward.LinkedList;


class OddEvenLL {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(oddEvenList(head));
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head!=null){
            ListNode odd = head;
            ListNode even = head.next;
            ListNode initialEvenHead = head.next;
            while (odd != null && even != null && even.next != null) {
                odd.next=odd.next.next;
                even.next=even.next.next;
                odd=odd.next;
                even=even.next;
            }
            odd.next=initialEvenHead;
        }
        return head;
    }
}