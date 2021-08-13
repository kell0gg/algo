package programmers.level2.프린터;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) {
		int[] priorities = { 2, 1, 3, 2 };
		int location = 2;
		Solution solution = new Solution();
		solution.solution(priorities, location);
	}
}

class Solution {
	public int solution(int[] priorities, int location) {
		int answer = 1;

		Deque<Job> dq = new ArrayDeque<>();

		for (int i = 0; i < priorities.length; i++) {
			dq.addLast(new Job(i, priorities[i]));
		}

		while (!dq.isEmpty()) {
			Job tmp = dq.pollFirst();
			if (isPrintable(dq, tmp.prioritiy)) {
				if (tmp.idx == location) {
					return answer;
				} else {
					answer++;
				}
			} else {
				dq.addLast(tmp);
			}
		}

		return answer;
	}

	private boolean isPrintable(Deque<Job> dq, int target) {
		return !dq.stream().anyMatch(a -> {
			return a.prioritiy > target;
		});
	}
}

class Job {
	int idx, prioritiy;

	public Job(int idx, int prioritiy) {
		this.idx = idx;
		this.prioritiy = prioritiy;
	}
}