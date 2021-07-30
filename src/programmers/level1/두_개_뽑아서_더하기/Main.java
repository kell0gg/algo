package programmers.level1.두_개_뽑아서_더하기;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(new int[] { 2, 1, 3, 4, 1 });
	}
}

class Solution {
	private static Set<Integer> SET;

	public int[] solution(int[] numbers) {
		SET = new HashSet<>();
		Deque<Integer> dq = new ArrayDeque<>();
		combination(numbers, numbers.length, 2, dq, 1);

		List<Integer> lists = new ArrayList<>(SET);
		Collections.sort(lists, (a, b) -> a - b);

		return lists.stream().mapToInt(a -> a).toArray();
	}

	private void combination(int[] numbers, int n, int k, Deque<Integer> dq, int depth) {
		if (dq.size() == k) {
			SET.add(dq.stream().mapToInt(a -> a).reduce(0, (b, c) -> b + c));
			return;
		}

		for (int i = depth; i <= n; i++) {
			dq.addLast(numbers[i - 1]);
			combination(numbers, n, k, dq, i + 1);
			dq.pollLast();
		}
	}
}
