package programmers.level1.자릿수_더하기;

public class Main {
	public static void main(String... args) {

	}
}

class Solution {
	public int solution(int n) {
		int answer = 0;

		while (n != 0) {
			int remains = n % 10;

			answer += remains;

			n = n / 10;
		}

		return answer;
	}
}