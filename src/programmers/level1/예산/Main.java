package programmers.level1.예산;

import java.util.Arrays;

public class Main {
	public static void main(String... args) {
		Solution solution = new Solution();
		solution.solution(new int[] { 1, 3, 2, 5, 4 }, 9);
	}
}

class Solution {
	private static int MAX = 0;

	public int solution(int[] d, int budget) {
		MAX = 0;

		Arrays.sort(d);
		int sum = 0;
		for (int i = 0; i < d.length; i++) {
			sum += d[i];
			if (sum > budget) {
				break;
			}
			MAX++;
		}
		return MAX;
	}
}