package programmers.level2.더_맵게;

import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int tmp = solution.solution(new int[] { 1, 2, 3, 9, 10, 12 }, 7);
		System.out.println(tmp);
	}
}

class Solution {
	public int solution(int[] scoville, int K) {
		PriorityQueue<Long> pq = new PriorityQueue<>();

		for (int i = 0; i < scoville.length; i++) {
			pq.add((long) scoville[i]);
		}

		int count = 0;
		while (pq.peek() < K) {
			if (pq.size() < 2) {
				return -1;
			}
			long m1 = pq.poll();
			long m2 = pq.poll();
			pq.add(m1 + (m2 * 2));
			count++;
		}
		return count;
	}
}