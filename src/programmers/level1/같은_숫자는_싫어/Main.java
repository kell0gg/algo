package programmers.level1.같은_숫자는_싫어;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(new int[] { 1, 3, 3, 3, 4, 5 });
	}
}

class Solution {
	public int[] solution(int[] arr) {
		int before = -1;
		List<Integer> lists = new ArrayList<>();
		for (int current : arr) {
			if (before != current) {
				before = current;
				lists.add(current);
			} else {
				before = current;
			}
		}

		return lists.stream().mapToInt(a -> a).toArray();
	}
}
