import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class ValidAnagram {
        public boolean isAnagram1(String s, String t) {
            //Method-1 Create char array, sort and compare
        /*
        if(s.length() != t.length()) return false;
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();
        Arrays.sort(cs);
        Arrays.sort(ct);
        for(int i=0; i<cs.length; i++){
            if(cs[i]!=ct[i]) return false;
        }
        return true;
        */

            //Method-2 Using hashmaps
        /*
        if(s.length() != t.length()) return false;
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }

        for(int i=0; i<t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0)-1);
            if(map.get(t.charAt(i))<0) return false;
        }
        //System.out.println(map);

        return true;
        */

            //Method-3 Use string functions
        /* //Uncomment the function in the array
        if(s.length() != t.length()) return false;
        String s1 = sortHere(s);
        String t1 = sortHere(t);
        return s1.equals(t1);
        */

            //Method-4 Using alphabet array to count
            if(s.length() != t.length()) return false;
            int[] alphabet = new int[26];

            for(int i=0; i<s.length(); i++){
                alphabet[s.charAt(i)-'a']++;
                alphabet[t.charAt(i)-'a']--;
            }

            for(int n: alphabet)
                if(n!=0)
                    return false;

            return true;
        }

    /*
    private String sortHere(String s){
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        return String.valueOf(ch);
    }
    */

    public static void main(String[] args) {
        String one="abcd$";
        String two="efcg*";
        isAnagram(one,two);
        int sum1=0,sum2=0,prod1=1,prod2=1;
//        System.out.println(containsDuplicate(one,two));
        for(int i=0;i<one.length();i++){
             sum1=sum1+(int)one.charAt(i);
             prod1=prod1*(int)one.charAt(i);
        }
        for(int j=0;j<two.length();j++){
            sum2=sum2+(int)two.charAt(j);
            prod2=prod2*(int)two.charAt(j);
        }
        if(sum1==sum2 && prod1==prod2)
            System.out.println("true");
        else
            System.out.println("false");
    }
    public static boolean containsDuplicate(String one,String two) {
        char oneArray[] = one.toCharArray();
        char secondArray[] =two.toCharArray();
        Arrays.sort(oneArray);
        Arrays.sort(secondArray);
     return    oneArray.toString().equals(secondArray.toString());
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] result = new int[26];

        char[] first_array = s.toCharArray();
        char[] second_array = t.toCharArray();

        for (int i = 0; i < first_array.length; i++) {
            int ak= 'a';
            System.out.println("pooramo"+ak);
            result[first_array[i] - 'a'] += 1;
        }

        for (int i = 0; i < second_array.length; i++) {
            result[second_array[i] - 'a'] -= 1;
        }

        for (int i = 0; i < 26; i++) {
            if (result[i] != 0) {
                return false;
            }
        }
        return true;

    }
}