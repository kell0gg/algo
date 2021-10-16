package programmers.weekly._9주차;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();

		int n = 6;
		int[][] wires = new int[][] { { 1, 4 }, { 6, 3 }, { 2, 5 }, { 5, 1 }, { 5, 3 } };

		solution.solution(n, wires);
	}
}

class Solution {
	public int solution(int n, int[][] wires) {
		int answer = Integer.MAX_VALUE;

		Map<Integer, List<Integer>> graph = new HashMap<>();

		for (int[] wire : wires) {
			int src = wire[0];
			int dst = wire[1];

			graph.computeIfAbsent(src, v -> new ArrayList<>()).add(dst);
			graph.computeIfAbsent(dst, v -> new ArrayList<>()).add(src);
		}

		for (int[] wire : wires) {
			Set<Integer> visited = new HashSet<>();
			visited.add(wire[0]);
			visited.add(wire[1]);

			int a = bfs(graph, visited, wire[0]);
			int b = bfs(graph, visited, wire[1]);

			answer = Math.min(answer, Math.abs(a - b));
		}

		System.out.println(answer);

		return answer;
	}

	private int bfs(Map<Integer, List<Integer>> graph, Set<Integer> visited, int src) {
		Deque<Integer> q = new ArrayDeque<>();
		q.addLast(src);
		visited.add(src);
		Set<Integer> v = new HashSet<>();
		visited.forEach(a -> v.add(a));
		int count = 1;

		while (!q.isEmpty()) {
			int next = q.pollFirst();

			List<Integer> connected = graph.get(next);

			for (int c : connected) {
				if (!visited.contains(c)) {
					count++;
					q.addLast(c);
					visited.add(c);
				}
			}
		}
		return count;
	}
}
