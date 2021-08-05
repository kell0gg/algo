package programmers.level1.정수_내림차순으로_배치하기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		long tmp = solution.solution(118372);
		System.out.println(tmp);
	}
}

class Solution {
	public long solution(long n) {
		StringBuilder sb = new StringBuilder();
		List<Integer> lists = new ArrayList<>();
		while (n != 0) {
			int remains = (int) (n % 10);
			lists.add(remains);
			n /= 10;
		}
		Collections.sort(lists, (a, b) -> {
			return b - a;
		});

		lists.forEach(a -> sb.append(a));
		return Long.parseLong(sb.toString());
	}
}