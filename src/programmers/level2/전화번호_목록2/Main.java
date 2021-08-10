package programmers.level2.전화번호_목록2;

import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		boolean a = solution.solution(new String[] { "119", "456" });
		System.out.println(a);
	}
}

class Solution {
	public boolean solution(String[] phone_book) {
		Trie trie = new Trie();

		for (String p : phone_book) {
			trie.insert(p);
		}

		for (String p : phone_book) {
			if (trie.startsWith(p)) {
				return false;
			}
		}

		return true;
	}
}

class Trie {
	private static class Node {
		Map<Character, Node> child;
		boolean isEnd;

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

	public boolean startsWith(String prefix) {
		Node current = root;
		for (int i = 0; i < prefix.length(); i++) {
			if (current.child.containsKey(prefix.charAt(i))) {
				current = current.child.get(prefix.charAt(i));
			} else {
				return false;
			}
		}

		int count = current.child.size();
		if (current.isEnd) {
			count++;
		}

		return count >= 2;
	}
}
