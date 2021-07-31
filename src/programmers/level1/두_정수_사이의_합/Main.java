package programmers.level1.두_정수_사이의_합;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		long c = solution.solution(10000000, 0);
		System.out.println(c);
	}
}

class Solution {
	public long solution(int a, int b) {
		int start = Math.min(a, b);
		int end = Math.max(a, b);
		long sum = 0;
		for (int i = start; i <= end; i++) {
			sum += i;
		}
		return sum;
	}
}
