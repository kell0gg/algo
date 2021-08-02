package programmers.level1.소수_찾기;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(10);
	}
}

class Solution {
	public int solution(int n) {
		int answer = 0;

		for (int i = 2; i <= n; i++) {
			if (isPrime(i)) {
				answer++;
			}
		}
		return answer;
	}

	private boolean isPrime(int n) {
		for (int i = 2; i <= (int) Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}