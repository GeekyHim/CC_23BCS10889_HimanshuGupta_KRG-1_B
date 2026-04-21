class Trie {

    static class Node {
        Node[] children = new Node[26];
        boolean isEnd;
    }

    private Node root;

    public Trie() {
        root = new Node();
    }

    // Insert word
    public void insert(String word) {
        Node curr = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.isEnd = true;
    }

    // Search full word
    public boolean search(String word) {
        Node node = traverse(word);
        return node != null && node.isEnd;
    }

    // Prefix check
    public boolean startsWith(String prefix) {
        return traverse(prefix) != null;
    }

    // Helper
    private Node traverse(String str) {
        Node curr = root;

        for (char c : str.toCharArray()) {
            int idx = c - 'a';

            if (curr.children[idx] == null) return null;

            curr = curr.children[idx];
        }

        return curr;
    }
}

public class TrieMain {
    public static void main(String[] args) {

        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");

        System.out.println(trie.search("apple"));   // true
        System.out.println(trie.search("app"));     // true
        System.out.println(trie.search("ap"));      // false

        System.out.println(trie.startsWith("app")); // true
        System.out.println(trie.startsWith("ba"));  // true
        System.out.println(trie.startsWith("cat")); // false
    }
}