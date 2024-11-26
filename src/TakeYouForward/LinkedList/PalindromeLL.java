package TakeYouForward.LinkedList;


class PalindromeLL {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!= null &&  fast.next.next!= null){
            slow=slow.next;
            fast=fast.next.next;
        }
       ListNode secondHalf= reverseListRecursive(slow.next);
        ListNode firstHalf =head;
        while(secondHalf!=null){
            if(firstHalf.val!= secondHalf.val){
                return false;
            }
            secondHalf=secondHalf.next;
            firstHalf=firstHalf.next;
        }
        return true;
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