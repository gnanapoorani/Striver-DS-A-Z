package TakeYouForward.Trie;


class TrieNode {
    boolean wordEnd;
    TrieNode[] children;
    int wordCount=0;
    int prefixCount=0;


    public TrieNode() {
        wordEnd = false;
        children = new TrieNode[26]; // 26 English lowercase letters
    }
}

class Trie {
    static TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public static void main(String[] args) {

        insert("appke");
        insert("");
        insert("");
        System.out.println(search("a"));
        System.out.println(search("a"));
        System.out.println(search("a"));
        System.out.println(startsWith("a"));

    }

    public static  void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
            node.prefixCount++;
        }
        node.wordCount++;
        node.wordEnd = true;
    }

    public static boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.wordEnd;
    }

    public static boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }
//
//    public static int countWordsEqualTo(String word) {
//
//        for (char c : word.toCharArray()) {
//
//        }
//    }
//
//    public static int countWordsStartingWith(String word) {
//        // Write your code here.
//    }
//
//    public static void erase(String word) {
//        // Write your code here.
//    }
}
