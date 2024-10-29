package PraticeJava;
import java.util.*;
public class PracticeProgram{
    public static void main(String[] args){
        int[] nums = {3, 5, 9, 5, 12, 3, 5};
       
        //System.out.println(secondLargest(nums));
       //printOccurence(nums);
       List al = new LinkedList();
       al.add(2);
       al.add(2);
       al.add(200);
       al.add(2000);
       System.out.println(al.get(0));
        System.out.println(al.get(1));
        System.out.println(al.get(2));
        System.out.println(al.get(3));


    }

    public static int secondLargest(int[] nums){
        int fl = Integer.MIN_VALUE;
        int sl = Integer.MIN_VALUE;

        if(nums.length < 2)
            return -1;

        for(int num : nums){
            if(num > fl){
                sl = fl;
                fl = num;
            } else if (num > sl && num < fl){
                sl = num;
            }
        }
        if(sl == Integer.MIN_VALUE)
            return -1;
        else
            return sl;
    }

    public static void printOccurence(int[] nums){
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int num : nums){
            if(hm.containsKey(num))
                hm.put(num, hm.get(num) + 1);
            else
                hm.put(num,1);
        }
        for(int r : hm.keySet()){
            System.out.println(r + "====>>>" + hm.get(r));
        }
    }
}

