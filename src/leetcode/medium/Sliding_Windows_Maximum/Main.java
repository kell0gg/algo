package leetcode.medium.Sliding_Windows_Maximum;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) {

	}
}

class Solution {
	public int[] maxSlidingWindowQ(int[] nums, int k) {
		int n = nums.length;
		int[] result = new int[n - k + 1];
		Deque<Integer> q = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			while (q.size() > 0 && q.peekFirst() <= i - k) {
				q.pollFirst();
			}

			while (q.size() > 0 && nums[q.peekLast()] < nums[i]) {
				q.pollLast();
			}

			q.addLast(i);

			if (i >= k - 1) {
				result[i - k + 1] = nums[q.peekFirst()];
			}
		}
		return result;
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		int n = nums.length;
		int[] result = new int[n - k + 1];

		int[] left = new int[n];
		int[] right = new int[n];

		for (int i = 0; i < n; i++) {
			if (i % k == 0) {
				left[i] = nums[i];
			} else {
				left[i] = Math.max(left[i - 1], nums[i]);
			}

			if (i == 0 || ((n - i) % k == 0)) {
				right[n - 1 - i] = nums[n - 1 - i];
			} else {
				right[n - 1 - i] = Math.max(right[n - i], nums[n - 1 - i]);
			}
		}

		for (int i = 0, j = k - 1; j < n; i++, j++) {
			result[i] = Math.max(left[j], right[i]);
		}

		return result;
	}
}