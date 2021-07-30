package programmers.level1.약수의_개수와_덧셈;

public class Main {
	public static void main(String[] args) {
	}
}

class Solution {
	public int solution(int left, int right) {
		int answer = 0;

		for (int i = left; i <= right; i++) {
			if (getNum(i)) {
				answer += i;
			} else {
				answer -= i;
			}
		}
		return answer;
	}

	private boolean getNum(int n) {
		int tmp = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				tmp++;
			}
		}
		return tmp % 2 == 0 ? true : false;
	}
}