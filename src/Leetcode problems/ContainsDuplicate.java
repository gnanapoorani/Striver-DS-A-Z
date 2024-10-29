import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ContainsDuplicate {
    public static void main(String[] args) {

        String reportId= "234567890123456789012345678901234567890";
       BigInteger a= new BigInteger(reportId);
       System.out.println(a);
        int arr[]= {1,2,9,92,2,1,342,234,99};
        System.out.println(containsDuplicate(arr));
        Arrays.sort(arr);
        Set<Integer> seen = new HashSet<>();
        /*java Strems*/
        System.out.println(Arrays.stream(arr).anyMatch(num->!seen.add(num)));
        System.out.println(Arrays.stream(arr).distinct().count() < arr.length);
    }
    public static boolean containsDuplicate(int[] nums) {

        HashSet set = new HashSet();
        for(int i=0;i<nums.length;i++){
//            for(int i:nums){ //foreach
            if(!set.add(nums[i]))
                return true;
        }
        return false;
    }
}