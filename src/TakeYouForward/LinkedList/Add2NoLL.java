package TakeYouForward.LinkedList;

/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/solutions/49785/java-solution-without-knowing-the-difference-in-len/
 */
class Add2NoLL {

    public static void main(String[] args) {
        ListNode head = new ListNode(11);
        head.next = new ListNode(2);
        head.next.next = new ListNode(33);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(15);
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        printLL(addTwoNumbers(head, head2));
    }

    public static void printLL(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode curr = sum;
        int carry=0;
        int totalSum=0;
        while (l1 != null || l2 != null || carry!=0) {
              totalSum=carry;
            if(l1!=null){
                totalSum+=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                totalSum+=l2.val;
                l2=l2.next;
            }
            ListNode node = new ListNode(totalSum % 10);
            curr.next=node;
            curr=node;
            carry=totalSum/10;
        }

        return sum.next;
    }


}