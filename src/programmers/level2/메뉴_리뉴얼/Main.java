package programmers.level2.메뉴_리뉴얼;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(new String[] { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" }, new int[] { 2, 3, 4 });
	}
}

class Solution {
	private static List<NewCourse> TMP = new ArrayList<>();
	private static int MAX = -1;

	public String[] solution(String[] orders, int[] course) {
		List<String> answerList = new ArrayList<>();
		Set<Character> set = new HashSet<>();

		for (String order : orders) {
			for (int i = 0; i < order.length(); i++) {
				set.add(order.charAt(i));
			}
		}

		List<Character> lists = new ArrayList<>(set);

		for (int i = 0; i < course.length; i++) {
			TMP = new ArrayList<>();
			MAX = -1;
			Deque<Integer> q = new ArrayDeque<>();
			combination(q, lists.size(), course[i], 0, orders, lists);

			for (NewCourse t : TMP) {
				if (t.count == MAX) {
					answerList.add(t.menu);
				}
			}
		}

		Collections.sort(answerList);

		return answerList.stream().toArray(size -> new String[size]);
	}

	private void combination(Deque<Integer> q, int n, int k, int depth, String[] orders, List<Character> lists) {
		if (q.size() == k) {
			StringBuilder sb = new StringBuilder();
			q.forEach(a -> {
				sb.append(lists.get(a));
			});

			int count = countOrder(orders, sb.toString());
			if (count >= 2) {
				TMP.add(new NewCourse(count, sb.toString()));
				MAX = Math.max(MAX, count);
			}

			return;
		}

		for (int i = depth; i < n; i++) {
			q.addLast(i);
			combination(q, n, k, i + 1, orders, lists);
			q.pollLast();
		}
	}

	private int countOrder(String[] orders, String menu) {
		int count = 0;
		for (String order : orders) {
			if (checkCourse(order, menu)) {
				count++;
			}
		}
		return count;
	}

	private boolean checkCourse(String order, String menu) {
		for (int i = 0; i < menu.length(); i++) {
			if (order.indexOf(menu.charAt(i)) == -1) {
				return false;
			}
		}
		return true;
	}
}

class NewCourse {
	int count;
	String menu;

	public NewCourse(int count, String menu) {
		this.count = count;
		this.menu = menu;
	}
}