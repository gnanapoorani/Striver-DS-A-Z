package TakeYouForward.Greedy;

import java.util.*;

//2147483647 - Int Max value
//-2147483647 - 1 int min value
class PageFaultsInLRU {


    public static void main(String[] args) {
        int pages[] = {5, 0, 1, 3, 2, 4, 1, 0, 5};
        int result = pageFaults(9, 4, pages);
        System.out.println(result);
    }

    static int pageFaults(int N, int C, int pages[]) {
        int page_fault = 0;
        Queue<Integer> queue = new ArrayDeque<>(4);
        for (int i = 0; i < pages.length; i++) {
            if (queue.contains(pages[i])) {
                queue.remove(pages[i]);
                queue.add(pages[i]); /** Add it in First**/
            } else { // add
                if (queue.size() == C) { /** max limit reached, remove LRU element **/
                    queue.remove();
                }
                queue.add(pages[i]);
                page_fault++;
            }
        }

        return page_fault;
    }

}