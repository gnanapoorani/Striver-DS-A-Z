package TakeYouForward.LinkedList;


class SortLL {

    public static void main(String[] args) {
        ListNode head = new ListNode(11);
        head.next = new ListNode(2);
        head.next.next = new ListNode(33);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(15);
        printLL(sortList(head));
    }

    public static void printLL(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
    public static ListNode sortList(ListNode head) {
        return  head;
    }


}