import java.util.Arrays;

class CommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"man", "car","uct","man"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String prefix = strs[0];
        for (String s : strs)
            while (s.indexOf(prefix) != 0)
                prefix = prefix.substring(0, prefix.length() - 1);
        return prefix;
    }

    public static String longestCommonPrefix2(String[] strs) {
        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length-1];
        int idx = 0;
        while(idx < s1.length() && idx < s2.length()){
            if(s1.charAt(idx) == s2.charAt(idx)){
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }
    public static String longestCommonPrefix3(String[] strs) {
        String prefix = strs[0];
            if(prefix.length()>0){
                for(int j=1;j<=strs.length-1;j++){
                    int k=0;
                    while(k <=strs[j].length()-1 && k <=prefix.length()-1){
                        if (strs[j].charAt(k) == prefix.charAt(k)) {
                            k++;
                        }else{
                            break;
                        }
                    }
                    prefix=prefix.substring(0,k);
                }
            }
        return prefix.toString();
    }

}