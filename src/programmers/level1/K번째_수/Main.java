package programmers.level1.K번째_수;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(new int[] { 1, 5, 2, 6, 3, 7, 4 }, new int[][] { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } });
	}
}

class Solution {
	public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		int index = 0;

		for (int i = 0; i < commands.length; i++) {
			int src = commands[i][0] - 1;
			int dst = commands[i][1];
			int k = commands[i][2] - 1;
			int[] arr = Arrays.copyOfRange(array, src, dst);
			Arrays.sort(arr);
			answer[index++] = arr[k];
		}
		return answer;
	}
}