package programmers.level2.거리두기_확인하기;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(new String[][] { { "POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP" },
				{ "POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP" }, { "PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX" },
				{ "OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO" }, { "PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP" } });
	}
}

class Solution {
	private static int ROW = 5;
	private static int COL = 5;
	private static int[][] DIR = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public int[] solution(String[][] places) {
		int[] answer = new int[ROW];
		ROW = 5;
		COL = 5;

		int idx = 0;
		for (String[] place : places) {
			int[][] map = parseMap(place);

			if (check(map)) {
				answer[idx] = 1;
			} else {
				answer[idx] = 0;
			}

			idx++;
		}

		return answer;
	}

	private boolean check(int[][] map) {
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				if (map[i][j] == 1) {
					if (!bfs(map, i, j)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	private int[][] parseMap(String place[]) {
		int[][] map = new int[ROW][COL];
		for (int i = 0; i < place.length; i++) {
			for (int j = 0; j < place[i].length(); j++) {
				if (place[i].charAt(j) == 'O') {
					map[i][j] = 0;
				}
				if (place[i].charAt(j) == 'P') {
					map[i][j] = 1;
				}
				if (place[i].charAt(j) == 'X') {
					map[i][j] = 2;
				}
			}
		}

		return map;
	}

	// 0 - blank
	// 1 - people
	// 2 - partition
	private boolean bfs(int[][] map, int r, int c) {
		Deque<Node> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[ROW][COL];
		visited[r][c] = true;
		q.addLast(new Node(r, c, 0));

		while (!q.isEmpty()) {
			Node tmp = q.pollFirst();

			if (tmp.d >= 2) {
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nr = tmp.r + DIR[i][0];
				int nc = tmp.c + DIR[i][1];

				if (nr >= ROW || nc >= COL || nr < 0 || nc < 0) {
					continue;
				}

				if (visited[nr][nc]) {
					continue;
				}

				if (map[nr][nc] == 2) {
					continue;
				}

				if (map[nr][nc] == 0) {
					visited[nr][nc] = true;
					q.addLast(new Node(nr, nc, tmp.d + 1));
				}

				if (map[nr][nc] == 1) {
					if (tmp.d <= 2) {
						return false;
					}
				}
			}
		}
		return true;
	}
}

class Node {
	int r, c, d;

	public Node(int r, int c, int d) {
		this.r = r;
		this.c = c;
		this.d = d;
	}
}