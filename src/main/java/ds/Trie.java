package ds;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.function.Function;

public class Trie {

    private Node root;

    class Node {
        private final Map<Character, Node> children = new HashMap<>();
        private Boolean word = false;
        private boolean Visited = false;
        public Character c;

        public boolean isWord() {
            return word;
        }

        public void setWord(boolean word) {
            this.word = word;
        }

        public Map<Character, Node> getChildren() {
            return children;
        }

        public boolean isVisited() {
            return Visited;
        }

        public void setVisited(boolean visited) {
            Visited = visited;
        }
    }

    public Trie() {
        this.root = new Node();
    }

    public void insert(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            final char letter = word.charAt(i);
            Function function = k -> {
                Node n = new Node();
                n.c = letter;
                return n;
            };

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

    public static void printTrie(Node node) {

        if (node == null || node.isVisited())
            return;

        LinkedList<Node> q = new LinkedList<Node>();

        System.out.println(node);
        node.setVisited(true);
        q.add(node);

        while (!q.isEmpty()) {
            Node x = q.removeFirst();
            for (Map.Entry<Character, Node> i : x.getChildren().entrySet()) {
                if (i.getValue().isVisited() == false) {
                    System.out.println(i);
                    i.getValue().setVisited(true);
                    q.add(i.getValue());
                }
            }
        }
    }

    public static void printTrie(Node node, int offset) {
        // here you can play with the order of the children
        String tabs = "";
        int numTabs = offset;
        for (int i = 0; i < numTabs; i++)
            tabs += "\t";
        for (Map.Entry<Character, Node> child : node.getChildren().entrySet()) {
            System.out.println(tabs + "" + child.getKey());
            printTrie(child.getValue(), offset + 2);
        }
    }

    public static void print(Node rootNode, int level, StringBuilder sequence) {
        Map<Character, Node> children = rootNode.getChildren();
        Iterator<Character> iterator = children.keySet().iterator();
        while (iterator.hasNext()) {
            char character = iterator.next();
            sequence.insert(level, character);
            if (children.get(character).isWord()) {
                System.out.println(sequence);
            }
            print(children.get(character), level + 1, sequence);
            sequence.deleteCharAt(level);
        }
    }

    public static void main(String... args) {
        Trie trie = new Trie();
        trie.insert("Hello");
        trie.insert("Hell");
        trie.insert("GodBless");
        //    System.out.println("Hell is in trie: " + trie.contains("Hell"));
        //    System.out.println("Hello is in trie: " + trie.contains("Hello"));

        //  System.out.println("MISSING is in trie:" + trie.contains("MISSING"));
        //   System.out.println("Hell is not prefix in trie: " + trie.isPrefix("Hell"));
        //  trie.delete("Hell");
        //  System.out.println("Hell is not in trie: " + trie.contains("Hell"));
        Trie.print(trie.root, 0, new StringBuilder(""));
    }
}
