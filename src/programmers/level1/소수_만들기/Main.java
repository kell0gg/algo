package programmers.level1.소수_만들기;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) {

	}
}

class Solution {
	private static int ANS = 0;

	public int solution(int[] nums) {
		ANS = 0;
		Deque<Integer> dq = new ArrayDeque<>();
		dfs(dq, nums, 0, nums.length, 3);

		return ANS;
	}

	private void dfs(Deque<Integer> dq, int[] nums, int depth, int n, int k) {
		if (dq.size() == k) {
			StringBuilder sb = new StringBuilder();
			int num = dq.stream().mapToInt(a -> nums[a]).sum();
			if (isPrime(num)) {
				ANS++;
			}
			return;
		}

		for (int i = depth; i < n; i++) {
			dq.addLast(i);
			dfs(dq, nums, i + 1, n, k);
			dq.pollLast();
		}
	}

	private boolean isPrime(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
