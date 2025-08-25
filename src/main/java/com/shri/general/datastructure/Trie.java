// Node class for Trie
class TrieNode {
    TrieNode[] children = new TrieNode[26]; // For lowercase a–z
    boolean isEndOfWord = false;
}

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
            }
            node = node.children[idx];
        }
        node.isEndOfWord = true;
    }

    // Search for a full word
    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
        }
        return node.isEndOfWord;
    }

    // Check if any word starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("cat");
        trie.insert("car");
        trie.insert("dog");

        System.out.println(trie.search("car"));      // true
        System.out.println(trie.search("cart"));     // false
        System.out.println(trie.startsWith("ca"));   // true
        System.out.println(trie.startsWith("do"));   // true
        System.out.println(trie.startsWith("da"));   // false
    }

}