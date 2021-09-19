package leetcode.medium.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
	}
}

class Solution {
	List<List<Integer>> ANSWER;

	public List<List<Integer>> combine(int n, int k) {
		ANSWER = new ArrayList<>();
		Deque<Integer> q = new ArrayDeque<>();
		List<Integer> candidate = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			candidate.add(i);
		}

		dfs(q, 0, candidate, k);
		return ANSWER;
	}

	private void dfs(Deque<Integer> q, int currentDepth, List<Integer> candidate, int k) {
		if (q.size() == k) {
			List<Integer> tmp = new ArrayList<>();
			q.forEach(a -> {
				tmp.add(a);
			});
			ANSWER.add(tmp);
			return;
		}

		for (int i = currentDepth; i < candidate.size(); i++) {
			q.addLast(candidate.get(i));
			dfs(q, i+1, candidate, k);
			q.pollLast();
		}
	}
}