package programmers.level1.x만큽_간격이_있는_n개의_숫자;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(10000000, 1000);
	}
}

class Solution {
	public long[] solution(int x, int n) {
		long[] answer = new long[n];

		for (int i = 1; i <= n; i++) {
			answer[i - 1] = (long)x * i;
		}
		return answer;
	}
}