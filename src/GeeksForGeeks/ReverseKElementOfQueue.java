package GeeksForGeeks;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class ReverseKElementOfQueue{
    public static  void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        // add elements to the queue
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
      //  modifyQueue(queue,1);
        modifyQueueusingLinkedList(queue,3);
    }

    // Function to reverse first k elements of a queue.
    public static Queue<Integer> modifyQueue(Queue<Integer> queue, int k) {
        Queue<Integer> finalQueue = new LinkedList<>();
        Stack<Integer> stack= new Stack<>();
        for(int i=0;i<k;i++){
            int num=queue.poll();
            stack.add(num);
        }

        while(!stack.isEmpty()){
//            finalQueue.offer();
            finalQueue.add(stack.pop());
        }
        // print the queue

        while(!queue.isEmpty()){
           finalQueue.add(queue.poll());
        }
        System.out.println(finalQueue);
        return queue;
    }

    // Function to reverse first k elements of a queue.
    public Queue<Integer> modifyQueueWithBestSpaceComplexity(Queue<Integer> q, int k) {
        Stack<Integer> stack = new Stack<>();

        // Step 1: Reverse the first k elements and push them into the stack
        for (int i = 0; i < k; i++) {
            stack.push(q.poll());
        }

        // Step 2: Enqueue elements from the stack back to the queue
        while (!stack.isEmpty()) {
            q.offer(stack.pop());
        }

        // Step 3: Rotate the remaining elements in the queue
        for (int i = 0; i < q.size() - k; i++) {
            q.offer(q.poll());
        }

        return q;
    }

    public static Queue<Integer> modifyQueueusingLinkedList(Queue<Integer> q, int k) {
        if (k <= 0 || k > q.size()) {
            return q;
        }

        LinkedList<Integer> temp = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            temp.addFirst(q.poll());
        }

        while (!q.isEmpty()) {
            temp.add(q.poll());
        }

        return temp;
    }
}