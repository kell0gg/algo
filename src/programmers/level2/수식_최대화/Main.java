package programmers.level2.수식_최대화;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		long m = solution.solution("100-200*300-500+20");
		System.out.println(m);
	}
}

class Solution {
	private static List<Long> numbers = new ArrayList<>();
	private static List<Character> oplist = new ArrayList<>();
	private static char[] OPER = { '+', '*', '-' };
	private static long MAX = 0;

	public long solution(String expression) {
		MAX = 0;
		Deque<Integer> q = new ArrayDeque<>();
		List<Integer> candidates = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			candidates.add(i);
		}

		makeList(expression);
		permute(candidates, q, expression);
		return MAX;
	}

	private void permute(List<Integer> candidates, Deque<Integer> q, String expression) {
		if (candidates.size() == 0) {
			q.forEach(a -> {
				compute(expression, OPER[a]);
			});

			MAX = Math.max(MAX, Math.abs(numbers.get(0)));
			makeList(expression);

			return;
		}

		for (int i = 0; i < candidates.size(); i++) {
			int tmp = candidates.remove(i);
			q.addLast(tmp);
			permute(candidates, q, expression);
			q.pollLast();
			candidates.add(i, tmp);
		}
	}

	private void makeList(String expression) {
		String[] tmp = expression.split("\\*|\\-|\\+");
		numbers = new ArrayList<>();
		oplist = new ArrayList<>();

		for (String t : tmp) {
			numbers.add(Long.parseLong(t));
		}

		for (char c : expression.toCharArray()) {
			if (c == '*' || c == '-' || c == '+') {
				oplist.add(c);
			}
		}

	}

	private void compute(String expression, char operator) {
		for (int i = 0; i < oplist.size(); i++) {
			if (oplist.get(i) == operator) {
				oplist.remove(i);
				long a = numbers.remove(i);
				long b = numbers.remove(i);
				long c = 0;
				if (operator == '*') {
					c = a * b;
				}
				if (operator == '+') {
					c = a + b;
				}
				if (operator == '-') {
					c = a - b;
				}
				numbers.add(i, c);
				i--;
			}
		}
	}
}