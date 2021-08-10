package programmers.level2.전화번호_목록;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		boolean a = solution.solution(new String[] { "0", "00" });
		System.out.println(a);
	}
}

class Solution {
	public boolean solution(String[] phone_book) {
		Trie trie = new Trie();

		for (String p : phone_book) {
			trie.inert(p);
		}

		for (String p : phone_book) {
			if (trie.startWith(p)) {
				return false;
			}
		}

		return true;
	}
}

class Trie {
	private static class Node {
		Node[] child;
		boolean isEnd;

		Node() {
			child = new Node[10];
		}
	}

	private final Node root;

	public Trie() {
		root = new Node();
	}

	public void inert(String word) {
		Node current = root;
		for (char c : word.toCharArray()) {
			if (current.child[c - '0'] == null) {
				current.child[c - '0'] = new Node();
			}
			current = current.child[c - '0'];
		}
		current.isEnd = true;
	}

	public boolean startWith(String prefix) {
		Node current = root;
		for (char c : prefix.toCharArray()) {
			if (current.child[c - '0'] != null) {
				current = current.child[c - '0'];

			} else {
				return false;
			}
		}

		int count = 0;
		for (int i = 0; i < 10; i++) {
			if (current.child[i] != null) {
				count++;
			}
		}
		if (current.isEnd) {
			count++;
		}

		return count >= 2;
	}
}