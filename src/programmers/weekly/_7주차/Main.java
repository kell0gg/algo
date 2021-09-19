package programmers.weekly._7주차;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.solution(new int[] { 3, 2, 1 }, new int[] { 1, 3, 2 });
	}
}

class Solution {
	public int[] solution(int[] enter, int[] leave) {
		int[] answer = new int[enter.length];

		Set<Integer> meetingRoom = new HashSet<>();
		Map<Integer, Integer> count = new HashMap<>();

		for (int i : enter) {
			count.putIfAbsent(i, 0);
		}
		int leaveIdx = 0;

		for (int i = 0; i < enter.length; i++) {
			int in = enter[i];
			meetingRoom.forEach(inner -> {
				count.put(inner, count.getOrDefault(inner, 0) + 1);
			});
			count.put(in, meetingRoom.size());
			meetingRoom.add(in);

			while (leaveIdx < leave.length && meetingRoom.contains(leave[leaveIdx])) {
				meetingRoom.remove(leave[leaveIdx]);
				leaveIdx++;
			}
		}

		for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
			answer[entry.getKey() - 1] = entry.getValue();
		}
		return answer;
	}
}