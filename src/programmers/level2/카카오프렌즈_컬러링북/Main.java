package programmers.level2.카카오프렌즈_컬러링북;

import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] picture = { { 1, 1, 1, 0 }, { 1, 1, 1, 0 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 },
				{ 0, 0, 0, 1 } };
		int[] tmp = solution.solution(6, 4, picture);
		for (int i : tmp) {
			System.out.println(i);
		}
	}
}

class Solution {
	private static final int[][] DIR = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		int[] answer = new int[2];
		int[][] copiedPicture = new int[m][n];

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				copiedPicture[i][j] = picture[i][j];
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (copiedPicture[i][j] == 0) {
					continue;
				} else {
					if (copiedPicture[i][j] != -1) {
						numberOfArea++;
						maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, m, n, copiedPicture));
					}
				}
			}
		}

		answer[0] = numberOfArea;
		answer[1] = maxSizeOfOneArea;

		return answer;
	}

	private int bfs(int r, int c, int mr, int mc, int[][] picture) {
		Deque<Node> q = new ArrayDeque<>();
		q.addLast(new Node(r, c));
		int color = picture[r][c];
		picture[r][c] = -1;
		int count = 1;

		while (!q.isEmpty()) {
			Node tmp = q.pollFirst();

			for (int i = 0; i < 4; i++) {
				int nr = tmp.r + DIR[i][0];
				int nc = tmp.c + DIR[i][1];

				if (nr >= mr || nc >= mc || nr < 0 || nc < 0) {
					continue;
				}

				if (picture[nr][nc] == color) {
					picture[nr][nc] = -1;
					count++;
					q.addLast(new Node(nr, nc));
				}
			}
		}
		return count;
	}
}

class Node {
	int r, c;

	public Node(int r, int c) {
		this.r = r;
		this.c = c;
	}
}