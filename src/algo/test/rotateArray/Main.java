package algo.test.rotateArray;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(6, 6);
	}
}

class Solution {
	public void solution(int rows, int columns) {
		int[][] map = makeMap(rows, columns);
		printMap(map);
		System.out.println("=====================");
		// rotateBorderClockwire(map, 0, 0, 5, 5);
		rotateBorderCounterClockwire(map, 0, 0, 5, 5);
		printMap(map);
	}

	private void rotateBorderClockwire(int[][] map, int startRow, int startCol, int endRow, int endCol) {
		// 상, 좌, 하, 우

		int tmp = map[startRow][startCol];

		for (int i = startRow; i < endRow; i++) {
			map[i][startCol] = map[i + 1][startCol];
		}
		for (int i = startCol; i < endCol; i++) {
			map[endRow][i] = map[endRow][i + 1];
		}
		for (int i = endRow; i > startRow; i--) {
			map[i][endCol] = map[i - 1][endCol];
		}
		for (int i = endCol; i > startCol + 1; i--) {
			map[startRow][i] = map[startRow][i - 1];
		}

		map[startRow][startCol + 1] = tmp;
	}

	private void rotateBorderCounterClockwire(int[][] map, int startRow, int startCol, int endRow, int endCol) {
		// 하, 좌, 상, 우

		int tmp = map[endRow][startCol];

		for (int i = endRow; i > startRow; i--) {
			map[i][startCol] = map[i - 1][startCol];
		}
		for (int i = startCol; i < endCol; i++) {
			map[startRow][i] = map[startRow][i + 1];
		}
		for (int i = startRow; i < endRow; i++) {
			map[i][endCol] = map[i + 1][endCol];
		}
		for (int i = endCol; i > startCol + 1; i--) {
			map[endRow][i] = map[endRow][i - 1];
		}

		map[endRow][startCol + 1] = tmp;
	}

	private int[][] makeMap(int rows, int columns) {
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= rows * columns; i++) {
			q.addLast(i);
		}
		int[][] map = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				map[i][j] = q.pollFirst();
			}
		}
		return map;
	}

	private void printMap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.printf("%3d ", map[i][j]);
			}
			System.out.println();
		}
	}
}