package leetcode.medium.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
	public static void main(String[] args) {

	}
}

class Solution {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> answer = new ArrayList<>();
		Deque<Integer> dq = new ArrayDeque<>();

		List<Integer> candidates = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			candidates.add(nums[i]);
		}

		permutation(candidates, dq, answer);

		return answer;
	}

	private void permutation(List<Integer> candidates, Deque<Integer> dq, List<List<Integer>> answer) {
		if (candidates.size() == 0) {
			List<Integer> tmp = new ArrayList<>();
			dq.forEach(v -> {
				tmp.add(v);
			});

			answer.add(tmp);
			return;
		}

		for (int i = 0; i < candidates.size(); i++) {
			dq.addLast(candidates.remove(i));
			permutation(candidates, dq, answer);
			candidates.add(i, dq.pollLast());
		}

	}
}