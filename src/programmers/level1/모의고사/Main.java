package programmers.level1.모의고사;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] test = solution.solution(new int[] { 1, 3, 2, 4, 2 });
		for (int i : test) {
			System.out.println(i);
		}
	}
}

class Solution {
	private static int[] S1 = { 1, 2, 3, 4, 5 };
	private static int[] S2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
	private static int[] S3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

	public int[] solution(int[] answers) {
		List<Integer> list = new ArrayList<>();
		int[] a = new int[3];
		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == S1[i % S1.length]) {
				a[0]++;
			}
			if (answers[i] == S2[i % S2.length]) {
				a[1]++;
			}
			if (answers[i] == S3[i % S3.length]) {
				a[2]++;
			}
		}
		int max = Math.max(Math.max(a[0], a[1]), a[2]);
		for (int i = 0; i < 3; i++) {
			if (a[i] == max) {
				list.add(i + 1);
			}
		}
		return list.stream().mapToInt(v -> v).toArray();
	}
}