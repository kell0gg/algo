package programmers.level1.문자열_내림차순으로_배치하기;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		String tmp = solution.solution("aZbcdefg");
		System.out.println(tmp);
	}
}

class Solution {
	public String solution(String s) {

		List<Character> lc = new ArrayList<>();

		for (int i = 0; i < s.length(); i++) {
			lc.add(s.charAt(i));
		}

		Collections.sort(lc, (a, b) -> {
			return b - a;
		});

		StringBuilder sb = new StringBuilder();
		lc.forEach(a -> sb.append(a));

		return sb.toString();
	}
}