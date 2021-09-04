package programmers.level2.위장;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		Solution solution = new Solution();
		solution.solution(clothes);
	}
}

class Solution {
	public int solution(String[][] clothes) {
		long answer = 1;

		Map<String, Long> map = Arrays.stream(clothes).map(v -> v[1])
				.collect(Collectors.groupingBy(k -> k, Collectors.counting()));

		for (Map.Entry<String, Long> e : map.entrySet()) {
			answer *= (e.getValue() + 1);
		}
		return (int) (answer - 1);
	}
}