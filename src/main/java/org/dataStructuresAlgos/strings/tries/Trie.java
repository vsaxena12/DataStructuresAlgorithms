package org.dataStructuresAlgos.strings.tries;

import java.util.ArrayList;
import java.util.List;

class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }

    public void put(char ch, Node node) {
        links[ch-'a'] = node;
    }

    public Node get(char ch) {
        return links[ch-'a'];
    }

    public void setEnd() {
        flag = true;
    }

    public boolean isEnd() {
        return flag;
    }
}

public class Trie {

    private Node root;

    Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for(int i=0; i<word.length(); i++) {
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();

    }

    // Search for a word in the Trie
    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.containsKey(ch)) {
                return false; // Character not found
            }
            node = node.get(ch); // Move to the next node
        }
        return node.isEnd(); // Check if it is the end of a word
    }

    // Check if any word in the Trie starts with the given prefix
    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (!node.containsKey(ch)) {
                return false; // Prefix not found
            }
            node = node.get(ch); // Move to the next node
        }
        return true; // Prefix exists
    }

    // Helper method to collect all words in the Trie
    public List<String> getAllWords() {
        List<String> result = new ArrayList<>();
        dfs(root, new StringBuilder(), result);
        return result;
    }

    // DFS to extract all words
    private void dfs(Node node, StringBuilder currentWord, List<String> result) {
        if (node.isEnd()) {
            result.add(currentWord.toString()); // Add the completed word
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (node.containsKey(ch)) {
                currentWord.append(ch); // Add character to the current path
                dfs(node.get(ch), currentWord, result); // Recursively traverse child node
                currentWord.deleteCharAt(currentWord.length() - 1); // Backtrack
            }
        }
    }


    public static void main(String[] args){
        Trie trie = new Trie();

        // Insert words
        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");

        // Search words
        System.out.println("Search 'apple': " + trie.search("apple")); // true
        System.out.println("Search 'app': " + trie.search("app")); // true
        System.out.println("Search 'bat': " + trie.search("bat")); // true
        System.out.println("Search 'bad': " + trie.search("bad")); // false

        System.out.println();

        // Check prefixes
        System.out.println("Starts with 'app': " + trie.startsWith("app")); // true
        System.out.println("Starts with 'ba': " + trie.startsWith("ba")); // true
        System.out.println("Starts with 'batman': " + trie.startsWith("batman"));

        // Extract and print all words
        System.out.println("\nWords in the Trie:");
        List<String> words = trie.getAllWords();
        for (String word : words) {
            System.out.println(word);
        }
    }

}
