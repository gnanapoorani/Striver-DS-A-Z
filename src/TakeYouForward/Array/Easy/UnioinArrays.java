import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class UnionArrays{
    public static void main(String[] args){
        int arr1[] = {1, 2, 3, 4, 5, 6, 7, 8, 10};
        int arr2[] = {2, 3, 4, 4, 5,9, 11, 12};
        System.out.println(sortedArray1(arr1,arr2));
    }

    public static List< Integer > sortedArray(int []a, int []b) {
HashSet<Integer> set1= new HashSet<>();
ArrayList<Integer> list= new ArrayList<>();
for(int i:a){
    set1.add(i);
}
        for(int i:b){
            set1.add(i);
        }

        for(int value:set1){
            list.add(value);
        }
        return list;
    }
    public static List< Integer > sortedArray1(int []a, int []b) {
        ArrayList<Integer> list = new ArrayList<>();
        int i=0,j=0;
        while(i<a.length && j < b.length){
            if(a[i]<b[j]){
                list.add(a[i]);
                i++;
            }else if(a[i]==b[j]){
                list.add(b[j]);
                j++;
                i++;
            }else{
                list.add(b[j]);
                j++;
            }
        }
        while(i <a.length){
            list.add(a[i]);
            i++;
        }
        while(j<b.length){
            list.add(b[j]);
            j++;
        }
        return list;
    }

}