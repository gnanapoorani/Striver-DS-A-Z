package TakeYouForward.Heaps.Basic;

import TakeYouForward.LinkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class MergeSortedArr {

    public static void main(String[] args) {
        ListNode list1= new ListNode(1);
        list1.next= new ListNode(4);
        list1.next.next= new ListNode(5);

        ListNode list2= new ListNode(1);
        list2.next= new ListNode(3);
        list2.next.next= new ListNode(4);

        ListNode list3= new ListNode(2);
        list3.next= new ListNode(6);
        ListNode[] lists= {list1,list2,list3};

        mergeKLists(lists);
    }
//        Queue<ListNode> heap1 = new PriorityQueue((l1, l2) -> l1.val - l2.val);

    public static ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> heap = new PriorityQueue(new Comparator<ListNode>(){
            @Override public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });

        ListNode head = new ListNode(0), tail = head;
        for (ListNode node : lists) if (node != null) heap.offer(node);
        while (!heap.isEmpty()) {
            tail.next = heap.poll();
            tail = tail.next;
            if (tail.next != null) heap.offer(tail.next);
        }
        return head.next;
    }
}
