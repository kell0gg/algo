package programmers.level2.소수_찾기;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution("011");
	}
}

class Solution {
	private static Set<Integer> ANSWER = new HashSet<>();

	public int solution(String numbers) {
		ANSWER = new HashSet<>();

		for (int i = 1; i <= numbers.length(); i++) {
			Deque<Integer> q = new ArrayDeque<>();
			combine(q, numbers.length(), i, 0, numbers);
		}
		return ANSWER.size();
	}

	private void combine(Deque<Integer> q, int n, int k, int depth, String numbers) {
		if (q.size() == k) {
			List<Integer> list = new ArrayList<>();
			q.forEach(i -> {
				list.add(numbers.charAt(i) - '0');
			});

			Deque<Integer> tmpQ = new ArrayDeque<>();
			permute(tmpQ, list);
			return;
		}

		for (int i = depth; i < n; i++) {
			q.addLast(i);
			combine(q, n, k, i + 1, numbers);
			q.pollLast();
		}
	}

	private void permute(Deque<Integer> q, List<Integer> list) {
		if (list.size() == 0) {
			StringBuilder sb = new StringBuilder();
			q.forEach(a -> {
				sb.append(a);
			});
			int tmp = Integer.parseInt(sb.toString());
			if (isPrime(tmp)) {
				ANSWER.add(tmp);
			}
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			int tmp = list.remove(i);
			q.addLast(tmp);
			permute(q, list);
			list.add(i, tmp);
			q.pollLast();
		}
	}

	private boolean isPrime(int number) {
		if (number == 0 || number == 1) {
			return false;
		}
		for (int i = 2; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}