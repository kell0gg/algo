package programmers.level2.단체사진_찍기;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(4, new String[] { "N~F=0", "R~T>2" });
	}
}

class Solution {
	private static int ANSWER = 0;

	public int solution(int n, String[] data) {
		ANSWER = 0;
		List<Character> list = new ArrayList<>();
		Deque<Character> dq = new ArrayDeque<>();
		Character[] tmp = { 'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T' };

		for (Character c : tmp) {
			list.add(c);
		}

		permutation(dq, list, data);

		return ANSWER;
	}

	private boolean check(String candidate, String[] data) {

		for (String cond : data) {
			if (!checkImpl(candidate, cond)) {
				return false;
			}
		}

		return true;
	}

	private boolean checkImpl(String candidate, String cond) {
		char a = cond.charAt(0);
		char b = cond.charAt(2);
		int dist = cond.charAt(4) - '0';
		char operator = cond.charAt(3);

		int cd = Math.abs(candidate.indexOf(a) - candidate.indexOf(b)) - 1;

		if (operator == '=') {
			if (cd == dist) {
				return true;
			}
		}

		if (operator == '<') {
			if (cd < dist) {
				return true;
			}
		}
		if (operator == '>') {
			if (cd > dist) {
				return true;
			}
		}

		return false;
	}

	private void permutation(Deque<Character> dq, List<Character> list, String[] data) {
		if (list.size() == 0) {
			StringBuilder sb = new StringBuilder();
			dq.forEach(a -> {
				sb.append(a);
			});

			if (check(sb.toString(), data)) {
				ANSWER++;
			}
			return;
		}

		for (int i = 0; i < list.size(); i++) {
			dq.addLast(list.remove(i));
			permutation(dq, list, data);
			list.add(i, dq.pollLast());
		}
	}
}