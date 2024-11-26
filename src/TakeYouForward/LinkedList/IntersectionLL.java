package TakeYouForward.LinkedList;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/solutions/49785/java-solution-without-knowing-the-difference-in-len/
 */
class IntersectionLL {

    public static void main(String[] args) {
        ListNode head = new ListNode(11);
        head.next = new ListNode(2);
        head.next.next = new ListNode(33);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(15);
        printLL(getIntersectionNode(head,head));
    }

    public static void printLL(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;

        ListNode a = headA;
        ListNode b = headB;

        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }

        return a;
    }


}