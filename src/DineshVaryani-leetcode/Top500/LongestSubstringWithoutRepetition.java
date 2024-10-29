import java.util.HashMap;

class LongestSubstringWithoutRepetition {
    public static void main(String[] args) {
        String input = "pwwkew";
        System.out.println(lengthOfLongestSubstring(input));
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

    public static int lengthOfLongestSubstring(String s) {
        if(s.length()==0) return 0;
        HashMap<Character, Integer> set = new HashMap<>();
        int index =0,j=0;
        for(int i=0;i<s.length();i++){
            if(!set.containsKey(s.charAt(i))){
                set.put(s.charAt(i),i+1);
            }else{
                j = Math.max(set.get(s.charAt(i)),j);
                set.put(s.charAt(i),i+1);

            }
            index = Math.max(index,i-j+1);
        }
        return index==0?1:index;
    }
}