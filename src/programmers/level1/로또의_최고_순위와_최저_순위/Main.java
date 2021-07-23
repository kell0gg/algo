package programmers.level1.로또의_최고_순위와_최저_순위;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] a = solution.solution(new int[] { 44, 1, 0, 0, 31, 25 }, new int[] { 31, 10, 45, 1, 6, 19 });
		for (int i : a) {
			System.out.println(i);
		}
	}
}

class Solution {
	private static Map<Integer, Integer> MAP = new HashMap<>();

	public int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];
		initMap();
		Set<Integer> set = new HashSet<>();
		int zeroCount = 0;
		int winCount = 0;

		for (int i = 0; i < win_nums.length; i++) {
			set.add(win_nums[i]);
		}

		for (int i = 0; i < lottos.length; i++) {
			if (lottos[i] == 0) {
				zeroCount++;
			} else {
				if (set.contains(lottos[i])) {
					winCount++;
				}
			}
		}

		int max = zeroCount + winCount;
		int min = winCount;

		answer[0] = MAP.getOrDefault(max, 6);
		answer[1] = MAP.getOrDefault(min, 6);

		return answer;
	}

	private void initMap() {
		MAP.put(6, 1);
		MAP.put(5, 2);
		MAP.put(4, 3);
		MAP.put(3, 4);
		MAP.put(2, 5);
	}
}
