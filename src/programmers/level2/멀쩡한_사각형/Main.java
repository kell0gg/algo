package programmers.level2.멀쩡한_사각형;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		long tmp = solution.solution(8, 12);
		System.out.println(tmp);
	}
}

class Solution {
	public long solution(int w, int h) {
		// 1. w*h
		// 2. (w/gcd + h/gcd - 1) * gcd
		// 3. w + h - gcd
		// 4. w*h - (w+h-gcd)
		return (long) w * h - ((w + h - gcd(w, h)));
	}

	private int gcd(int a, int b) {
		int min = Math.min(a, b);
		int max = Math.max(a, b);

		while (min != 0) {
			int remains = max % min;
			max = min;
			min = remains;
		}
		return max;
	}
}