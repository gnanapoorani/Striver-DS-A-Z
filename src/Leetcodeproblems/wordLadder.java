import java.util.*;

class Solution {
    public static void main(String[] args) {
        List<String> wordList=new ArrayList<>();
        wordList.add("ce");
        wordList.add("me");
        wordList.add("c0");
        wordList.add("mo");
        wordList.add("mk");
        wordList.add("ko");

        System.out.println(ladderLength("be","ko",wordList));
    }
    public static int ladderLength(String start, String end, List<String> dict) {
        // Use queue to help BFS
        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        queue.add(null);

        // Mark visited word
        Set<String> visited = new HashSet<String>();
        visited.add(start);

        int level = 1;

        while (!queue.isEmpty()) {
            String str = queue.poll();
System.out.println("poll from queue"+str);
            if (str != null) {
                // Modify str's each character (so word distance is 1)
                for (int i = 0; i < str.length(); i++) {
                    char[] chars = str.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;

                        String word = new String(chars);

                        // Found the end word
                        if (word.equals(end)) return level + 1;

                        // Put it to the queue
                        if (dict.contains(word) && !visited.contains(word)) {
                            queue.add(word);
                            visited.add(word);
                        }
                    }
                }
            } else {
                level++;

                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }

        return 0;
    }
}