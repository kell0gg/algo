package programmers.weekly._2주차;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(new int[][] { { 100, 90, 98, 88, 65 }, { 50, 45, 99, 85, 77 }, { 47, 88, 95, 80, 67 },
				{ 61, 57, 100, 80, 65 }, { 24, 90, 94, 75, 65 } });
	}
}

class Solution {
	public String solution(int[][] scores) {
		StringBuilder sb = new StringBuilder();
		for (int col = 0; col < scores[0].length; col++) {
			int min = 101;
			int max = -1;
			int self = -1;
			int sum = 0;
			float avg = 0;

			int count = 0;
			for (int row = 0; row < scores.length; row++) {
				min = Math.min(min, scores[row][col]);
				max = Math.max(max, scores[row][col]);
				sum += scores[row][col];
				if (row == col) {
					self = scores[row][col];
				}
			}

			for (int row = 0; row < scores.length; row++) {
				if (self == scores[row][col]) {
					count++;
				}
			}

			if (count >= 2) {
				avg = (float) sum / (scores.length);
			} else {
				if (self == min || self == max) {
					sum -= self;
					avg = (float) sum / (scores.length - 1);
				} else {
					avg = (float) sum / (scores.length);
				}
			}

			sb.append(mappingScore(avg));
		}

		// System.out.println(sb.toString());
		return sb.toString();
	}

	private char mappingScore(float avg) {
		if (avg >= 90) {
			return 'A';
		}
		if (avg >= 80 && avg < 90) {
			return 'B';
		}
		if (avg >= 70 && avg < 80) {
			return 'C';
		}
		if (avg >= 50 && avg < 70) {
			return 'D';
		}
		if (avg < 50) {
			return 'F';
		}
		return 'X';

	}
}