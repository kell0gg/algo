package programmers.level2.게임_맵_최단거리;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) {
		int[][] maps = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 1 } };

		Solution solution = new Solution();
		int tmp = solution.solution(maps);
		System.out.println(tmp);
	}
}

class Solution {
	private static int R, C;
	private static final int[][] DIR = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public int solution(int[][] maps) {
		R = maps.length;
		C = maps[0].length;

		return bfs(0, 0, maps);
	}

	private int bfs(int r, int c, int[][] maps) {
		Deque<Node> q = new ArrayDeque<>();
		q.addLast(new Node(r, c, 1));
		int[][] distMap = makeMap(maps);
		distMap[r][c] = 1;

		while (!q.isEmpty()) {
			Node tmp = q.pollFirst();
			if (tmp.r == R - 1 && tmp.c == C - 1) {
				return distMap[R - 1][C - 1];
			}

			for (int i = 0; i < 4; i++) {
				int nr = tmp.r + DIR[i][0];
				int nc = tmp.c + DIR[i][1];

				if (nr < 0 || nc < 0 || nr >= R || nc >= C || maps[nr][nc] == 0) {
					continue;
				}

				if (maps[nr][nc] == 1 || tmp.value < maps[nr][nc]) {
					int current = tmp.value + 1;
					if (distMap[nr][nc] > current) {
						distMap[nr][nc] = current;
						q.addLast(new Node(nr, nc, current));
					}
				}
			}
		}

		// printMap(distMap);

		return -1;
	}

	private void printMap(int[][] maps) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.printf("%5d ", maps[i][j]);
			}
			System.out.println();
		}
	}

	private int[][] makeMap(int[][] maps) {
		int[][] distMap = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				distMap[i][j] = Integer.MAX_VALUE;
			}
		}
		return distMap;
	}
}

class Node {
	int r, c, value;

	public Node(int r, int c, int value) {
		this.r = r;
		this.c = c;
		this.value = value;
	}
}