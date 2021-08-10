package leetcode.medium.Implement_Trie_208_withHash;

import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Trie trie = new Trie();
		trie.insert("apple");
		boolean a = trie.search("apple");
		System.out.println(a);
	}
}

class Trie {
	private static class Node {
		Map<Character, Node> child;
		boolean isEnd = false;

		public Node() {
			this.child = new HashMap<>();
		}
	}

	private final Node root;

	public Trie() {
		this.root = new Node();
	}

	public void insert(String word) {
		Node current = root;
		for (int i = 0; i < word.length(); i++) {
			current.child.putIfAbsent(word.charAt(i), new Node());
			current = current.child.get(word.charAt(i));
		}
		current.isEnd = true;
	}

	public boolean search(String word) {
		Node current = root;
		for (int i = 0; i < word.length(); i++) {
			if (current.child.containsKey(word.charAt(i))) {
				current = current.child.get(word.charAt(i));
			} else {
				return false;
			}
		}
		return current.isEnd;
	}

	public boolean startsWith(String prefix) {
		Node current = root;
		for (int i = 0; i < prefix.length(); i++) {
			if (current.child.containsKey(prefix.charAt(i))) {
				current = current.child.get(prefix.charAt(i));
			} else {
				return false;
			}
		}
		return true;
	}
}
