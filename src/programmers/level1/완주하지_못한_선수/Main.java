package programmers.level1.완주하지_못한_선수;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		String ans = solution.solution(new String[] { "leo", "kiki", "eden" }, new String[] { "leo", "kiki" });
		System.out.println(ans);
	}
}

class Solution {
	public String solution(String[] participant, String[] completion) {
		Map<String, Long> map = Arrays.stream(participant)
				.collect(Collectors.groupingBy(a -> a, Collectors.counting()));

		for (String c : completion) {
			if (map.get(c) == 1L) {
				map.remove(c);
			} else {
				map.put(c, map.get(c) - 1);
			}
		}

		return map.entrySet().iterator().next().getKey();
	}
}

class Solution_2 {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		Map<String, Integer> map = new HashMap<>();
		for (String p : participant) {
			map.put(p, map.getOrDefault(p, 0) + 1);
		}
		for (String c : completion) {
			if (map.get(c) == 1) {
				map.remove(c);
			} else {
				map.put(c, map.get(c) - 1);
			}
		}

		for (Map.Entry<String, Integer> m : map.entrySet()) {
			answer = m.getKey();
		}
		return answer;
	}
}