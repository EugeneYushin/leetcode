package algo;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Trie {
    public static void main(String[] args) {
        SortedSet<String> set = new TreeSet<>();
        set.add("am");
        set.add("hack_z");
        set.add("hack");
        set.add("pm");
        set.add("hack_x");
        set.add("adam");
        set.add("hack_y");

        SortedSet<String> tail = set.tailSet("hac");
        System.out.println("tail = " + tail);

        // TODO filter and compare with prefix
        List<String> first3 = tail.stream().limit(3).collect(Collectors.toList());
        System.out.println("first3 = " + first3);
    }
}

//class TrieNode {
//    Character ch;
//    boolean isLeaf;
//    Map<Character, TrieNode> children;
//
//    public TrieNode() {
//        this.children = new HashMap<>();
//        this.isLeaf = false;
//    }
//
//    public TrieNode(Character ch) {
//        this.ch = ch;
//        this.children = new HashMap<>();
//        this.isLeaf = false;
//    }
//}
//
//class Trie {
//    TrieNode root = new TrieNode();
//
//    public void insert(String word) {
//        TrieNode current = root;
//        for (Character letter : word.toCharArray()) {
//            current = current.children.computeIfAbsent(letter, l -> new TrieNode(l));
//        }
//        current.isLeaf = true;
//    }
//
//    public List<String> find(String prefix) {
//        TrieNode prefixNode = root;
//        List<String> result = new LinkedList<>();
//
//        for (Character l : prefix.toCharArray()) {
//            prefixNode = prefixNode.children.get(l);
//            if (prefixNode == null) return Collections.emptyList();
//        }
//
//        findInner(prefix.substring(0, prefix.length() - 1), prefixNode, result);
//        return result;
//    }
//
//    private void findInner (String prefix, TrieNode node, List<String> words) {
//        if (node.isLeaf) words.add(prefix + node.ch);
//        node.children.values().forEach(child -> findInner(prefix + node.ch, child, words));
//    }
//}
//
//class Main {
//    public static void main(String[] args) {
//        Trie prefixTrie = new Trie();
//        prefixTrie.insert("Hello");
//        prefixTrie.insert("Hell");
//        prefixTrie.insert("Hi");
//
//        List<String> words = prefixTrie.find("He");
//        System.out.println("words = " + words);
//
//        System.out.println("");
//    }
//}
