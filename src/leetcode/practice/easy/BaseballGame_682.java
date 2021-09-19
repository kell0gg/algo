package leetcode.practice.easy;

import java.util.Stack;

public class BaseballGame_682 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.calPoints(new String[] { "5", "-2", "4", "C", "D", "9", "+", "+" });

	}
}

class Solution {
	public int calPoints(String[] ops) {
		int total = 0;
		Stack<Integer> stack = new Stack<>();

		for (String o : ops) {
			if (o.equals("C") || o.equals("D") || o.equals("+")) {
				if (o.equals("C")) {
					stack.pop();
				}
				if (o.equals("D")) {
					int a = stack.pop();
					stack.add(a);
					stack.add(a * 2);
				}
				if (o.equals("+")) {
					int a = stack.pop();
					int b = stack.pop();
					int tmp = a + b;
					stack.add(b);
					stack.add(a);
					stack.add(tmp);
				}
			} else {
				try {
					int tmp = Integer.parseInt(o);
					stack.add(tmp);
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		}
		for (int s : stack) {
			total += s;
		}
		// System.out.println(total);
		return total;
	}
}