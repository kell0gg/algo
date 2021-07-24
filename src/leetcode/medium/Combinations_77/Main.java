package leetcode.medium.Combinations_77;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.combine(1, 1);
	}
}

class Solution {
	private static List<List<Integer>> ANS;

	public List<List<Integer>> combine(int n, int k) {
		ANS = new ArrayList<>();
		Deque<Integer> dq = new ArrayDeque<>();
		dfs(n, k, dq, 1);
		return ANS;
	}

	private void dfs(int n, int k, Deque<Integer> dq, int currentDepth) {
		if (dq.size() == k) {
			List<Integer> _tmp = new ArrayList<>();
			dq.forEach(a -> {
				_tmp.add(a);
			});
			ANS.add(_tmp);
			return;
		}

		for (int i = currentDepth; i <= n; i++) {
			dq.addLast(i);
			dfs(n, k, dq, i + 1);
			dq.pollLast();
		}
	}
}