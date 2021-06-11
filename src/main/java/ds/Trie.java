package ds;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Trie {

    private Node root;

    class Node {
        private final Map<Character, Node> children = new HashMap<>();
        private Boolean word = false;

        public boolean isWord() {
            return word;
        }

        public void setWord(boolean word) {
            this.word = word;
        }

        public Map<Character, Node> getChildren() {
            return children;
        }
    }

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            Function function = k -> new Node();
            node = node.getChildren().computeIfAbsent(letter, function);
        }
        node.setWord(true);
    }

    public boolean contains(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            if (!node.getChildren().containsKey(letter))
                return false;
            node = node.getChildren().get(letter);
        }
        return node.isWord();
    }

    public boolean isPrefix(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);

            if (!node.getChildren().containsKey(letter))
                return false;
            node = node.getChildren().get(letter);
        }
        return !node.isWord();
    }

    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    private boolean delete(Node node, String word, int position) {
        if (word.length() == position) {
            if (!node.word) {
                return false;
            }
            node.setWord(false);
            return node.getChildren().isEmpty();
        }
        char letter = word.charAt(position);
        Node children = node.getChildren().get(letter);

        if (children == null)
            return false;

        boolean deleteChildren = delete(children, word, position + 1);

        if (deleteChildren && !children.isWord()) {
            node.getChildren().remove(letter);
            return node.getChildren().isEmpty();
        }
        return false;
    }

    public static void main(String... args) {
        Trie trie = new Trie();
        trie.insert("Hello");
        trie.insert("Hell");
        System.out.println("Hell is in trie: " + trie.contains("Hell"));
        System.out.println("Hello is in trie: " + trie.contains("Hello"));

        System.out.println("MISSING is in trie:" + trie.contains("MISSING"));
        System.out.println("Hell is not prefix in trie: " + trie.isPrefix("Hell"));
        trie.delete("Hell");
        System.out.println("Hell is not in trie: " + trie.contains("Hell"));
    }
}
