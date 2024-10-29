package GeeksForGeeks;//Given two strings s and t of lengths m and n respectively, return the minimum window substring
// of s such that every character in t (including duplicates) is included in the window.
// If there is no such substring, return the empty string "".

import java.util.Hashtable;

class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t="ABC";
        System.out.println(minWindow(s,t));
        System.out.println(minWindowBestSolution(s,t));
    }


        public static String minWindowBestSolution(String s, String t) {
            if (s == null || t == null || s.length() ==0 || t.length() == 0 ||
                    s.length() < t.length()) {
                return new String();
            }
            int[] map = new int[128];
            int count = t.length();
            int start = 0, end = 0, minLen = Integer.MAX_VALUE,startIndex =0;
            for (char c :t.toCharArray()) {
                map[c]++;
            }
            char[] chS = s.toCharArray();
            while (end < chS.length) {
                if (map[chS[end++]]-- >0) {
                    count--;
                }
                while (count == 0) {
                    if (end - start < minLen) {
                        startIndex = start;
                        minLen = end - start;
                    }
                    if (map[chS[start++]]++ == 0) {
                        count++;
                    }
                }
            }

            return minLen == Integer.MAX_VALUE? new String():
                    new String(chS,startIndex,minLen);
        }
    public static String minWindow(String s, String t) {
        Hashtable<Character, Integer> hashtable = new Hashtable<>();
        //Intializing hash table with t string all has value 1;
        for(char c:t.toCharArray()){
            if(hashtable.containsKey(c)){
                Integer value1=hashtable.get(c)+1;
                hashtable.replace(c,value1);
            }else{
                hashtable.put(c,1);
            }

        }
        //Intialize 2 pointers
        int left=0,right=0,minlength= Integer.MAX_VALUE, countAllCharInT = 0;;
        int length= s.length();
        String minLenStr="";
       while(right<length){
           if(hashtable.containsKey(s.charAt(right))){
               Integer value1=hashtable.get(s.charAt(right))-1;
               hashtable.replace(s.charAt(right),value1);
               if(hashtable.get(s.charAt(right))>=0){
                   countAllCharInT++;
               }
               while(countAllCharInT==t.length()){
                   //Update the minLen
                   if(minlength > right - left + 1){
                       minlength = right - left + 1;
                       minLenStr = s.substring(left, right + 1);
                   }
                   if(hashtable.containsKey(s.charAt(left))){
                       Integer value2=hashtable.get(s.charAt(left))+1;
                       hashtable.replace(s.charAt(left),value2);
                       if(hashtable.get(s.charAt(left))>0){
                           countAllCharInT--;
                       }
                   }
                   left++;
               }
           }
           right++;
       }
return minLenStr;
    }
}