import java.util.*;

class GroupAnagram {
    public static void main(String[] args) {
        Map<String, List<String>> sortMap = new HashMap();
        String strs[]={"ate","tea","bat"};
        groupAnagrams(strs);
        for (String str : strs) {
            char temp[] = str.toCharArray();
            Arrays.sort(temp);
            String sortString=new String(temp);
            if(sortMap.get(sortString)==null)
                sortMap.put(sortString,new ArrayList<>());

            sortMap.get(sortString).add(str);
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        int numGroups = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        List<List<String>> anagrams = new ArrayList<List<String>>();
        for (String str : strs) {
            int[] alpha = getAnagramData(str);
            int hashcode = java.util.Arrays.hashCode(alpha);
            // for (int a : alpha) System.out.println(a);
            if (map.containsKey(hashcode)) {
                // Add string to existing list
                anagrams.get(map.get(hashcode)).add(str);
            }
            else {
                List<String> anagram = new ArrayList<String>();
                anagram.add(str);
                anagrams.add(anagram);
                map.put(hashcode, numGroups++);
            }
        }
        return anagrams;
    }

    private static int[] getAnagramData(String s) {
        int[] alphabet = new int[26];
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i)-'a']++;
        return alphabet;
    }
}