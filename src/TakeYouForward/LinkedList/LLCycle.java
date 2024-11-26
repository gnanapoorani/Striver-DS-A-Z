package TakeYouForward.LinkedList;

class LLCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(hasCycle(head));
        System.out.println(detectCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode fast =head;
        ListNode slow = head;
        while(fast.next!=null && fast!=null){
            fast=fast.next.next;
            slow= slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

    /**
     *Starting point of the loop
     */

    public static ListNode detectCycle(ListNode head) {
        ListNode fast =head;
        ListNode slow = head;
        while(fast.next!=null && fast!=null){
            fast=fast.next.next;
            slow= slow.next;

            if(fast==slow){
                slow=head;
                int coount=findLength(slow,head);
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
               return slow;
            }

        }
        return null;
    }

    static int findLength(ListNode slow, ListNode fast){

        // count to keep track of
        // nodes encountered in loop
        int cnt = 1;

        // move fast by one step
        fast = fast.next;

        // traverse fast till it
        // reaches back to slow
        while(slow!=fast){

            // at each node increase
            // count by 1 and move fast
            // forward by one step
            cnt++;
            fast = fast.next;
        }

        // loop terminates when fast reaches
        // slow again and the count is returned
        return cnt;
    }
}