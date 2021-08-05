package programmers.level1.정수_제곱근_판별;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		long tmp = solution.solution(1L);
		System.out.println(tmp);
	}
}

class Solution {
	public long solution(long n) {
		return check(n);
	}

	private long check(long n) {
		for (long i = 1; i <= Math.sqrt(n); i++) {
			if (i * i == n) {
				return ((i + 1) * (i + 1));
			}
		}
		return -1;
	}
}