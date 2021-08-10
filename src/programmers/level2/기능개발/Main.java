package programmers.level2.기능개발;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(new int[] { 95, 90, 99, 99, 80, 99 }, new int[] { 1, 1, 1, 1, 1, 1 });
	}
}

class Solution {
	public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> lists = new ArrayList<>();
		int[] remains = new int[progresses.length];
		for (int i = 0; i < remains.length; i++) {
			int tmp = (100 - progresses[i]) % speeds[i];
			if (tmp == 0) {
				remains[i] = (100 - progresses[i]) / speeds[i];
			} else {
				remains[i] = ((100 - progresses[i]) / speeds[i]) + 1;
			}
		}

		int current = remains[0];
		int count = 1;
		for (int i = 1; i < remains.length; i++) {
			if (current >= remains[i]) {
				count++;
			} else {
				lists.add(count);
				count = 1;
				current = remains[i];
			}
		}

		lists.add(count);

		return lists.stream().mapToInt(a -> a).toArray();
	}
}