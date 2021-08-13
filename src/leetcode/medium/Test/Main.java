package leetcode.medium.Test;

import java.util.HashMap;
import java.util.Map;

public class Main {
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);
	}
}

class Solution {
	public int[] solution(int[][] v) {
		int[] answer = new int[2];

		Map<Integer, Integer> mapRow = new HashMap<>();
		Map<Integer, Integer> mapCol = new HashMap<>(); 

		for (int i = 0; i < 3; i++) {
			mapRow.put(v[i][0], mapRow.getOrDefault((v[i][0]), 0) + 1);
			mapCol.put(v[i][1], mapCol.getOrDefault((v[i][1]), 0) + 1);
		}

		for (Map.Entry<Integer, Integer> m : mapRow.entrySet()) {
			if (m.getValue() == 1) {
				answer[0] = m.getKey();
			}
		}

		for (Map.Entry<Integer, Integer> m : mapCol.entrySet()) {
			if (m.getValue() == 1) {
				answer[1] = m.getKey();
			}
		}

		return answer;
	}
}