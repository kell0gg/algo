package leetcode.medium.Implement_Trie_208;

public class Main {
	public static void main(String[] args) {

	}
}

class Trie {
	private static class Node {
		Node[] child;
		boolean isEnd;

		Node() {
			child = new Node[26];
		}
	}

	private final Node root;

	/** Initialize your data structure here. */
	public Trie() {
		root = new Node();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		Node current = root;
		for (char c : word.toCharArray()) {
			if (current.child[c - 'a'] == null) {
				current.child[c - 'a'] = new Node();
			}
			current = current.child[c - 'a'];
		}
		current.isEnd = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		Node current = root;
		for (char c : word.toCharArray()) {
			if (current.child[c - 'a'] != null) {
				current = current.child[c - 'a'];
			} else {
				return false;
			}
		}
		return current.isEnd;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		Node current = root;
		for (char c : prefix.toCharArray()) {
			if (current.child[c - 'a'] != null) {
				current = current.child[c - 'a'];
			} else {
				return false;
			}
		}
		return true;
	}
}
