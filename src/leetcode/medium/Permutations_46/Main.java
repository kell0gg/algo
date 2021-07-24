package leetcode.medium.Permutations_46;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.permute(new int[] { 1, 2, 3 });
	}
}

class Solution {
	List<List<Integer>> ANS;

	public List<List<Integer>> permute(int[] nums) {
		ANS = new ArrayList<>();
		List<Integer> candidate = new LinkedList<>();
		Deque<Integer> dq = new ArrayDeque<>();
		IntStream.range(0, nums.length).forEach(a -> candidate.add(nums[a]));
		dfs(dq, candidate);
		return ANS;
	}

	private void dfs(Deque<Integer> dq, List<Integer> candidate) {
		if (candidate.size() == 0) {
			List<Integer> _tmp = new ArrayList<>();
			dq.forEach(a -> {
				_tmp.add(a);
			});
			ANS.add(_tmp);
			return;
		}

		for (int i = 0; i < candidate.size(); i++) {
			int _tmp = candidate.remove(i);
			dq.addLast(_tmp);
			dfs(dq, candidate);
			dq.pollLast();
			candidate.add(i, _tmp);
		}
	}
}