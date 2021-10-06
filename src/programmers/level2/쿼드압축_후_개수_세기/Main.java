package programmers.level2.쿼드압축_후_개수_세기;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] arr = new int[][] { { 1, 1, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 } };
		solution.solution(arr);
	}
}

class Solution {
	public int[] solution(int[][] arr) {
		split(arr, 0, 0, arr.length);

		int zeroCount = 0, oneCount = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i][j] == 0) {
					zeroCount++;
				} else if (arr[i][j] == 1) {
					oneCount++;
				} else {
					// pass
				}
			}
		}

		return new int[] { zeroCount, oneCount };
	}

	private void split(int[][] arr, int startRow, int startCol, int size) {
		if (size <= 1) {
			return;
		}

		compact(arr, startRow, startCol, size);

		int tmpSize = size / 2;

		split(arr, startRow, startCol, tmpSize);
		split(arr, startRow + tmpSize, startCol, tmpSize);
		split(arr, startRow, startCol + tmpSize, tmpSize);
		split(arr, startRow + tmpSize, startCol + tmpSize, tmpSize);
	}

	private void compact(int[][] arr, int row, int col, int size) {
		int current = arr[row][col];
		if (current == -1 || current == -2) {
			return;
		}
		boolean flag = true;

		for (int i = row; i < row + size; i++) {
			for (int j = col; j < col + size; j++) {
				if (arr[i][j] != current) {
					flag = false;
					break;
				}
			}
		}

		if (flag) {
			int tmp = -1;
			for (int i = row; i < row + size; i++) {
				for (int j = col; j < col + size; j++) {
					arr[i][j] = tmp;
				}
			}
			arr[row][col] = current;
		}
		return;
	}
}