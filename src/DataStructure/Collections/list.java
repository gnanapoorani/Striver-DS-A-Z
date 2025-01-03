package DataStructure.Collections;

import java.util.*;

public class list {
    public static void main(String[] args) {
        AbstractList<String> list = new LinkedList<>();

        ArrayList<Integer> a= new ArrayList<>();
        a.ensureCapacity(2);

        list.add("Geeks");
        list.add("for");
        list.add("Geeks");
        list.add("10");
        list.add("20");
        System.out.println(list);
        // Set will replace the element in the specified index
        list.set(1, "forbb");
        System.out.println(list);
        // Add will add the element in the specified index and shift the already value in that index
        list.add(1, "forbbie");
        System.out.println(list);
        System.out.println(list.indexOf("forbb"));
        System.out.println(list.lastIndexOf("Geeks"));

        AbstractList<String> list2 = new ArrayList<>();
        list2.add("x");
        list2.add("Y");
        list2.add("Z");
        list.addAll(2, list2);
        System.out.println("After adding second list at index 2" + list);
        Iterator it = list.iterator();
        ListIterator lt = list.listIterator(2);

        while (it.hasNext()) {
            System.out.print(it.next());
        }
        System.out.println();

        while (lt.hasNext()) {
            System.out.print(lt.next());
        }

        //Specify the return type of toArray():

        String[] arr = new String[4];
        arr = list.toArray(arr);

        for(String item:arr){
            System.out.println(item);
        }

        AbstractCollection<Object> set1
                = new ArrayList<Object>();

        // adding values in set 1 list
        set1.add("one");
        set1.add("two");
        set1.add("three");

        // creating another arraylist
        AbstractCollection<Object> set2
                = new ArrayList<Object>();

        // adding values in set 2 list
        set2.add("three");
        set2.add("one");
        set2.add("five");

        // before invoking retainAll()
        System.out.println("Set 1 contains:\n"
                + set1 + "\n");
        System.out.println("Set 2 contains:\n"
                + set2 + "\n");

        // invoking retainAll()
        set2.retainAll(set1);

        // after invoking retainAll()
        System.out.println("Set 2 after"
                + " invoking retainAll() method:\n"
                + set2);

        Optional<String> result=list.stream().reduce((s1,s2)->s1+"_"+s2);
        System.out.println(result);

        Optional<String> result1=list.parallelStream().reduce((s1,s2)->s1+"_"+s2);
        System.out.println(result1);

        List<Integer> listOfNumbers = Arrays.asList(1, 2, 3, 4);
        int sum = listOfNumbers.parallelStream().reduce(5, Integer::sum);
    }
}
