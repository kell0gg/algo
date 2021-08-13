package programmers.level1.행렬_테두리_회전하기;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(6, 6, new int[][] { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } });
	}
}

class Solution {
	public int[] solution(int rows, int columns, int[][] queries) {
		int[] answer = new int[queries.length];
		int[][] map = makeMap(rows, columns);
		for (int i = 0; i < queries.length; i++) {
			int tmp = rotateMap(map, queries[i][0] - 1, queries[i][1] - 1, queries[i][2] - 1, queries[i][3] - 1);
			answer[i] = tmp;
			System.out.println(tmp);
			// printMap(map);
		}
		return answer;
	}

	private void printMap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.printf("%3d ", map[i][j]);
			}
			System.out.println();
		}
	}

	private int rotateMap(int[][] map, int startRow, int startCol, int endRow, int endCol) {
		int tmp = map[startRow][startCol];
		int min = tmp;

		for (int i = startRow; i < endRow; i++) {
			map[i][startCol] = map[i + 1][startCol];
			min = Math.min(min, map[i][startCol]);
		}
		for (int i = startCol; i < endCol; i++) {
			map[endRow][i] = map[endRow][i + 1];
			min = Math.min(min, map[endRow][i]);
		}
		for (int i = endRow; i > startRow; i--) {
			map[i][endCol] = map[i - 1][endCol];
			min = Math.min(min, map[i][endCol]);
		}
		for (int i = endCol; i > startCol + 1; i--) {
			map[startRow][i] = map[startRow][i - 1];
			min = Math.min(min, map[startRow][i]);
		}

		map[startRow][startCol + 1] = tmp;

		return min;
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
}