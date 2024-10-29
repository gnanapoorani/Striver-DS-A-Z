//package TakeYouForward.Strings.Medium;
//
//import java.util.*;
//
//class SortByFrequency {
//    public static void main(String[] args) {
//        System.out.println(frequencySort2("tree"));
//    }
//
//    public static String frequencySort1(String s) {
//        Map<Character, Integer> map1 = new HashMap<>();
//        int i = 0;
//        while (i < s.length()) {
//            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
//            i++;
//        }
//        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
//
//        pq.addAll(map1.entrySet());
//        StringBuilder result = new StringBuilder();
//
//        while (!pq.isEmpty()) {
//            Map.Entry<Character, Integer> entry = pq.poll();
//            int value = entry.getValue();
//            while (value > 0) {
//                result.append((entry.getKey()));
//                value--;
//            }
//
//        }
//
//
//        return result.toString();
//    }
//
//    public static String frequencySort2(String s) {
//
//        Map<Character, Integer> map = new HashMap<>();
//        TreeMap<Integer, ArrayList<Character>> treemap = new TreeMap<Integer, ArrayList<Character>>(Collections.reverseOrder());
//        StringBuilder result = new StringBuilder();
//
//        for (Character c : s.toCharArray()) {
//            map.put(c, map.getOrDefault(c, 0) + 1);
//        }
//        for (Map.Entry<Character, Integer> entryMap : map.entrySet()) {
//            if (!treemap.containsKey(entryMap.getValue())) {
//                treemap.put(entryMap.getValue(), new ArrayList<>());
//            }
//            treemap.get(entryMap.getValue()).add(entryMap.getKey());
//
//        }
//        for (Map.Entry<Integer, ArrayList<Character>> entryMap : treemap.entrySet()) {
//
//            List<Character> values = entryMap.getValue();
//
//            for (char c : values) {
//                int frequency = entryMap.getKey();
//                while (frequency > 0) {
//                    result.append(c);
//                    frequency--;
//                }
//            }
//
//        }
//        return result.toString();
//    }
// // Array of list
//    public String frequencySort3(String s) {
//        HashMap<Character, Integer> map = new HashMap<>();
//        for(char ch : s.toCharArray()) {
//            map.put(ch, map.getOrDefault(ch,0)+1);
//        }
//        List<Character> [] bucket = new List[s.length()+1]; //array of list instead of treemap
//        for(Character key : map.keySet()) {
//            int freq = map.get(key);
//            if(bucket[freq] == null) {
//                bucket[freq]=new ArrayList<>();
//            }
//            bucket[freq].add(key);
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for(int i=bucket.length-1; i>=0; i--) {
//            if(bucket[i] != null) {
//                for(char ch : bucket[i]) {
//                    for(int j=0; j<map.get(ch); j++) {
//                        sb.append(ch);
//                    }
//                }
//            }
//        }
//        return sb.toString();
//    }
//
//    public String frequencySort4(String s) {
//        Map<Character, Integer> charFrequency = new HashMap<>();
//        for (char c : s.toCharArray()) {
//            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
//        }
//
//        // Convert string to char array for sorting
//        char[] charArray = s.toCharArray();
//
//        // Sort characters based on their frequency in descending order
////        Arrays.sort(charArray, (a, b) -> {
////            return charFrequency.get(b) - charFrequency.get(a) != 0 ? charFrequency.get(b) - charFrequency.get(a) : a - b;
////        });
//
//        return new String(charArray);
//    }
//
//    public String frequencySort(String s) {
//        // Step 1: Count the frequency of each character
//        Map<Character, Integer> charCount = new HashMap<>();
//        for (char c : s.toCharArray()) {
//            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
//        }
//
//        // Step 2: Sort characters based on their frequency in descending order
//        List<Character> sortedChars = new ArrayList<>(charCount.keySet());
//        Collections.sort(sortedChars, (a, b) -> charCount.get(b) - charCount.get(a));
//
//        // Step 3: Build the result string by repeating characters according to their frequency
//        StringBuilder result = new StringBuilder();
//        for (char c : sortedChars) {
////            result.append(String.valueOf(c).repeat(charCount.get(c)));
//        }
//
//        // Step 4: Return the final sorted string
//        return result.toString();
//    }
//}
//
//
//}