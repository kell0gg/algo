package programmers.level2._124_나라의_숫자;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(6);
	}
}

class Solution {
	public String solution(int n) {
		StringBuilder sb = new StringBuilder();
		do {
			int r = n % 3;
			if (r == 0) {
				r = 4;
				n--;
			}
			sb.append(r);
			n /= 3;
		} while (n != 0);

		return sb.reverse().toString();
	}
}
