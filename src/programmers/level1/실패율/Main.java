package programmers.level1.실패율;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	public static void main(String... args) {
		Solution solution = new Solution();
		int[] i = solution.solution(5, new int[] { 2, 1, 2, 6, 2, 4, 3, 3 });
		for (int t : i) {
			System.out.println(t);
		}

	}
}

class Solution {
	public int[] solution(int N, int[] stages) {
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			map.putIfAbsent(i, 0);
		}

		for (int stage : stages) {
			if (stage <= N) {
				map.put(stage, map.getOrDefault(stage, 0) + 1);
			}
		}

		List<Node> lists = new ArrayList<>();

		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			int a = (getSize(stages, e.getKey()));
			double b = 0;
			if (a != 0) {
				b = (double) e.getValue() / a;
			}
			lists.add(new Node(e.getKey(), b));
		}
		lists.sort((a, b) -> {
			if (Double.compare(b.rate, a.rate) == 0) {
				return a.index - b.index;
			} else {
				return Double.compare(b.rate, a.rate);
			}

		});

		return lists.stream().mapToInt(a -> a.index).toArray();
	}

	private int getSize(int[] stages, int n) {
		int sum = 0;
		for (int i = 0; i < stages.length; i++) {
			if (stages[i] >= n) {
				sum++;
			}
		}
		return sum;
	}
}

class Node {
	int index;
	double rate;

	public Node(int index, double rate) {
		this.index = index;
		this.rate = rate;
	}
}