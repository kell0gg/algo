package programmers.level2.짝지어_제거하기;

import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int tmp = solution.solution("cdcd");
		System.out.println(tmp);
	}
}

class Solution {
	public int solution(String s) {
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			int next = s.charAt(i) - '0';
			if (stack.size() > 0) {
				int tmp = stack.peek();
				if (next == tmp) {
					stack.pop();
					continue;
				}
			}
			stack.add(s.charAt(i) - '0');
		}

		return stack.size() == 0 ? 1 : 0;
	}
}