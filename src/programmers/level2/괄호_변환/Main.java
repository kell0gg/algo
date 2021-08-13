package programmers.level2.괄호_변환;

import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution("()))((()");
	}
}

class Solution {
	public String solution(String p) {
		if (p.length() == 0) {
			return p;
		}

		StringBuilder sb = new StringBuilder();

		int idx = isBalanced(p);
		String u = p.substring(0, idx);
		String v = p.substring(idx, p.length());

		if (isCorrect(u)) {
			return u + solution(v);
		} else {
			sb.append('(').append(solution(v)).append(')');
			for (int i = 1; i < u.length() - 1; i++) {
				if (u.charAt(i) == '(') {
					sb.append(')');
				} else {
					sb.append('(');
				}
			}
		}

		return sb.toString();
	}

	private int isBalanced(String p) {
		Stack<Character> stack = new Stack<>();
		int left = 0, right = 0;

		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(') {
				left++;
				stack.add('(');
			} else {
				right++;
				if (!stack.isEmpty()) {
					stack.pop();
				}
			}
			if (left == right) {
				return i + 1;
			}
		}
		return 0;
	}

	private boolean isCorrect(String p) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(') {
				stack.add('(');
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return true;
	}
}