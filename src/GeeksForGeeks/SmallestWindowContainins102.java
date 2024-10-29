package GeeksForGeeks;

import java.util.HashMap;

class SmallestWindowContainins102 {
    public static void main(String[] args) {
        String input = "1211";
        System.out.println(smallestSubstring(input));
    }
//    public static int lengthOfLongestSubstring(String s) {
//        int maxLength = 0;
//        Hashtable<Character, Integer> hashtable = new Hashtable<Character, Integer>();
//
//        for (int i = 0, j = 0; j < s.length(); j++) {
//            if (hashtable.containsKey(s.charAt(j))) {
//                if (maxLength <= j - i) {
//                    maxLength = j - i;
//                }
//                i = hashtable.get(s.charAt(j)) + 1;
//                j = i - 1;
//                hashtable = new Hashtable<Character, Integer>();
//
//            } else if (j == s.length() - 1) {
//                if (maxLength <= j - i) {
//                    maxLength = j - i + 1;
//                }
//            } else {
//                hashtable.put(s.charAt(j), j);
//            }
//
//        }
//        return maxLength;
//    }

    public static int smallestSubstring(String s) {
        if(s.length()==0) return 0;
        int j=0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('0',1);
        map.put('1',1);
        map.put('2',1);
        int left=0,right=0,minLength= Integer.MAX_VALUE,count=0;
        while(right<s.length()){
                Integer val=map.get(s.charAt(right))-1;
                map.replace(s.charAt(right),val);
                if(map.get(s.charAt(right))>=0){
                    count++;  
                }
              
            while(count==3){
               if( minLength>right-left+1){
                   minLength= right-left +1;
               }
              if(minLength==3){
                  break;
              }
                Integer val2=map.get(s.charAt(left))+1;
                map.replace(s.charAt(left),val2);
                if(map.get(s.charAt(left))>0){
                    count--;
                }
              left++;
            }
            if(minLength==3){
                return minLength;
            }
            right++;
        }
return minLength== Integer.MAX_VALUE?-1:minLength;
    }
}