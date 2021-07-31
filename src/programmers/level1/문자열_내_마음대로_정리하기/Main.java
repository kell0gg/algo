package programmers.level1.문자열_내_마음대로_정리하기;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {

	}
}

class Solution {
	public String[] solution(String[] strings, int n) {
		Arrays.sort(strings, (a, b) -> {
			if (a.charAt(n) == b.charAt(n)) {
				return a.compareTo(b);
			}
			else {
				return a.charAt(n) - b.charAt(n);
			}
		});
		return strings;
	}
}
