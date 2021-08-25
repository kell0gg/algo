package programmers.level2.후보키;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(new String[][] { { "100", "ryan", "music", "2" }, { "200", "apeach", "math", "2" },
				{ "300", "tube", "computer", "3" }, { "400", "con", "computer", "4" }, { "500", "muzi", "music", "3" },
				{ "600", "apeach", "music", "2" } });

	}
}

class Solution {
	private static Set<String> FK = new HashSet<>();
	private static char SEPERATE = '@';

	public int solution(String[][] relation) {
		FK = new HashSet<>();
		Deque<Integer> columns = new ArrayDeque<>();

		for (int i = 1; i <= relation[0].length; i++) {
			combination(relation, columns, relation[0].length, i, 0);
		}

		return FK.size();
	}

	private void combination(String[][] relation, Deque<Integer> columns, int n, int k, int depth) {
		if (columns.size() == k) {
			unique(relation, columns);
//			if (unique(relation, columns)) {
//				columns.forEach(val -> {
//					System.out.print(val + " ");
//				});
//				System.out.println();
//			}
			return;
		}

		for (int i = depth; i < n; i++) {
			columns.addLast(i);
			combination(relation, columns, n, k, i + 1);
			columns.pollLast();
		}
	}

	private boolean minimal(String candidate) {
		Set<Character> candidateSet = new HashSet<>();
		for (char t : candidate.toCharArray()) {
			candidateSet.add(t);
		}
		for (String fk : FK) {
			Set<Character> set = new HashSet<>();
			for (char t : fk.toCharArray()) {
				set.add(t);
			}
			if (candidateSet.containsAll(set)) {
				return false;
			}
		}
		FK.add(candidate);
		return true;
	}

	private boolean unique(String[][] relation, Deque<Integer> columns) {

		StringBuilder candidate = new StringBuilder();
		List<Integer> pickedList = new ArrayList<>();
		columns.forEach(val -> {
			pickedList.add(val);
			candidate.append(val);
		});

		Set<String> set = new HashSet<>();
		for (int i = 0; i < relation.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int picked : pickedList) {
				sb.append(relation[i][picked]);
				sb.append(SEPERATE);
			}
			if (!set.contains(sb.toString())) {
				set.add(sb.toString());
			} else {
				return false;
			}
		}

		return minimal(candidate.toString());
	}
}
