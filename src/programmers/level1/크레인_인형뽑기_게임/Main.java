package programmers.level1.크레인_인형뽑기_게임;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		Solution solution = new Solution();
		int size = solution.solution(board, moves);
		System.out.println(size);
	}
}

class Solution {
	public int solution(int[][] board, int[] moves) {
		List<Deque<Integer>> list = new ArrayList<>();
		Deque<Integer> dolls = new ArrayDeque<>();
		int sum = 0;
		for (int i = 0; i < board.length; i++) {
			list.add(new ArrayDeque<>());
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[j][i] != 0) {
					list.get(i).addLast(board[j][i]);
				}
			}
		}

		for (int i = 0; i < moves.length; i++) {
			int p = moves[i] - 1;

			if (list.get(p).size() >= 1) {
				int d = list.get(p).pollFirst();
				sum++;
				if (dolls.size() == 0) {
					dolls.addLast(d);
				} else if (dolls.peekLast() == d) {
					dolls.pollLast();
				} else {
					dolls.addLast(d);
				}
			}
		}
		return sum - dolls.size();
	}
}